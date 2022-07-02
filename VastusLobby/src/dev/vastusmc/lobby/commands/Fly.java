package dev.vastusmc.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.lobby.Main;
import dev.vastusmc.lobby.api.VerificarGrupo;

public class Fly implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("fly")) {
			if (VerificarGrupo.Vips(p)) {
				if (p.getAllowFlight()) {
					p.setAllowFlight(false);
					p.sendMessage(Main.Mensagens + "§fSeu fly foi §edesativado§f.");
				} else {
					p.setAllowFlight(true);
					p.sendMessage(Main.Mensagens + "§fSeu fly foi §eativado§f.");
				}
				return true;
			} else {
				p.sendMessage("§cSem permiss§o.");
			}
		}
		return false;
	}

}
