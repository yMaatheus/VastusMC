package dev.vastusmc.rankup.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.rankup.Main;
import dev.vastusmc.rankup.api.VerificarGrupo;
import dev.vastusmc.rankup.systems.Arrays;
import dev.vastusmc.rankup.systems.PlayerPOO;

public class ResetRank implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("resetrank")) {
			if (sender instanceof Player) {
				Player p = (Player)sender;
				if (VerificarGrupo.Gerentecia(p)) {
					if (args.length == 0) {
						sender.sendMessage(Main.Mensagens + "§fUse: /resetrank (Jogador).");
						return true;
					} else {
						if (Arrays.playerdados.containsKey(args[0].toLowerCase())) {
							sender.sendMessage("Jogador n§o est§ registrado no sistema.");
							return true;
						}
						PlayerPOO player = Arrays.playerdados.get(args[0].toLowerCase());
						player.rank = 1;
						player.save = true;
						Arrays.playerdados.put(args[0].toLowerCase(), player);
						return true;
					}
				} else {
					p.sendMessage("§cSem permiss§o.");
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.Mensagens + "§fUse: /resetrank (Jogador).");
					return true;
				} else {
					if (Arrays.playerdados.containsKey(args[0].toLowerCase())) {
						sender.sendMessage("Jogador n§o est§ registrado no sistema.");
						return true;
					}
					PlayerPOO player = Arrays.playerdados.get(args[0].toLowerCase());
					player.rank = 1;
					player.save = true;
					Arrays.playerdados.put(args[0].toLowerCase(), player);
					return true;
				}
			}
		}
		return false;
	}

}
