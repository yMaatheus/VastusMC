package dev.vastusmc.reports.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.reports.Main;
import dev.vastusmc.reports.api.VerificarGrupo;
import dev.vastusmc.reports.systems.Arrays;

public class Silent implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("silent")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (Arrays.Silent.contains(p.getName())) {
					Arrays.Silent.remove(p.getName());
					p.sendMessage(Main.Menssagems + "§fVoc§ saiu no modo §5Silent§f.");
					return true;
				} else {
					Arrays.Silent.add(p.getName());
					p.sendMessage(Main.Menssagems + "§fVoc§ entrou no modo §5Silent§f.");
					return true;
				}
			}
		}

		return false;
	}
}
