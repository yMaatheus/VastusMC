package dev.vastusmc.fragmentos.systems;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Events implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (e.getBlock().getType() == Material.LAPIS_BLOCK || e.getBlock().getType() == Material.LAPIS_ORE) {
			Player p = e.getPlayer();
			int radom = new Random().nextInt(100);
			if (radom == 20) {
				Random r = new Random();
				switch (r.nextInt(2)) {
				case 1:
					ItemStack nether = new ItemStack(Material.NETHER_STAR, 1);
					ItemMeta netherm = nether.getItemMeta();
					netherm.addEnchant(Enchantment.DURABILITY, 1, true);
					nether.setItemMeta(netherm);
					p.getInventory().addItem(nether);
					break;
				case 2:
					ItemStack perola = new ItemStack(Material.ENDER_PEARL, 1);
					ItemMeta perolam = perola.getItemMeta();
					perolam.addEnchant(Enchantment.DURABILITY, 1, true);
					perola.setItemMeta(perolam);
					p.getInventory().addItem(perola);
					break;
				}
				return;
			}
			if (radom == 1) {
				Random r = new Random();
				switch (r.nextInt(2)) {
				case 1:
					ItemStack forca = new ItemStack(Material.POTION, 1, (short) 8233);
					p.getInventory().addItem(forca);
					break;
				case 2:
					ItemStack velocidade = new ItemStack(Material.POTION, 1, (short) 8226);
					p.getInventory().addItem(velocidade);
					break;
				}
				return;
			}
		}
	}

}
