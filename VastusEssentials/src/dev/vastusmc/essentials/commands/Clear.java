package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Clear implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("clear")) {
			if (args.length == 0) {
				p.getInventory().clear();
				p.getInventory().setHelmet(null);
				p.getInventory().setChestplate(null);
				p.getInventory().setLeggings(null);
				p.getInventory().setBoots(null);
				p.sendMessage(Main.Menssagems + "§fSeu Inventario Foi Limpo.");
				return false;
			}
			if (args.length >= 1) {
				if (VerificarGrupo.Administracao(p)) {
					if (!Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						p.sendMessage(Main.off);
						return false;
					}
					Player target = Bukkit.getPlayer(args[0]);
					target.getInventory().clear();
					target.getInventory().setHelmet(null);
					target.getInventory().setChestplate(null);
					target.getInventory().setLeggings(null);
					target.getInventory().setBoots(null);
					target.sendMessage(Main.Menssagems + "§fSeu Inventario Foi Limpo.");
					p.sendMessage(Main.Menssagems + "§fVoc§ limpou o invent§rio de §5" + args[0] + "§f.");
					return false;
				} else {
					p.sendMessage(Main.nperm);
					return true;
				}
			}
		}
		return false;
	}

}
