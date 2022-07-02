package dev.vastusmc.bans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.bans.Main;
import dev.vastusmc.bans.api.VerificarGrupo;
import dev.vastusmc.bans.systems.BanManager;

public class CheckBanCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("checkban")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (VerificarGrupo.Moderacao(p)) {
					if (args.length == 0) {
						sender.sendMessage(Main.Menssagems + "§fUse: /checkban (Jogador).");
						return true;
					} else {
						String staffer = sender.getName();
						String target = args[0].toLowerCase();
						BanManager.CheckBan(target, staffer, false);
						return true;
					}
				} else {
					sender.sendMessage("§cSem permiss§o.");
					return true;
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.Menssagems + "§fUse: /checkban (Jogador).");
					return true;
				} else {
					String staffer = sender.getName();
					String target = args[0].toLowerCase();
					BanManager.CheckBan(target, staffer, true);
					return true;
				}
			}
		}
		return false;
	}

}
