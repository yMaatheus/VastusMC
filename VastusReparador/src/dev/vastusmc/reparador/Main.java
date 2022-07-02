package dev.vastusmc.reparador;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.reparador.commands.SetReparador;
import dev.vastusmc.reparador.systems.Events;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

	public static String Menssagems = "§5§lVastusMC §7➡ ";
	public static Main plugin;

	public void onEnable() {
		plugin = this;
		if (new File(getDataFolder(), "config.yml").exists() == false) {
			saveDefaultConfig();
		}
		saveConfig();
		getCommand("setreparador").setExecutor(new SetReparador());
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		setupEconomy();
	}

	public void onDisable() {

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
