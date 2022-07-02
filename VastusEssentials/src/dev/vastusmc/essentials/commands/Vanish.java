package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;
import dev.vastusmc.essentials.systems.Arrays;

public class Vanish implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		Player p = (Player) sender;
		if (command.getName().equalsIgnoreCase("vanish")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (Arrays.Invisivel.contains(p)) {
					Arrays.Invisivel.remove(p);
					Arrays.god.remove(p);
					for (Player todos : Bukkit.getOnlinePlayers()) {
						todos.showPlayer(p);
					}
					p.sendMessage(Main.Menssagems + "§fVoc§ agora est§ §5Visivel§f.");
					p.getInventory().clear();
					return true;
				}
				if (Arrays.Invisivel.contains(p) == false) {
					Arrays.Invisivel.add(p);
					Arrays.god.add(p);
					for (Player todos : Bukkit.getOnlinePlayers()) {
						if (VerificarGrupo.Moderacao(todos)) {
							todos.showPlayer(p);
						}
						if (VerificarGrupo.Moderacao(todos) == false) {
							todos.hidePlayer(p);
						}
					}
					p.sendMessage(Main.Menssagems + "§fVoc§ agora est§ §5Invisivel§f.");
					p.getInventory().clear();
					return false;
				}
			} else {
				p.sendMessage(Main.nperm);
				return true;
			}
		}

		return false;
	}

}