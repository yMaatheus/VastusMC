package dev.vastusmc.essentials.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;
import dev.vastusmc.essentials.systems.LocationUtil;

public class Jail implements CommandExecutor {

	public static HashMap<Player, Boolean> jail = new HashMap<>();

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("jail")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (args.length == 0) {
					p.sendMessage(Main.Menssagems + "§fUse o comando: /jail (jogador)");
					return false;
				}
				if (args.length >= 1) {
					if (!Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						p.sendMessage(Main.off);
						return false;
					}

					Player target = Bukkit.getPlayer(args[0]);
					if (VerificarGrupo.Moderacao(target)) {
						p.sendMessage(Main.Menssagems + "§cVoce nao pode mover " + target.getName() + " para a jail.");
						return false;
					}
					if (jail.get(target) != null && jail.get(target) == true) {
						p.sendMessage(Main.Menssagems + "§cEsse jogador j§ est§ na jail.");
						return false;
					}

					jail.put(target, true);

					Location loc = LocationUtil.getLocation(Main.plugin.getConfig().getString("jail"));

					loc.getWorld().loadChunk((int) loc.getX(), (int) loc.getZ());

					target.teleport(loc);

					target.sendMessage(Main.Menssagems + "§fVoc§ foi teleportado a jail!");
					p.sendMessage(Main.Menssagems + "§fVoc§ colocou o jogador §5" + args[0] + " §fna jail.");
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