package dev.vastusmc.essentials.commands;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;

public class Tpaccept implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, Command command, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}

		final Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("tpaccept")) {
			if (!(Tpa.teleport.containsKey(p.getName()))) {
				p.sendMessage(Main.Menssagems + "§fVoc§ n§o tem um pedido de teleporte");
				return false;
			}

			String tpaenviadoPor = "null";

			for (Entry<String, String> todos : Tpa.teleport.entrySet()) {

				if (todos.getKey().contains(p.getName())) {
					tpaenviadoPor = todos.getValue();
				}
			}

			Tpa.teleport.remove(p.getName());
			Bukkit.getPlayer(tpaenviadoPor).teleport(p.getLocation());
			Bukkit.getPlayer(tpaenviadoPor).sendMessage(Main.Menssagems + "§fSeu pedido de teleporte foi aceito, teleportando...");
			p.sendMessage(Main.Menssagems + "§fVoc§ aceitou o pedido de teleporte.");
			return false;
		}

		return false;
	}
}