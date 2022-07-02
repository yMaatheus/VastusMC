package dev.vastusmc.rankup;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.rankup.commands.Rankup;
import dev.vastusmc.rankup.commands.ResetRank;
import dev.vastusmc.rankup.sql.Mysql;
import dev.vastusmc.rankup.systems.Arrays;
import dev.vastusmc.rankup.systems.PlayerPOO;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	public static String Mensagens = "§5§lVastusMC §7➡ ";
	
	public static Main plugin;
	public static String host;
	public static String porta;
	public static String bancodedados;
	public static String usuario;
	public static String senha;
	public Mysql db;
	
	public void onEnable() {
		plugin = this;
		if (new File(getDataFolder(), "config.yml").exists() == false) {
			saveDefaultConfig();
		}
		saveConfig();
		MySqlSetup();
		getCommand("rankup").setExecutor(new Rankup());
		getCommand("resetrank").setExecutor(new ResetRank());
		setupEconomy();
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
			Bukkit.getConsoleSender().sendMessage("§e§lMysql§7: §fOs dados do plugin §eVastusRankup §fforam salvos.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void MySqlSetup() {
		host = "127.0.0.1";
		porta = "3306";
		bancodedados = Mysql.database;
		usuario = "root";
		senha = "";
		db = new Mysql();
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + Main.host + ":" + Main.porta + "/" + Main.bancodedados, Main.usuario, Main.senha);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + Mysql.tabela + ";");
			while (rs.next()) {
				String Jogador = rs.getString("Jogador");
				int Rank = rs.getInt("Rank");
				
				PlayerPOO player = new PlayerPOO(Jogador);
				player.jogador = Jogador;
				player.rank = Rank;
				
				Arrays.playerdados.put(player.jogador, player);
			}
			c.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Economy economy = null;

	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}

		return (economy != null);
	}
}
