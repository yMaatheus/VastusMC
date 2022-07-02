package dev.vastusmc.lobby.systems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import dev.vastusmc.lobby.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TagsTablist {

	public static int value = 0;

	public static void runUpdate() {
		new BukkitRunnable() {
			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					updatePrefix(p);
				}

				if (value == 0) {
					value = 1;
					runUpdate();
					return;
				}
				if (value == 1) {
					value = 2;
					runUpdate();
					return;
				}
				if (value == 2) {
					value = 0;
					runUpdate();
					return;
				}
			}
		}.runTaskLaterAsynchronously(Main.plugin, 3 * 20);
	}

	@SuppressWarnings("deprecation")
	public static void updatePrefix(final Player player) {
		Scoreboard sb = player.getScoreboard();

		for (Player todos : Bukkit.getOnlinePlayers()) {
			String grupo = PermissionsEx.getUser(todos.getName()).getGroups()[0].getName();
			
			if (sb.getTeam(grupo) == null) {
				sb.registerNewTeam(grupo).setPrefix("§7");
			}

			if (!sb.getTeam(grupo).hasPlayer(todos)) {
				sb.getTeam(grupo).addEntry(todos.getName());
				sb.getTeam(grupo).setPrefix("§7");
			} else {
				sb.getTeam(grupo).setPrefix("§7");
			}
		}
	}
}