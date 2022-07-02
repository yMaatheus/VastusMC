package dev.vastusmc.kits.systems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.vastusmc.kits.Main;
import dev.vastusmc.kits.Sql.Mysql;

public class PlayerPOO {

	public String jogador;
	public long pvp;
	public long mercurio;
	public long venus;
	public long terra;
	public long marte;
	public long jupiter;
	public long saturno;
	public long urano;
	public long netuno;
	public long nasa;

	public long lunardiario;
	public long lunarsemanal;
	public long lunarmensal;
	public long solardiario;
	public long solarsemanal;
	public long solarmensal;
	public long estelardiario;
	public long estelarsemanal;
	public long estelarmensal;
	public long universaldiario;
	public long universalsemanal;
	public long universalmensal;

	public boolean save = false;

	public PlayerPOO(String jogador) {
		this.jogador = jogador;
	}

	public static void CreateJogador(String jogador) {
		if (Arrays.playerdados.containsKey(jogador) == false) {
			PlayerPOO pn = new PlayerPOO(jogador);
			pn.jogador = jogador;
			pn.pvp = 0;
			pn.mercurio = 0;
			pn.venus = 0;
			pn.terra = 0;
			pn.marte = 0;
			pn.jupiter = 0;
			pn.saturno = 0;
			pn.urano = 0;
			pn.netuno = 0;
			pn.nasa = 0;
			pn.lunardiario = 0;
			pn.lunarsemanal = 0;
			pn.lunarmensal = 0;
			pn.solardiario = 0;
			pn.solarsemanal = 0;
			pn.solarmensal = 0;
			pn.estelardiario = 0;
			pn.estelarsemanal = 0;
			pn.estelarmensal = 0;
			pn.universaldiario = 0;
			pn.universalsemanal = 0;
			pn.universalmensal = 0;
			pn.save = true;

			Arrays.playerdados.put(jogador, pn);
		}
	}
	
