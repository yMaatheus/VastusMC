package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Reiniciar implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("reiniciar")) {
			if (VerificarGrupo.Coordenacao(p)) {
				Bukkit.broadcastMessage(Main.Menssagems + "§cO Servidor ir§ reiniciar em 1 minuto.");
				new BukkitRunnable() {

					@Override
					public void run() {
						Bukkit.broadcastMessage(Main.Menssagems + "§cServidor reiniciando.");
						Bukkit.shutdown();
					}
				}.runTaskLater(Main.plugin, 1200L);
			} else {
				p.sendMessage(Main.nperm);
				return true;
			}
		}

		return false;
	}

}
