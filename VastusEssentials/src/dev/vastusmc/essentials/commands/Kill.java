package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Kill implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("kill")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (args.length == 0) {
					p.setHealth(0);
					return false;
				}
				if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if (!Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						p.sendMessage(Main.off);
						return false;
					}
					if (VerificarGrupo.Coordenacao(target)) {
						p.sendMessage(Main.Menssagems + "§cVoce nao pode matar esse jogador.");
						return false;
					}
					target.setHealth(0);
					p.sendMessage(Main.Menssagems + "§fVoce matou: §5" + target.getName() + "§f.");
					return false;
				}
			}
		}
		return false;
	}
}