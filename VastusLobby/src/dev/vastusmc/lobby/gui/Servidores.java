package dev.vastusmc.lobby.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.vastusmc.lobby.systems.BungeeAPI;

public class Servidores implements Listener {

	public static void InventarioServer(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, InventoryType.CHEST, "§5§lVastusMC");

		ItemStack rankup = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta rankupmeta = rankup.getItemMeta();
		rankupmeta.setDisplayName("§eRankUP");
		ArrayList<String> descrankup = new ArrayList<String>();
		descrankup.add("");
		descrankup.add("§7Venha e fa§a sua historia, divirta-se com seus amigos");
		descrankup.add("§7e realize batalhas com todos pela frente!");
		descrankup.add("");
		rankupmeta.setLore(descrankup);
		rankup.setItemMeta(rankupmeta);

		inv.setItem(10, rankup);

		p.openInventory(inv);
		
		ItemStack fullpvp = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta fullpvpmeta = fullpvp.getItemMeta();
		fullpvpmeta.setDisplayName("§eFullPvP");
		ArrayList<String> descfullpvp = new ArrayList<String>();
		descfullpvp.add("");
		descfullpvp.add("§7Em Breve!");
		descfullpvp.add("");
		fullpvpmeta.setLore(descfullpvp);
		fullpvp.setItemMeta(fullpvpmeta);

		inv.setItem(12, fullpvp);
		
		ItemStack build = new ItemStack(Material.BRICK);
		ItemMeta buildmeta = build.getItemMeta();
		buildmeta.setDisplayName("§eBuild");
		ArrayList<String> descbuild = new ArrayList<String>();
		descbuild.add("");
		descbuild.add("§7Servidor apenas para construtores!");
		descbuild.add("");
		buildmeta.setLore(descbuild);
		build.setItemMeta(buildmeta);

		inv.setItem(0, build);

		p.openInventory(inv);
		p.updateInventory();
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.COMPASS) {
			InventarioServer(p);
			p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 15.5F, 15.5F);
		}

	}
	
	@EventHandler
	public void naomexer(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("§5§lVastusMC")) {
			e.setCancelled(true);
		}
		if (e.getCurrentItem() == null) {
			return;
		}
		if (e.getCurrentItem().getType() == Material.AIR) {
			return;
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eRankUP")) {
			BungeeAPI.teleportToServer(p, "rankup");
			return;
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eFullPvP")) {
			return;
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eBuild")) {
			BungeeAPI.teleportToServer(p, "build");
			return;
		}
	}
}