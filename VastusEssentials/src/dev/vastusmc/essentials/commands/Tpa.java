package dev.vastusmc.essentials.commands;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.systems.Arrays;

public class Tpa implements CommandExecutor {

	public static HashMap<String, String> teleport = new HashMap<>();
	public static HashMap<String, Long> timeOut = new HashMap<String, Long>();

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(final CommandSender sender, Command command, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return false;
		}
		final Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("tpa")) {
			if (args.length == 0) {
				p.sendMessage(Main.Menssagems + "§fUse /tpa (Jogador | ON | OFF)");
				return false;
			}
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if (Arrays.tpa.get(p.getName()).equalsIgnoreCase("on")) {
						p.sendMessage(Main.Menssagems + "§fSeu tpa j§ est§ §5ativado§f.");
						return false;
					}
					Arrays.tpa.put(p.getName(), "on");
					p.sendMessage(Main.Menssagems + "§fSeu tpa agora est§ §5ativado§f.");
					return false;
				}
				if (args[0].equalsIgnoreCase("off")) {
					if (Arrays.tpa.get(p.getName()).equalsIgnoreCase("off")) {
						p.sendMessage(Main.Menssagems + "§fSeu tpa j§ est§ §5desativado§f.");
						return false;
					}
					Arrays.tpa.put(p.getName(), "off");
					p.sendMessage(Main.Menssagems + "§fSeu tpa agora est§ §5desativado§f.");
					return false;
				}
				if (!Bukkit.getOfflinePlayer(args[0]).isOnline()) {
					p.sendMessage(Main.off);
					return false;
				}
				if (p.getName() == Bukkit.getPlayer(args[0]).getName()) {
					p.sendMessage("§fVoc§ n§o pode teleportar-se para voc§ mesmo.");
					return false;
				}
				final Player target = Bukkit.getPlayer(args[0]);

				if (Arrays.tpa.get(target.getName()).equalsIgnoreCase("off")) {
					p.sendMessage("§fEsse jogador est§ com o tpa §5desativado§f.");
					return false;
				}
				if ((timeOut.containsKey(p.getName())) && (Long.valueOf(((Long) timeOut.get(p.getName())).longValue()).longValue() > System.currentTimeMillis())) {
					p.sendMessage("§fAguarde " + TimeUnit.MILLISECONDS.toSeconds(((Long) timeOut.get(p.getName())).longValue() - System.currentTimeMillis()) + " §fsegundos para mandar tpa.");
					return false;
				}
				timeOut.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(6L)));

				teleport.put(target.getName(), p.getName());

				p.sendMessage(Main.Menssagems + "§fPedido de teleporte enviado para§e " + target.getName() + "§f.");
				target.sendMessage("§fO jogador §5" + sender.getName() + "§f.");
				target.sendMessage("§fQuer teleportar-se at§ voc§.");
				target.sendMessage("§fPara aceitar use: §5/tpaccept§f.");

				target.spigot().sendMessage();

				new BukkitRunnable() {
					@Override
					public void run() {
						if (teleport.get(target.getName()) == null) {
							cancel();
							return;
						}
						if (teleport.get(target.getName()).equalsIgnoreCase(p.getName())) {
							p.sendMessage(Main.Menssagems + "§fSeu pedido de teleporte para §5" + target.getName() + " §ffoi esgotado.");
							target.sendMessage(Main.Menssagems + "§fO pedido de teleporte de §5" + sender.getName() + " §ffoi esgotado");
							teleport.remove(target.getName());

							cancel();
							return;
						} else {
							cancel();
						}
					}
				}.runTaskLater(Main.plugin, 60 * 20);
			}
		}

		return false;
	}

}