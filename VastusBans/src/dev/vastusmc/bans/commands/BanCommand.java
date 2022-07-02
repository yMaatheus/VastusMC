package dev.vastusmc.bans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.bans.Main;
import dev.vastusmc.bans.api.HorarioAPI;
import dev.vastusmc.bans.api.IpApi;
import dev.vastusmc.bans.api.VerificarGrupo;
import dev.vastusmc.bans.systems.BanManager;

public class BanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ban")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (VerificarGrupo.Moderacao(p)) {
					if (args.length == 0) {
						p.sendMessage(Main.Menssagems + "§fUse: /ban (Jogador) (Motivo e Prova).");
						return true;
					} else {
						String msg = "";
						for (int i = 1; i < args.length; i++) {
							msg = msg + args[i] + " ";
						}
						if (msg == "") {
							sender.sendMessage(Main.Menssagems + "§fUse: /ban (Jogador) (Motivo e Prova).");
							return true;
						}
						String target = args[0].toLowerCase();
						String staffer = sender.getName();
						String horario = HorarioAPI.getHorario();
						BanManager.Banir(target, staffer, msg, IpApi.getIp(target), horario);
						p.sendMessage(Main.Menssagems + "§fVoc§ baniu: §5" + args[0].toLowerCase());
						return true;
					}
				} else {
					p.sendMessage("§cSem permiss§o.");
					return true;
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.Menssagems + "§fUse: /ban (Jogador) (Motivo e Prova).");
					return true;
				} else {
					String msg = "";
					for (int i = 1; i < args.length; i++) {
						msg = msg + args[i] + " ";
					}
					if (msg == "") {
						sender.sendMessage(Main.Menssagems + "§fUse: /ban (Jogador) (Motivo e Prova).");
						return true;
					}
					String target = args[0].toLowerCase();
					String staffer = sender.getName();
					String horario = HorarioAPI.getHorario();
					BanManager.Banir(target, staffer, msg, IpApi.getIp(target), horario);
					sender.sendMessage(Main.Menssagems + "§fVoc§ baniu: §5" + args[0].toLowerCase());
					return true;
				}
			}
		}
		return false;
	}

}
