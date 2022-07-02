package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class EnderChest implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("enderchest")) {
			if (args.length == 0) {
				if (p.hasPermission("essentials.enderchest")) {
					p.openInventory(p.getEnderChest());
				}
				return false;
			}
			if (args.length >= 1) {
				if (VerificarGrupo.Moderacao(p)) {
					if (!Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						p.sendMessage(Main.off);
						return false;
					}

					Player target = Bukkit.getPlayer(args[0]);

					p.openInventory(target.getEnderChest());
					p.sendMessage(Main.Menssagems + "§fVoce abriu o enderchest de: §5" + target.getName() + " §f.");
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