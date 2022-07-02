package dev.vastusmc.reports.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.reports.Main;
import dev.vastusmc.reports.api.VerificarGrupo;
import dev.vastusmc.reports.gui.ReportsInvetory;

public class Reports implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("reports")) {
			if (VerificarGrupo.Moderacao(p)) {
				ReportsInvetory.Open(p);
				p.sendMessage(Main.Menssagems + "§fVoc§ abriu a lista de reports.");
				return true;
			}
		}
		return false;
	}

}
