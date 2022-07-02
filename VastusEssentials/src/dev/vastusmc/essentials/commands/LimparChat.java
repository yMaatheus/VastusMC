package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;

public class LimparChat implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("limparchat")) {
			if (p.hasPermission("essentials.limparchat")) {
				for (int i = 0; i < 100; i++) {
					for (Player s : Bukkit.getOnlinePlayers()) {
						s.sendMessage("");
					}
				}
				for (Player s : Bukkit.getOnlinePlayers()) {
					s.sendMessage(Main.Menssagems + "§fChat limpo por: §5" + p.getName());
				}
			}
		}
		return false;
	}
}