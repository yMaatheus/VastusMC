package dev.vastusmc.caixas.systems;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import dev.vastusmc.caixas.Main;
import dev.vastusmc.caixas.gui.InventoryGui;

public class Events implements Listener {

	public static ArrayList<Player> RecebendoItem = new ArrayList<>();

	@EventHandler
	public void ClickarNoEnderChest(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand().getType() == Material.CHEST) {
			if (p.getItemInHand().getItemMeta().getDisplayName() == "§eCaixa Minerador") {
				RecebendoItem.add(p);
				e.setCancelled(true);
				if (p.getInventory().getItemInHand().getAmount() > 1) {
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() - 1);
				} else {
					ItemStack CaixaMinerador = new ItemStack(Material.CHEST);
					ItemMeta CaixaMinerador_Meta = CaixaMinerador.getItemMeta();
					CaixaMinerador_Meta.setDisplayName("§eCaixa Minerador");

					CaixaMinerador.setItemMeta(CaixaMinerador_Meta);
					p.getInventory().remove(CaixaMinerador);
				}
				int r = new Random().nextInt(CaixaMisteriosaManager.itensMinerador.size());
				CaixaMisteriosaManager.itensMinerador.get(r);
				p.getInventory().addItem(CaixaMisteriosaManager.itensMinerador.get(r));
				new BukkitRunnable() {

					@Override
					public void run() {
						RecebendoItem.remove(p);
					}
				}.runTaskLater(Main.plugin, 40);
				return;
			}

			if (p.getItemInHand().getItemMeta().getDisplayName() == "§6Caixa Basica") {
				RecebendoItem.add(p);
				e.setCancelled(true);
				if (p.getInventory().getItemInHand().getAmount() > 1) {
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() - 1);
				} else {
					ItemStack CaixaBasica = new ItemStack(Material.CHEST);
					ItemMeta CaixaBasica_Meta = CaixaBasica.getItemMeta();
					CaixaBasica_Meta.setDisplayName("§6Caixa Basica");

					CaixaBasica.setItemMeta(CaixaBasica_Meta);
					p.getInventory().remove(CaixaBasica);
				}
				int r = new Random().nextInt(CaixaMisteriosaManager.itensBasica.size());
				CaixaMisteriosaManager.itensBasica.get(r);
				p.getInventory().addItem(CaixaMisteriosaManager.itensBasica.get(r));
				new BukkitRunnable() {

					@Override
					public void run() {
						RecebendoItem.remove(p);
					}
				}.runTaskLater(Main.plugin, 40);
				return;
			}
			return;
		}

		if (p.getItemInHand().getType() == Material.ENDER_CHEST) {
			if (p.getItemInHand().getItemMeta().getDisplayName() == "§5Caixa Media") {
				e.setCancelled(true);
				RecebendoItem.add(p);
				if (p.getInventory().getItemInHand().getAmount() > 1) {
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() - 1);
				} else {
					ItemStack CaixaMedia = new ItemStack(Material.ENDER_CHEST);
					ItemMeta CaixaMedia_Meta = CaixaMedia.getItemMeta();
					CaixaMedia_Meta.setDisplayName("§5Caixa Media");

					CaixaMedia.setItemMeta(CaixaMedia_Meta);
					p.getInventory().remove(CaixaMedia);
				}
				int r = new Random().nextInt(CaixaMisteriosaManager.itensMedia.size());
				CaixaMisteriosaManager.itensMedia.get(r);
				p.getInventory().addItem(CaixaMisteriosaManager.itensMedia.get(r));
				new BukkitRunnable() {

					@Override
					public void run() {
						RecebendoItem.remove(p);
					}
				}.runTaskLater(Main.plugin, 40);
				return;
			}

			if (p.getItemInHand().getItemMeta().getDisplayName() == "§cCaixa Futurista") {
				e.setCancelled(true);
				RecebendoItem.add(p);
				if (p.getInventory().getItemInHand().getAmount() > 1) {
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() - 1);
				} else {
					ItemStack CaixaFuturista = new ItemStack(Material.ENDER_CHEST);
					ItemMeta CaixaFuturista_Meta = CaixaFuturista.getItemMeta();
					CaixaFuturista_Meta.setDisplayName("§cCaixa Futurista");

					CaixaFuturista.setItemMeta(CaixaFuturista_Meta);
					p.getInventory().remove(CaixaFuturista);
				}
				int r = new Random().nextInt(CaixaMisteriosaManager.itensFuturista.size());
				CaixaMisteriosaManager.itensFuturista.get(r);
				p.getInventory().addItem(CaixaMisteriosaManager.itensFuturista.get(r));
				new BukkitRunnable() {

					@Override
					public void run() {
						RecebendoItem.remove(p);
					}
				}.runTaskLater(Main.plugin, 40);
				return;
			}
			return;
		}
		return;
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (RecebendoItem.contains(p)) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("§e§lCaixas")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eCaixa Minerador")) {
				InventoryGui.OpenCaixaMinerador(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§6Caixa Basica")) {
				InventoryGui.OpenCaixaBasica(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§5Caixa Media")) {
				InventoryGui.OpenCaixaMedia(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cCaixa Futurista")) {
				InventoryGui.OpenCaixaFuturista(p);
				return;
			}
		}
	}
}