package dev.vastusmc.reparador.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.vastusmc.reparador.Main;

public class InventoryApi {
	
	public static void openReparador(Player p) {
		Inventory reparadorgui = Bukkit.getServer().createInventory(p, 1 * 9, "§aReparadorInventory");

		ItemStack RepararItem = new ItemStack(Material.ANVIL);
		ItemMeta RepararItemm = RepararItem.getItemMeta();
		RepararItemm.setDisplayName("§eReparar Item");
		ArrayList<String> desc = new ArrayList<String>();
		desc.add("");
		desc.add("§7Repare o item");
		desc.add("§7da sua m§o.");
		desc.add("");
		desc.add("§cPre§o: §f" + Main.plugin.getConfig().getInt("Custo"));
		desc.add("");
		RepararItemm.setLore(desc);
		RepararItem.setItemMeta(RepararItemm);

		reparadorgui.setItem(4, RepararItem);
		p.openInventory(reparadorgui);
		p.updateInventory();
	}

}
