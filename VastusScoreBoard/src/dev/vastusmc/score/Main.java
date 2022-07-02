package dev.vastusmc.score;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.score.systems.Join;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

	public static Main plugin;

	public void onEnable() {
		plugin = this;
		setupEconomy();
		Bukkit.getPluginManager().registerEvents(new Join(), this);
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
