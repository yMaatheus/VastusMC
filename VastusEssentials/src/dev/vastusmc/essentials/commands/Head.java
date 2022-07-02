package dev.vastusmc.essentials.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Head implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (p.getName().equalsIgnoreCase("head")) {
			if (VerificarGrupo.Coordenacao(p)) {
				if (args.length == 0) {
					p.sendMessage(Main.Menssagems + "§fUse /head  (Jogador)");
				}
				if (args.length > 0) {
					ItemStack C1 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta sm = (SkullMeta) C1.getItemMeta();
					sm.setOwner(args[0]);
					sm.setDisplayName(args[0]);
					sm.setDisplayName("§c" + args[0]);
					C1.setItemMeta(sm);
					p.getInventory().addItem(new ItemStack[] { C1 });
					p.updateInventory();
				}
			} else {
				p.sendMessage(Main.nperm);
				return true;
			}
		}
		return false;
	}
}
