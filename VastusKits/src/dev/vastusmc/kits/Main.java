package dev.vastusmc.kits;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.kits.Sql.Mysql;
import dev.vastusmc.kits.commands.Kit;
import dev.vastusmc.kits.systems.Arrays;
import dev.vastusmc.kits.systems.Events;
import dev.vastusmc.kits.systems.PlayerPOO;

public class Main extends JavaPlugin {
	
	public static String Mensagens = "§5§lVastusMC §7➡ ";
	
	public static String host;
	public static String porta;
	public static String bancodedados;
	public static String usuario;
	public static String senha;
	public static Mysql db;
	
	public void onEnable() {
	    getCommand("kit").setExecutor(new Kit());
	    Bukkit.getPluginManager().registerEvents(new Events(), this);
	    MysqlSetup();
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
			Bukkit.getConsoleSender().sendMessage("§e§lMysql§7: §fO plugin §eVastusKits §fteve seus dados salvos no banco de dados.");
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage("§e§lMysql§7: §cOcorreu um erro ao salvar os dados  do plugin §eVastusKits");
			e.printStackTrace();
		}
	}
	
	public void MysqlSetup() {
		host = "127.0.0.1";
		porta = "3306";
		bancodedados = Mysql.database;
		usuario = "root";
		senha = "";
		db = new Mysql();
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + Mysql.table + ";");
			while (rs.next()) {
				String jogador = rs.getString("Jogador");
				Long pvp = rs.getLong("PvP");
				Long mercurio = rs.getLong("Mercurio");
				Long venus = rs.getLong("Venus");
				Long terra = rs.getLong("Terra");
				Long marte = rs.getLong("Marte");
				Long jupiter = rs.getLong("Jupiter");
				Long saturno = rs.getLong("Saturno");
				Long urano = rs.getLong("Urano");
				Long netuno = rs.getLong("Netuno");
				Long nasa = rs.getLong("Nasa");
				Long lunardiario = rs.getLong("Lunar");
				Long lunarsemanal = rs.getLong("LunarSemanal");
				Long lunarmensal = rs.getLong("LunarMensal");
				Long solardiario = rs.getLong("Solar");
				Long solarsemanal = rs.getLong("SolarSemanal");
				Long solarmensal = rs.getLong("SolarMensal");
				Long estelardiario = rs.getLong("Estelar");
				Long estelarsemanal = rs.getLong("EstelarSemanal");
				Long estelarmensal = rs.getLong("EstelarMensal");
				Long universaldiario = rs.getLong("Universal");
				Long universalsemanal = rs.getLong("UniversalSemanal");
				Long universalmensal = rs.getLong("UniversalMensal");
				
				
				PlayerPOO player = new PlayerPOO(jogador);
				player.jogador = jogador;
				player.pvp = pvp;
				player.mercurio = mercurio;
				player.venus = venus;
				player.terra = terra;
				player.marte = marte;
				player.jupiter = jupiter;
				player.saturno = saturno;
				player.urano = urano;
				player.netuno = netuno;
				player.nasa = nasa;
				player.lunardiario = lunardiario;
				player.lunarsemanal = lunarsemanal;
				player.lunarmensal = lunarmensal;
				player.solardiario = solardiario;
				player.solarsemanal = solarsemanal;
				player.solarmensal = solarmensal;
				player.estelardiario = estelardiario;
				player.estelarsemanal = estelarsemanal;
				player.estelarmensal = estelarmensal;
				player.universaldiario = universaldiario;
				player.universalsemanal = universalsemanal;
				player.universalmensal = universalmensal;
				
				Arrays.playerdados.put(jogador, player);
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
