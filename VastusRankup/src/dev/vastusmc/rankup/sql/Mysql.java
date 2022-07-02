package dev.vastusmc.rankup.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.bukkit.Bukkit;

import dev.vastusmc.rankup.Main;

public class Mysql {
	
	public static String tabela = "rankup";
	public static String database = "rankup";
	public static String v = "','";

	public Mysql() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS "+ tabela +" (Jogador TEXT, Rank INTEGER)");
			c.close();
			stmt.close();
			Bukkit.getConsoleSender().sendMessage("§e§lMysql§7: §fO plugin §eVastusRankup §ffoi conectado ao banco de dados.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}