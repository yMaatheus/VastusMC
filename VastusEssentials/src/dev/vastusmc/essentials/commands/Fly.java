package dev.vastusmc.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Fly implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("fly")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (p.getAllowFlight() == false) {
					p.sendMessage(Main.Menssagems + " §fFly §5Ativado");
					p.setAllowFlight(true);
					return true;
				} else {
					p.sendMessage(Main.Menssagems + " §fFly §5Desativado");
					p.setAllowFlight(false);
					return true;
				}
			}
			if (p.hasPermission("essentials.fly")) {
				if (p.getWorld().getName().equalsIgnoreCase(Main.plotworld)) {
					if (p.getAllowFlight() == false) {
						p.sendMessage(Main.Menssagems + " §fFly §5Ativado");
						p.setAllowFlight(true);
						return true;
					} else {
						p.sendMessage(Main.Menssagems + " §fFly §5Desativado");
						p.setAllowFlight(false);
						return true;
					}
				} else {
					p.sendMessage("§cFly pode ser ativado apenas no mundo das plots.");
					return true;
				}
			} else {
				p.sendMessage(Main.nperm);
				return true;
			}
		}
		return false;
	}
}