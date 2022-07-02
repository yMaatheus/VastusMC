package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Tp implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		Player p = (Player) sender;
		if (command.getName().equalsIgnoreCase("tp")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (args.length == 0) {
					p.sendMessage(Main.Menssagems + "§fUse /tp (jogador)");
					return false;
				}
				if (args.length >= 1) {
					try {
						int x = Integer.parseInt(args[0]);
						int y = 0;
						int z = 0;
						if (args.length >= 2) {
							y = Integer.parseInt(args[1]);
						}
						if (args.length >= 3) {
							z = Integer.parseInt(args[2]);
						}

						p.teleport(new Location(p.getWorld(), x, y, z));
						p.sendMessage(Main.Menssagems + "§fVoc§ foi teleportado para §5X:§f " + x + " §5Y:§f " + y + " §5Z:§f " + z);
					} catch (NumberFormatException e) {
						if (args[0] == null) {
							p.sendMessage(Main.Menssagems + "§fInsira o nome do jogador que deseja teleportar.");
							return false;
						}
						OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
						if (target.getName() == p.getName()) {
							p.sendMessage(Main.Menssagems + "§fVoc§ n§o pode teleportar-se at§ voc§ mesmo.");
							return false;
						}
						if (!(target.isOnline())) {
							p.sendMessage(Main.Menssagems + "§fO jogador §5" + target.getName() + " §fn§o est§ online.");
							return false;
						}
						Player tt = Bukkit.getPlayer(args[0]);
						Location tlocal = tt.getLocation();
						if (args.length == 2) {
							OfflinePlayer target2 = Bukkit.getOfflinePlayer(args[1]);
							if (!(target2.isOnline())) {
								p.sendMessage(Main.Menssagems + "§fO jogador§e " + target2.getName() + " §fn§o est§ online.");
								return false;
							}
							Player tt2 = Bukkit.getPlayer(args[1]);
							Location t2local = tt2.getLocation();
							if (tt2.getName() == tt.getName()) {
								p.sendMessage(Main.Menssagems + "§fVoc§ n§o pode teleportar o jogador para ele mesmo.");
								return false;
							}
							tt.teleport(t2local);
							tt.sendMessage(Main.Menssagems + "§fVoc§ foi teleportado at§ o jogador §5" + tt2.getName() + "§f.");
							return false;
						}

						p.teleport(tlocal);
						p.sendMessage(Main.Menssagems + "§fVoc§ teleportou-se at§ o jogador §5" + tt.getName() + "§f.");
						return false;
					}
				}
			} else {
				p.sendMessage(Main.nperm);
			}
		}
		return false;
	}

}