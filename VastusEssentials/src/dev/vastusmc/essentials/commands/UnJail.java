package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;
import dev.vastusmc.essentials.systems.LocationUtil;

public class UnJail implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("unjail")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (args.length == 0) {
					p.sendMessage(Main.Menssagems + "§fUse /unjail (jogador)");
					return false;
				}
				if (args.length >= 1) {
					if (!Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						p.sendMessage(Main.off);
						return false;
					}
					Player target = Bukkit.getPlayer(args[0]);
					if (Jail.jail.get(target) != null && Jail.jail.get(target) == false) {
						p.sendMessage(Main.Menssagems + "§cEsse jogador n§o est§ na jail.");
						return false;
					}
					Jail.jail.remove(target);
					Location loc = LocationUtil.getLocation(Main.plugin.getConfig().getString("spawn"));
					target.teleport(loc);
					p.sendMessage(Main.Menssagems + "§fVoc§ tirou o jogador §5" + args[0] + " §fda jail.");
					return false;
				}
			}
		}
		return false;
	}

}