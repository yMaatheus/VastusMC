package dev.vastusmc.essentials.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.systems.LocationUtil;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		final Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("spawn")) {
			Location loc = LocationUtil.getLocation(Main.plugin.getConfig().getString("spawn"));

			p.teleport(loc);
			p.sendMessage(Main.Menssagems + "§fVoc§ foi teleportado para o §eSpawn§f.");
			return false;
		}
		return false;
	}

}