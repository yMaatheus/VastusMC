package dev.vastusmc.kits.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.bukkit.Bukkit;

import dev.vastusmc.kits.Main;

public class Mysql {
	
	public static String table = "kits";
	public static String database = "kits";
	public static String v = "','";

	public Mysql() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS "+ table +" (Jogador TEXT, PvP BIGINT, Mercurio BIGINT, Venus BIGINT, Terra BIGINT, Marte BIGINT, Jupiter BIGINT, Saturno BIGINT, Urano BIGINT, Netuno BIGINT, Nasa BIGINT, Lunar BIGINT, LunarSemanal BIGINT, LunarMensal BIGINT, Solar BIGINT, SolarSemanal BIGINT, SolarMensal BIGINT, Estelar BIGINT, EstelarSemanal BIGINT, EstelarMensal BIGINT, Universal BIGINT, UniversalSemanal BIGINT, UniversalMensal BIGINT)");
			c.close();
			stmt.close();
			Bukkit.getConsoleSender().sendMessage("§e§lSQL§7: §fO plugin §eVastusKits §ffoi conectado ao banco de dados.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}