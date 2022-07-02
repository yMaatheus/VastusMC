package dev.vastusmc.bans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.bans.Main;
import dev.vastusmc.bans.api.VerificarGrupo;
import dev.vastusmc.bans.systems.Arrays;
import dev.vastusmc.bans.systems.BanManager;

public class UnBanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("unban")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (VerificarGrupo.Administracao(p)) {
					if (args.length == 0) {
						sender.sendMessage(Main.Menssagems + "§fUse: /unban (Jogador).");
						return true;
					} else {
						if (Arrays.playerdados.containsKey(args[0].toLowerCase()) == false) {
							sender.sendMessage("§cEsse jogador n§o est§ banido.");
							return true;
						}
						String jogador = args[0].toLowerCase();
						String staffer = sender.getName();
						BanManager.DesBanir(jogador, staffer);
						sender.sendMessage(Main.Menssagems + "§fVoc§ desbaniu: §5" + jogador);
						return true;
					}
				} else {
					sender.sendMessage("§cSem permiss§o.");
					return true;
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.Menssagems + "§fUse: /unban (Jogador).");
					return true;
				} else {
					if (Arrays.playerdados.containsKey(args[0].toLowerCase()) == false) {
						sender.sendMessage("§cEsse jogador n§o est§ banido.");
						return true;
					}
					String jogador = args[0].toLowerCase();
					String staffer = sender.getName();
					BanManager.DesBanir(jogador, staffer);
					sender.sendMessage(Main.Menssagems + "§fVoc§ desbaniu: §5" + jogador);
					return true;
				}
			}
		}
		return false;
	}

}
