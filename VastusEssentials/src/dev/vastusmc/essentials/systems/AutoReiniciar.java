package dev.vastusmc.essentials.systems;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import dev.vastusmc.essentials.Main;

public class AutoReiniciar {
	
	public static void reiniciar() {
		Bukkit.broadcastMessage(Main.Menssagems + "§cO Servidor vai reiniciar em §f1 minuto§c.");
		new BukkitRunnable() {
			public void run() {
				Bukkit.shutdown();
			}
		}.runTaskLater(Main.plugin, 1200L);
	}

	public static void AutoIniciarCheck() {
		new BukkitRunnable() {
			@Override
			public void run() {
				int Hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
				int Minuto = Calendar.getInstance().get(Calendar.MINUTE);
				if (Hora == 6 && Minuto == 0) {
					reiniciar();
					return;
				}
				if (Hora == 11 && Minuto == 0) {
					reiniciar();
					return;
				}
				if (Hora == 19 && Minuto == 0) {
					reiniciar();
					return;
				}
				if (Hora == 0 && Minuto == 0) {
					reiniciar();
					return;
				}
			}
		}.runTaskTimer(Main.plugin, 0L, 1000L);
	}
}
