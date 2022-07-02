package dev.vastusmc.reparador.systems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import dev.vastusmc.reparador.Main;
import dev.vastusmc.reparador.gui.InventoryApi;

public class Events implements Listener {

	@SuppressWarnings("static-access")
	@EventHandler
	public void naomexer(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§aReparadorInventory")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eReparar Item")) {
				if (Main.economy.getBalance(p) < Main.plugin.getConfig().getInt("Custo")) {
					p.sendMessage("§cVoc§ n§o tem dinheiro suficiente para reparar o item que est§ na sua m§o.");
					return;
				}
				Main.plugin.economy.withdrawPlayer(p, Main.plugin.getConfig().getInt("Custo"));
				p.getInventory().getItemInHand().setDurability((short) 0);
				p.closeInventory();
				return;
			}
		}
	}

	@EventHandler
	public void onInteracao(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Villager) {
			Villager villager = (Villager) e.getRightClicked();
			Player p = e.getPlayer();
			if (villager.getCustomName() != null) {
				if (villager.getCustomName().contains("§aReparador")) {
					e.setCancelled(true);
					InventoryApi.openReparador(p);
				}
			}
		}
	}

	@EventHandler
	public void onVillagerDano(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Villager))
			return;
		Villager villager = (Villager) e.getEntity();
		if (villager.getCustomName() != null) {
			if (villager.getCustomName().contains("§aReparador")) {
				e.setCancelled(true);
				if (e.getDamager() instanceof Player) {
					Player p = (Player) e.getDamager();
					if (p.getItemInHand().getType() == Material.GOLD_PICKAXE) {
						villager.damage(1000);
						villager.remove();
					}
				}
			}
		}
	}

}