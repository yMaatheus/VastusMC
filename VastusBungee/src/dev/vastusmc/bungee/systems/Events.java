package dev.vastusmc.bungee.systems;

import java.util.concurrent.TimeUnit;

import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener {
	
public long timer = 0;
	
	@EventHandler
	public void onEntrar(LoginEvent e) {
		if (timer > System.currentTimeMillis()) {
			e.setCancelled(true);
			e.setCancelReason("§cMuitos jogadores est§o tentando conectar, tente novamente.");
		} else {
			timer = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(2);
		}
	}

	@EventHandler
	public void onPing(ProxyPingEvent e) {
		if ((e.getConnection() == null) || (e.getConnection().getVirtualHost() == null)) {
			return;
		}
		if (e.getConnection().getVirtualHost().getHostName().isEmpty()) {
			return;
		}
		e.getResponse().getPlayers().setMax(e.getResponse().getPlayers().getOnline() + 1);
		String motd = "§5§lVastusMC §7§ §f(1.8x) \n§7Servidor em §e§lBETA §7Atualiza§§es constantes!";
		e.getResponse().setDescription(motd);
	}

}
