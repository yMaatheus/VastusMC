package dev.vastusmc.bans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.bans.commands.BanCommand;
import dev.vastusmc.bans.commands.CheckBanCommand;
import dev.vastusmc.bans.commands.KickCommand;
import dev.vastusmc.bans.commands.UnBanCommand;
import dev.vastusmc.bans.sql.Mysql;
import dev.vastusmc.bans.systems.Arrays;
import dev.vastusmc.bans.systems.Events;
import dev.vastusmc.bans.systems.PlayerPOO;

public class Main extends JavaPlugin {
	
	public static String host;
	public static String porta;
	public static String bancodedados;
	public static String usuario;
	public static String senha;
	public Mysql db;
	
	public static Main plugin;
	public static String Menssagems = "§5§lVastusMC §7➡ ";
	
	
	public void onEnable() {
		plugin = this;
		Mysql();
		Comandos();
		Bukkit.getPluginManager().registerEvents(new Events(), this);
	}
	
	public void onDisable() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			for (String players : Arrays.playerdados.keySet()) {
				PlayerPOO player = Arrays.playerdados.get(players);
				if (player.save == true) {
					player.PlayerUpdate(stmt, player.jogador);
				}
			}
			Bukkit.getConsoleSender().sendMessage("§e§lMysql§7: §fBanco de dados §e" + Mysql.database +" §fsalvou os dados.");
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage("§e§lMysql§7: §cOcorreu um erro ao salvar o banco de dados §e" + Mysql.database);
			e.printStackTrace();
		}
	}
	
	public void Mysql() {
		host = "127.0.0.1";
		porta= "3306";
		bancodedados = Mysql.database;
		usuario = "root";
		senha = "";
		db = new Mysql();
		
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + Mysql.tabela + ";");
			ArrayList<String> deletar = new ArrayList<>();
			while (rs.next()) {
				String jogador = rs.getString("Jogador");
				String por = rs.getString("Por");
				String motivo = rs.getString("Motivo");
				String ip = rs.getString("Ip");
				String data = rs.getString("Data");
				if (jogador.equalsIgnoreCase("null")) {
					deletar.add(jogador);
				}
				PlayerPOO player = new PlayerPOO(jogador);
				player.jogador = jogador;
				player.por = por;
				player.motivo = motivo;
				player.ip = ip;
				player.data = data;
				
				Arrays.ips.add(ip);
				Arrays.playerdados.put(jogador, player);
			}
			
			for (String d : deletar) {
				Mysql.Deletar(d);
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Comandos() {
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("checkban").setExecutor(new CheckBanCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("unban").setExecutor(new UnBanCommand());
	}
	
}