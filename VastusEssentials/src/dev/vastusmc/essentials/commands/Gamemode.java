package dev.vastusmc.essentials.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Gamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("gamemode")) {
			if (VerificarGrupo.Coordenacao(p)) {
				if (args.length == 0) {
					p.sendMessage(Main.Menssagems + "§fUse /gamemode (0|1|3)");
					return false;
				}
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("0")) {
						if (p.getGameMode() == GameMode.SURVIVAL) {
							p.sendMessage(Main.Menssagems + "§fVoc§ j§ est§ no §5" + p.getGameMode().toString());
							return true;
						}
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Main.Menssagems + "§fSeu modo de jogo foi atualizado para: §5" + p.getGameMode());
						return true;
					}
					if (args[0].equalsIgnoreCase("1")) {
						if (p.getGameMode() == GameMode.CREATIVE) {
							p.sendMessage(Main.Menssagems + "§fVoc§ j§ est§ no §5" + p.getGameMode().toString());
							return true;
						}
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Main.Menssagems + "§fSeu modo de jogo foi atualizado para: §5" + p.getGameMode());
						return true;
					}
					if (args[0].equalsIgnoreCase("3")) {
						if (p.getGameMode() == GameMode.SPECTATOR) {
							p.sendMessage(Main.Menssagems + "§fVoc§ j§ est§ no §5" + p.getGameMode().toString());
							return true;
						}
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(Main.Menssagems + "§fSeu modo de jogo foi atualizado para: §5" + p.getGameMode());
						return true;
					}
				}
			} else {
				p.sendMessage(Main.nperm);
				return true;
			}
		}
		return false;
	}

}