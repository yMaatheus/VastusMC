package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Tphere implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		Player p = (Player) sender;
		if (command.getName().equalsIgnoreCase("tphere")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (args.length == 0) {
					p.sendMessage(Main.Menssagems + "§fUse /tphere (Jogador)");
					return false;
				}
				if (args.length >= 1) {
					if (args[0] == null) {
						p.sendMessage(Main.Menssagems + "§fInsira o nome do jogador que deseja teleportar para voc§.");
						return false;
					}
					OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
					if (target.getName() == p.getName()) {
						p.sendMessage(Main.Menssagems + "§fVoc§ n§o pode teleportar voc§ at§ voc§ mesmo.");
						return false;
					}
					if (!(target.isOnline())) {
						p.sendMessage(Main.Menssagems + "§fO jogador §5" + target.getName() + " §fn§o est§ online.");
						return false;
					}

					Player tt = Bukkit.getPlayer(args[0]);

					tt.teleport(p.getLocation());
					p.sendMessage(Main.Menssagems + "§fVoc§ teleportou o jogador §5" + tt.getName() + " §fat§ voc§.");

					return false;
				}
			} else {
				p.sendMessage(Main.nperm);
				return true;
			}
		}
		return false;
	}

}