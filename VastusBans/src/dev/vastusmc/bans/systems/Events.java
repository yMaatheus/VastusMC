package dev.vastusmc.bans.systems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class Events implements Listener {
	
	@EventHandler
	public void onConnectEvent(PlayerLoginEvent e) {
		Player target = e.getPlayer();
		if (Arrays.playerdados.containsKey(target.getName().toLowerCase())) {
			PlayerPOO player = Arrays.playerdados.get(target.getName().toLowerCase());
			e.setResult(Result.KICK_BANNED);
			String titulo = "§5§lBANIDO \n §5Sua conta est§ banida. \n";
			e.setKickMessage(titulo + " §5Autor: §f" + player.por + " \n §5Motivo: §f" + player.motivo + " \n §5Hor§rio: §f" + player.data);
			return;
		}
		if (Arrays.ips.contains(e.getAddress().getHostAddress())) {
			e.setResult(Result.KICK_BANNED);
			e.setKickMessage("§5§lBANIDO\n  §fVoc§ es§ banido.");
			return;
		}
	}
	
	@EventHandler
	public void Login(PlayerLoginEvent e) {
		String p = e.getPlayer().getName();
		String ip = e.getAddress().getHostAddress();
		if (Arrays.IpSave.containsKey(p.toLowerCase()) == false) {
			Arrays.IpSave.put(p.toLowerCase(), ip);
			Bukkit.getConsoleSender().sendMessage("§fO §e" + p.toLowerCase() + " §fteve o ip §e" + ip + " §fsalvo.");
		}
	}

}
