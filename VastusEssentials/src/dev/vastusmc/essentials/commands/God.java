package dev.vastusmc.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;
import dev.vastusmc.essentials.systems.Arrays;

public class God implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("god")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (Arrays.god.contains(p)) {
					Arrays.god.remove(p);
					p.sendMessage(Main.Menssagems + "§fVocê não esta mais no modo §5GOD");
					return true;
				} else {
					Arrays.god.add(p);
					p.sendMessage(Main.Menssagems + "§fVocê agora esta no modo §5GOD");
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
