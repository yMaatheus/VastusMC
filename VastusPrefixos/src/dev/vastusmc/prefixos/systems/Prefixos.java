package dev.vastusmc.prefixos.systems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import dev.vastusmc.prefixos.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Prefixos {

	public static void runUpdate() {
		try {
			new BukkitRunnable() {
				@Override
				public void run() {
					for (Player p : Bukkit.getOnlinePlayers()) {
						updatePrefix(p);
					}
				}
			}.runTaskTimerAsynchronously(Main.plugin, 0, 3 * 20);
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage("§eTAB ERROR");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void updatePrefix(final Player a) {
		Scoreboard sb = a.getScoreboard();
		for (Player p : Bukkit.getOnlinePlayers()) {
			String grupo = "membro";
			String tag = "§7";
			Integer rank = 999;
			String pex = PermissionsEx.getUser(p.getName()).getGroups()[0].getName();
			if (pex.equalsIgnoreCase("Master")) {
				tag = Arrays.grupoPrefix.get("master");
				rank = Arrays.grupoOrdem.get("master");
				grupo = "master";
			}
			if (pex.equalsIgnoreCase("Gerente")) {
				tag = Arrays.grupoPrefix.get("gerente");
				rank = Arrays.grupoOrdem.get("gerente");
				grupo = "gerente";
			}
			if (pex.equalsIgnoreCase("Coordenador")) {
				tag = Arrays.grupoPrefix.get("coordenador");
				rank = Arrays.grupoOrdem.get("coordenador");
				grupo = "coordenador";
			}
			if (pex.equalsIgnoreCase("Developer")) {
				tag = Arrays.grupoPrefix.get("developer");
				rank = Arrays.grupoOrdem.get("developer");
				grupo = "developer";
			}
			if (pex.equalsIgnoreCase("Admin")) {
				tag = Arrays.grupoPrefix.get("admin");
				rank = Arrays.grupoOrdem.get("admin");
				grupo = "admin";
			}
			if (pex.equalsIgnoreCase("Moderador")) {
				tag = Arrays.grupoPrefix.get("moderador");
				rank = Arrays.grupoOrdem.get("moderador");
				grupo = "moderador";
			}
			if (pex.equalsIgnoreCase("Youtuber+")) {
				tag = Arrays.grupoPrefix.get("youtuber+");
				rank = Arrays.grupoOrdem.get("youtuber+");
				grupo = "youtuber+";
			}
			if (pex.equalsIgnoreCase("Ajudante")) {
				tag = Arrays.grupoPrefix.get("ajudante");
				rank = Arrays.grupoOrdem.get("ajudante");
				grupo = "ajudante";
			}
			if (pex.equalsIgnoreCase("Youtuber")) {
				tag = Arrays.grupoPrefix.get("youtuber");
				rank = Arrays.grupoOrdem.get("youtuber");
				grupo = "youtuber";
			}
			if (pex.equalsIgnoreCase("MiniYt")) {
				tag = Arrays.grupoPrefix.get("miniyt");
				rank = Arrays.grupoOrdem.get("miniyt");
				grupo = "miniyt";
			}
			if (pex.equalsIgnoreCase("Universal")) {
				tag = Arrays.grupoPrefix.get("universal");
				rank = Arrays.grupoOrdem.get("universal");
				grupo = "universal";
			}
			if (pex.equalsIgnoreCase("Estelar")) {
				tag = Arrays.grupoPrefix.get("estelar");
				rank = Arrays.grupoOrdem.get("estelar");
				grupo = "estelar";
			}
			if (pex.equalsIgnoreCase("Solar")) {
				tag = Arrays.grupoPrefix.get("solar");
				rank = Arrays.grupoOrdem.get("solar");
				grupo = "solar";
			}
			if (pex.equalsIgnoreCase("Lunar")) {
				tag = Arrays.grupoPrefix.get("lunar");
				rank = Arrays.grupoOrdem.get("lunar");
				grupo = "lunar";
			}
			if (pex.equalsIgnoreCase("Nasa")) {
				tag = Arrays.grupoPrefix.get("nasa");
				rank = Arrays.grupoOrdem.get("nasa");
				grupo = "nasa";
			}
			if (pex.equalsIgnoreCase("Netuno")) {
				tag = Arrays.grupoPrefix.get("netuno");
				rank = Arrays.grupoOrdem.get("netuno");
				grupo = "netuno";
			}
			if (pex.equalsIgnoreCase("Urano")) {
				tag = Arrays.grupoPrefix.get("urano");
				rank = Arrays.grupoOrdem.get("urano");
				grupo = "urano";
			}
			if (pex.equalsIgnoreCase("Saturno")) {
				tag = Arrays.grupoPrefix.get("saturno");
				rank = Arrays.grupoOrdem.get("saturno");
				grupo = "saturno";
			}
			if (pex.equalsIgnoreCase("Jupiter")) {
				tag = Arrays.grupoPrefix.get("jupiter");
				rank = Arrays.grupoOrdem.get("jupiter");
				grupo = "jupiter";
			}
			if (pex.equalsIgnoreCase("Marte")) {
				tag = Arrays.grupoPrefix.get("marte");
				rank = Arrays.grupoOrdem.get("marte");
				grupo = "marte";
			}
			if (pex.equalsIgnoreCase("Terra")) {
				tag = Arrays.grupoPrefix.get("terra");
				rank = Arrays.grupoOrdem.get("terra");
				grupo = "terra";
			}
			if (pex.equalsIgnoreCase("Venus")) {
				tag = Arrays.grupoPrefix.get("venus");
				rank = Arrays.grupoOrdem.get("venus");
				grupo = "venus";
			}
			if (pex.equalsIgnoreCase("Mercurio")) {
				tag = Arrays.grupoPrefix.get("mercurio");
				rank = Arrays.grupoOrdem.get("mercurio");
				grupo = "mercurio";
			}
			if (pex.equalsIgnoreCase("Membro")) {
				tag = Arrays.grupoPrefix.get("membro");
				rank = Arrays.grupoOrdem.get("membro");
				grupo = "membro";
			}

			if (tag.length() > 16) {
				tag = tag.substring(0, 16);
			}

			if (sb.getTeam(rank + grupo) != null) {
				Team t = sb.getTeam(rank + grupo);
				if (!t.hasPlayer(p)) {
					t.addEntry(p.getName());
					t.setPrefix(tag);
				}
			} else {
				Team t = sb.registerNewTeam(rank + grupo);
				t.setPrefix(tag);
			}
		}
	}
}