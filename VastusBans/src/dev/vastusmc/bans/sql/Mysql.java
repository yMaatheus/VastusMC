package dev.vastusmc.bans.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;

import dev.vastusmc.bans.Main;

public class Mysql {

	public static String tabela = "bans";
	public static String database = "vastusbans";
	public static String v = "','";

	public Mysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS " + tabela + " (Jogador TEXT, Por TEXT, Motivo TEXT, Ip TEXT, Data TEXT)");
			Bukkit.getConsoleSender().sendMessage("§e§lMysql§7: §fBanco de dados §e" + database + " §fconectado.");
			c.close();
			stmt.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean ExistePlayer(String jogador) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + Mysql.tabela + ";");
			while (rs.next()) {
				if (rs.getString("Jogador").equalsIgnoreCase(jogador)) {
					return true;
				}
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void Deletar(String jogador) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			stmt.execute("DELETE FROM " + Mysql.tabela + " WHERE Jogador='" + jogador + "'");
			c.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}