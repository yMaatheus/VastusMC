package dev.vastusmc.bans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.bans.Main;
import dev.vastusmc.bans.api.VerificarGrupo;
import dev.vastusmc.bans.systems.BanManager;

public class KickCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (VerificarGrupo.Moderacao(p)) {
					if (args.length == 0) {
						sender.sendMessage(Main.Menssagems + "§fUse: /kick (Jogador) (Motivo e Prova).");
						return true;
					} else {
						String msg = "";
						for (int i = 1; i < args.length; i++) {
							msg = msg + args[i] + " ";
						}
						if (msg == "") {
							sender.sendMessage(Main.Menssagems + "§fUse: /kick (Jogador) (Motivo e Prova).");
							return true;
						}
						String jogador = args[0].toLowerCase();
						String por = sender.getName();
						BanManager.Kickar(jogador, por, msg);
						sender.sendMessage(Main.Menssagems + "§fVoc§ expulsou: §5" + jogador);
						return true;
					}
				} else {
					sender.sendMessage("§cSem permiss§o.");
					return true;
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.Menssagems + "§fUse: /kick (Jogador) (Motivo e Prova).");
					return true;
				} else {
					String msg = "";
					for (int i = 1; i < args.length; i++) {
						msg = msg + args[i] + " ";
					}
					if (msg == "") {
						sender.sendMessage(Main.Menssagems + "§fUse: /kick (Jogador) (Motivo e Prova).");
						return true;
					}
					String jogador = args[0].toLowerCase();
					String por = sender.getName();
					BanManager.Kickar(jogador, por, msg);
					sender.sendMessage(Main.Menssagems + "§fVoc§ expulsou: §5" + jogador);
					return true;
				}
			}
		}
		return false;
	}

}
