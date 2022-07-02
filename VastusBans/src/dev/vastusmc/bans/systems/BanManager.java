package dev.vastusmc.bans.systems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.bans.Main;
import dev.vastusmc.bans.sql.Mysql;

public class BanManager {

	public static void Banir(String jogador, String por, String motivo, String ip, String data) {
		PlayerPOO player = new PlayerPOO(jogador);
		player.jogador = jogador.toLowerCase();
		player.por = por;
		player.motivo = motivo;
		player.ip = ip;
		player.data = data;
		player.save = true;

		Arrays.playerdados.put(player.jogador, player);
		for (Player o : Bukkit.getOnlinePlayers()) {
			o.sendMessage("          §5§lBANIDO          ");
			o.sendMessage("");
			o.sendMessage("§5Indiv§duo: §f" + jogador);
			o.sendMessage("§5Autor: §f" + por);
			o.sendMessage("§5Motivo: §f" + motivo);
			o.sendMessage("§5Hor§rio: §f" + data);
			o.sendMessage("");
			if (o.getName().toLowerCase().equalsIgnoreCase(jogador.toLowerCase())) {
				String titulo = "§5§lBANIDO \n §5Sua conta foi banida. \n";
				o.kickPlayer(titulo + " §5Autor: §f" + por + " \n §5Motivo: §f" + motivo + " \n §5Hor§rio: §f" + data);
			}
		}
	}

	public static void Kickar(String jogador, String por, String motivo) {
		for (Player o : Bukkit.getOnlinePlayers()) {
			o.sendMessage("          §5§lEXPULSO          ");
			o.sendMessage("");
			o.sendMessage("§5Indiv§duo: §f" + jogador);
			o.sendMessage("§5Autor: §f" + por);
			o.sendMessage("§5Motivo: §f" + motivo);
			o.sendMessage("");
			if (o.getName().toLowerCase().equalsIgnoreCase(jogador.toLowerCase())) {
				String titulo = "§5§lEXPULSO \n §5Sua conta foi expulsa do servidor. \n";
				o.kickPlayer(titulo + " §5Autor: §f" + por + " \n §5Motivo: §f" + motivo);
			}
		}
	}

	public static void DesBanir(String jogador, String por) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			stmt.execute("DELETE FROM " + Mysql.tabela + " WHERE Jogador='" + jogador.toLowerCase() + "'");
			c.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PlayerPOO player = Arrays.playerdados.get(jogador.toLowerCase());
		player.jogador = "null";
		player.por = "null";
		player.motivo = "null";
		player.ip = "null";
		player.data = "null";
		Arrays.playerdados.put(jogador, player);
		for (Player o : Bukkit.getOnlinePlayers()) {
			o.sendMessage("          §5§lUNBAN          ");
			o.sendMessage("");
			o.sendMessage("§5Indiv§duo: §f" + jogador);
			o.sendMessage("§5Autor: §f" + por);
			o.sendMessage("");
		}
	}

	public static void CheckBan(String jogador, String por, Boolean console) {
		if (console == true) {
			ConsoleCommandSender c = Bukkit.getConsoleSender();
			c.sendMessage("          §5§lCHECKBAN          ");
			c.sendMessage("");
			if (Arrays.playerdados.containsKey(jogador.toLowerCase())) {
				PlayerPOO player = Arrays.playerdados.get(jogador.toLowerCase());
				c.sendMessage("§5Indiv§duo: §f" + player.jogador);
				c.sendMessage("§5Banido: §fSim");
				c.sendMessage("§5Por: §f" + player.por);
				c.sendMessage("§5Motivo: §f" + player.motivo);
				c.sendMessage("§5Data: §f" + player.data);
			} else {
				c.sendMessage("§5Indiv§duo: §f" + jogador.toLowerCase());
				c.sendMessage("§5Banido: §fN§o");
			}
			c.sendMessage("");
		} else {
			for (Player o : Bukkit.getOnlinePlayers()) {
				if (o.getName().toLowerCase().equalsIgnoreCase(jogador.toLowerCase())) {
					o.sendMessage("          §5§lCHECKBAN          ");
					o.sendMessage("");
					if (Arrays.playerdados.containsKey(jogador.toLowerCase())) {
						PlayerPOO player = Arrays.playerdados.get(jogador.toLowerCase());
						o.sendMessage("§5Indiv§duo: §f" + player.jogador);
						o.sendMessage("§5Banido: §fSim");
						o.sendMessage("§5Por: §f" + player.por);
						o.sendMessage("§5Motivo: §f" + player.motivo);
						o.sendMessage("§5Data: §f" + player.data);
					} else {
						o.sendMessage("§5Indiv§duo: §f" + jogador.toLowerCase());
						o.sendMessage("§5Banido: §fN§o");
					}
					o.sendMessage("");
				}
			}
		}
	}

}