	public static void deBug(String jogador) {
		PlayerPOO player = Arrays.playerdados.get(jogador);
		if (TimeManager.getMSGBunitu(Long.valueOf(player.pvp)) == "0") {
			player.pvp = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.mercurio)) == "0") {
			player.mercurio = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.venus)) == "0") {
			player.venus = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.terra)) == "0") {
			player.terra = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.jupiter)) == "0") {
			player.jupiter = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.saturno)) == "0") {
			player.saturno = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.urano)) == "0") {
			player.urano = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.netuno)) == "0") {
			player.netuno = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.nasa)) == "0") {
			player.nasa = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.lunardiario)) == "0") {
			player.lunardiario = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.lunarsemanal)) == "0") {
			player.lunarsemanal = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.lunarmensal)) == "0") {
			player.lunarmensal = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.solardiario)) == "0") {
			player.solardiario = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.solarsemanal)) == "0") {
			player.solarsemanal = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.solarmensal)) == "0") {
			player.solarmensal = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.estelardiario)) == "0") {
			player.estelardiario = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.estelarsemanal)) == "0") {
			player.estelarsemanal = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.estelarmensal)) == "0") {
			player.estelarmensal = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.universaldiario)) == "0") {
			player.universaldiario = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.universalsemanal)) == "0") {
			player.universalsemanal = 0;
		}
		if (TimeManager.getMSGBunitu(Long.valueOf(player.universalmensal)) == "0") {
			player.universalmensal = 0;
		}
		player.save = true;
		Arrays.playerdados.put(jogador, player);
	}

	public static boolean ExistePlayer(String jogador) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + Mysql.table + ";");
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
	
	public static Long get(String jogador, String Coluna) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			String table = Mysql.table;
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE Jogador='" + jogador + "'");
			while (rs.next()) {
				return rs.getLong(Coluna);
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void PlayerUpdate(Statement stmt, String jogador) throws SQLException {
		String table = Mysql.table;
		PlayerPOO player = Arrays.playerdados.get(jogador);
		if (ExistePlayer(jogador.toLowerCase()) == false) {
			String v = Mysql.v;
			stmt.execute("INSERT INTO " + table + " (Jogador, PvP, Mercurio, Venus, Terra, Marte, Jupiter, Saturno, Urano, Netuno, Nasa, Lunar, LunarSemanal, LunarMensal, Solar, SolarSemanal, SolarMensal, Estelar, EstelarSemanal, EstelarMensal, Universal, UniversalSemanal, UniversalMensal) VALUES ('" + jogador + v + this.pvp + v + this.mercurio + v + this.venus + v + this.terra + v + this.marte + v+ this.jupiter + v + this.saturno + v + this.urano + v + this.netuno + v + this.nasa + v+ this.lunardiario + v + this.lunarsemanal + v + this.lunarmensal + v + this.solardiario + v+ this.solarsemanal + v + this.solarmensal + v + this.estelardiario + v + this.estelarsemanal + v+ this.estelarmensal + v + this.universaldiario + v + this.universalsemanal + v+ this.universalmensal + "');");
		} else {
			if (get(jogador, "PvP") != player.pvp) {
				stmt.executeUpdate("UPDATE " + table + " SET PvP='" + this.pvp + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Mercurio") != player.mercurio) {
				stmt.executeUpdate("UPDATE " + table + " SET Mercurio='" + this.mercurio + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Venus") != player.venus) {
				stmt.executeUpdate("UPDATE " + table + " SET Venus='" + this.venus + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Terra") != player.terra) {
				stmt.executeUpdate("UPDATE " + table + " SET Terra='" + this.terra + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Marte") != player.marte) {
				stmt.executeUpdate("UPDATE " + table + " SET Marte='" + this.marte + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Jupiter") != player.jupiter) {
				stmt.executeUpdate("UPDATE " + table + " SET Jupiter='" + this.jupiter + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Saturno") != player.saturno) {
				stmt.executeUpdate("UPDATE " + table + " SET Saturno='" + this.saturno + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Urano") != player.urano) {
				stmt.executeUpdate("UPDATE " + table + " SET Urano='" + this.urano + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Netuno") != player.netuno) {
				stmt.executeUpdate("UPDATE " + table + " SET Netuno='" + this.netuno + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Nasa") != player.nasa) {
				stmt.executeUpdate("UPDATE " + table + " SET Nasa='" + this.nasa + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Lunar") != player.lunardiario) {
				stmt.executeUpdate("UPDATE " + table + " SET Lunar='" + this.lunardiario + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "LunarSemanal") != player.lunarsemanal) {
				stmt.executeUpdate("UPDATE " + table + " SET LunarSemanal='" + this.lunarsemanal + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "LunarMensal") != player.lunarmensal) {
				stmt.executeUpdate("UPDATE " + table + " SET LunarMensal='" + this.lunarmensal + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "Solar") != player.solardiario) {
				stmt.executeUpdate("UPDATE " + table + " SET Solar='" + this.solardiario + "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "SolarSemanal") != player.solarsemanal) {
				stmt.executeUpdate("UPDATE " + table + " SET SolarSemanal='" + this.solarsemanal + "' WHERE Jogador='"+ this.jogador + "'");
			}
			if (get(jogador, "SolarMensal") != player.solarmensal) {
				stmt.executeUpdate("UPDATE " + table + " SET SolarMensal='" + this.solarmensal + "' WHERE Jogador='"+ this.jogador + "'");
			}
			if (get(jogador, "Estelar") != player.estelardiario) {
				stmt.executeUpdate("UPDATE " + table + " SET Estelar='" + this.estelardiario + "' WHERE Jogador='"+ this.jogador + "'");
			}
			if (get(jogador, "EstelarSemanal") != player.estelarsemanal) {
				stmt.executeUpdate("UPDATE " + table + " SET EstelarSemanal='" + this.estelarsemanal + "' WHERE Jogador='"+ this.jogador + "'");
			}
			if (get(jogador, "EstelarMensal") != player.estelarmensal) {
				stmt.executeUpdate("UPDATE " + table + " SET EstelarMensal='" + this.estelarmensal + "' WHERE Jogador='"+ this.jogador + "'");
			}
			if (get(jogador, "Universal") != player.universaldiario) {
				stmt.executeUpdate("UPDATE " + table + " SET Universal='" + this.universaldiario + "' WHERE Jogador='"+ this.jogador + "'");
			}
			if (get(jogador, "UniversalSemanal") != player.universalsemanal) {
				stmt.executeUpdate("UPDATE " + table + " SET UniversalSemanal='" + this.universalsemanal+ "' WHERE Jogador='" + this.jogador + "'");
			}
			if (get(jogador, "UniversalMensal") != player.universalmensal) {
				stmt.executeUpdate("UPDATE " + table + " SET UniversalMensal='" + this.universalmensal + "' WHERE Jogador='"+ this.jogador + "'");
			}
		}
	}

}