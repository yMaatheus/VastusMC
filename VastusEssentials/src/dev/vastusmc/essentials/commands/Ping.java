package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import dev.vastusmc.essentials.Main;

public class Ping implements CommandExecutor {
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ping")) {
			int ping = ((CraftPlayer)p).getHandle().ping;
			if (args.length == 0) {
				p.sendMessage(Main.Menssagems + "§fSeu ping atual §: §5" + ping);
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			int PingTarget = ((CraftPlayer)target).getHandle().ping;
			if (args.length >= 1) {
				if (target  == null) {
					p.sendMessage("Jogador n§o encontrado.");
					return true;
				}
				p.sendMessage(Main.Menssagems + "§fPing do jogador §5" + target.getName() + " §f§: §5" + PingTarget);
				return true;
			}
		}
		return false;
	}

}