package dev.vastusmc.essentials.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;
import dev.vastusmc.essentials.systems.LocationUtil;

public class Set implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		if (Sender instanceof Player) {
			Player player = (Player) Sender;

			if (VerificarGrupo.Gerentecia(player) == false) {
				player.sendMessage(Main.nperm);
				return true;
			}

			if (Args.length == 0) {
				player.sendMessage(Main.Menssagems + "§fUse /set (Spawn§7|§fJail)");
				return true;
			}

			if (Args[0].equalsIgnoreCase("spawn")) {
				Location local = new Location(player.getWorld(), player.getLocation().getX() + 0.500, player.getLocation().getY(), player.getLocation().getZ() + 0.500);

				Main.plugin.getConfig().set("spawn", LocationUtil.getString(local));
				Main.plugin.saveConfig();

				player.sendMessage(Main.Menssagems + "§5Spawn, §7Local setado com sucesso");

				return true;
			}

			if (Args[0].equalsIgnoreCase("jail")) {

				Location local = new Location(player.getWorld(), player.getLocation().getX() + 0.500,
						player.getLocation().getY(), player.getLocation().getZ() + 0.500);

				Main.plugin.getConfig().set("jail", LocationUtil.getString(local));
				Main.plugin.saveConfig();

				player.sendMessage(Main.Menssagems + "§5Jail, §7Local setado com sucesso");

				return true;
			}
		}
		return false;
	}

}