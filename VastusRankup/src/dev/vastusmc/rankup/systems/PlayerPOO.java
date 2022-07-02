package dev.vastusmc.rankup.systems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.vastusmc.rankup.Main;
import dev.vastusmc.rankup.sql.Mysql;

public class PlayerPOO {

	public String jogador;
	public int rank;
	
	public boolean save = false;

	public PlayerPOO(String jogador) {
		this.jogador = jogador;
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
	
	public static int get(String jogador) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			String table = Mysql.tabela;
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE Jogador='" + jogador + "'");
			while (rs.next()) {
				return rs.getInt("Rank");
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void PlayerUpdate(Statement stmt, String jogador) throws SQLException {
		String table = Mysql.tabela;
		PlayerPOO player = Arrays.playerdados.get(jogador);
		if (ExistePlayer(jogador.toLowerCase()) == false) {
			String v = Mysql.v;
			stmt.execute("INSERT INTO " + table + " (Jogador, Rank) VALUES ('" + jogador + v + this.rank + "');");
		} else {
			if (get(jogador) != player.rank) {
				stmt.executeUpdate("UPDATE " + table + " SET Rank='" + this.rank + "' WHERE Jogador='" + jogador + "'");
			}
		}
	}
}