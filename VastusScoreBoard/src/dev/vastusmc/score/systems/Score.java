package dev.vastusmc.score.systems;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import dev.vastusmc.score.Main;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Score implements Listener {

	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player p) {
		final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		final Objective o = sb.registerNewObjective("skywars", "sb");

		Team players = sb.registerNewTeam("players");
		Team money = sb.registerNewTeam("money");
		Team pex = sb.registerNewTeam("pex");
		Team clan = sb.registerNewTeam("clan");

		players.addPlayer(Bukkit.getOfflinePlayer(" §5Online:"));
		money.addPlayer(Bukkit.getOfflinePlayer(" §5Money:"));
		pex.addPlayer(Bukkit.getOfflinePlayer(" §5Grupo:"));
		clan.addPlayer(Bukkit.getOfflinePlayer(" §5Clan:"));

		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("     §5§lVastusMC     ");

		int line = 16;

		o.getScore("§1").setScore(line--);
		o.getScore(Bukkit.getOfflinePlayer(" §5Grupo:")).setScore(line--);
		o.getScore(Bukkit.getOfflinePlayer(" §5Online:")).setScore(line--);
		o.getScore("§2").setScore(line--);
		o.getScore(Bukkit.getOfflinePlayer(" §5Money:")).setScore(line--);
		o.getScore(Bukkit.getOfflinePlayer(" §5Clan:")).setScore(line--);
		o.getScore("§3").setScore(line--);
		

		sb.getTeam("players").setSuffix(" §7Carregando..");
		sb.getTeam("money").setSuffix(" §7Carregando..");
		sb.getTeam("pex").setSuffix(" §7Carregando..");

		final Player p2 = p;

		new BukkitRunnable() {
			@Override
			public void run() {
				p.setScoreboard(sb);
				DecimalFormat n = new DecimalFormat();
				String money = n.format(Main.economy.getBalance(p.getName()));
				if (money.length() > 13){
				money = money.substring(0,13);
				}
				sb.getTeam("players").setSuffix("§f " + Bukkit.getOnlinePlayers().size() + "");
				sb.getTeam("money").setSuffix("§f " + money + "");
				sb.getTeam("pex").setSuffix("§f " + PermissionsEx.getUser(p.getName()).getGroups()[0].getName() + "");
				if (SimpleClans.getInstance().getClanManager().getClanByPlayerName(p2.getName()) == null) {
					sb.getTeam("clan").setSuffix(" §7");
					} else {
					sb.getTeam("clan").setSuffix("§f " + SimpleClans.getInstance().getClanManager().getClanByPlayerName(p2.getName()).getTag());
					}
			}
		}.runTaskTimer(Main.plugin, 20L, 40L);
		p.setScoreboard(sb);
		
	  }
}
