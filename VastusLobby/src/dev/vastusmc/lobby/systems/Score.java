package dev.vastusmc.lobby.systems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import dev.vastusmc.lobby.Main;

public class Score implements Listener {

	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player p) {
		final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		final Objective o = sb.registerNewObjective("skywars", "sb");

		Team fullpvp = sb.registerNewTeam("rankup");
		Team network = sb.registerNewTeam("network");

		fullpvp.addPlayer(Bukkit.getOfflinePlayer(" §5Rankup:"));
		network.addPlayer(Bukkit.getOfflinePlayer(" §5Network:"));

		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("     " + Main.prefix + "     ");

		int line = 16;

		o.getScore("§1").setScore(line--);
		o.getScore(Bukkit.getOfflinePlayer(" §5Rankup:")).setScore(line--);
		o.getScore(Bukkit.getOfflinePlayer(" §5Network:")).setScore(line--);
		o.getScore("§3").setScore(line--);

		sb.getTeam("rankup").setSuffix(" §7Carregando..");
		sb.getTeam("network").setSuffix(" §7Carregando..");

		new BukkitRunnable() {
			@Override
			public void run() {
				p.setScoreboard(sb);
				sb.getTeam("rankup").setSuffix("§f " + BungeeAPI.getPlayers("rankup") + "");
				sb.getTeam("network").setSuffix("§f " + BungeeAPI.getAllPlayers() + "");
			}
		}.runTaskTimer(Main.plugin, 20L, 40L);
		p.setScoreboard(sb);

	}
}