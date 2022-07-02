package dev.vastusmc.reports.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import dev.vastusmc.reports.systems.Arrays;

public class ReportsInvetory implements Listener {
	
	@SuppressWarnings("deprecation")
	public static void Open(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 6*9, "§cReports List");
		for (String item : Arrays.Reports) {
			ItemStack cabeca = new ItemStack(397, 1, (short) 3);
			SkullMeta cabecaskull = (SkullMeta) cabeca.getItemMeta();
			cabecaskull.setOwner(item);
			cabecaskull.setDisplayName("§fJogador: §e" + item.toString().replace("]", "").replace("[", ""));
			cabecaskull.setLore(java.util.Arrays.asList("§fReports: §e" + Arrays.ReportsContagem.get(item)));
			cabeca.setItemMeta(cabecaskull);
			inv.addItem(cabeca);
			p.updateInventory();
		}
		p.openInventory(inv);
	}
	
	@EventHandler
	public void naomexer(InventoryClickEvent e) {
		 if(e.getInventory().getName().equalsIgnoreCase("§cReports List")){
			e.setCancelled(true);
		}
	}

}
