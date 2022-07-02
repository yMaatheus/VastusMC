package dev.vastusmc.reports.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import dev.vastusmc.reports.Main;
import dev.vastusmc.reports.api.VerificarGrupo;
import dev.vastusmc.reports.systems.Arrays;

public class Report implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("report")) {
			if (args.length == 0) {
				p.sendMessage(Main.Menssagems + "§fUse: /report (Jogador) (Motivo).");
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if (args.length > 0) {
				String msg = "";
				for (int i = 1; i < args.length; i++) {
					msg = msg + args[i] + " ";
				}
				if (target == null) {
					p.sendMessage("§cO jogador não foi encontrado.");
					return true;
				}
				if (msg == "") {
					p.sendMessage("§cDefina o motivo do seu report.");
					return true;
				}
				p.sendMessage(Main.Menssagems + "§fSua denuncia foi enviada com sucesso, obrigado por denunciar.");
				Arrays.delay.add(p.getName());
				Arrays.Reports.add(target.getName());
				if (Arrays.ReportsContagem.containsKey(target.getName())) {
					Arrays.ReportsContagem.put(target.getName(), Arrays.ReportsContagem.get(target.getName()) + 1);
				} else {
					Arrays.ReportsContagem.put(target.getName(), 1);
				}
				new BukkitRunnable() {

					@Override
					public void run() {
						Arrays.delay.remove(p.getName());
						p.sendMessage(Main.Menssagems + "§fVocê já pode denunciar um jogador novamente.");
						cancel();
						return;
					}
				}.runTaskLaterAsynchronously(Main.plugin, 60 * 20L);
				
				for (Player online : Bukkit.getOnlinePlayers()) {
					if (Arrays.Silent.contains(online.getName()) == false) {
						if (VerificarGrupo.Moderacao(online)) {
							online.sendMessage("");
							online.sendMessage("        §5» §f§lREPORT §5«                     ");
							online.sendMessage("");
							online.sendMessage("§5» §fReportado por: §f" + p.getName());
							online.sendMessage("§5» §fAcusado: §f" + target.getName());
							online.sendMessage("§5» §fMotivo: §f" + msg);
							online.sendMessage("");
						}
					}
				}
			}
		}
		return false;

	}

}