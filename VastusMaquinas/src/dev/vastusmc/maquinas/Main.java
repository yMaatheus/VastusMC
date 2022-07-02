package dev.vastusmc.maquinas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.maquinas.commands.Combustivel;
import dev.vastusmc.maquinas.commands.Maquina;
import dev.vastusmc.maquinas.systems.Events;

public class Main extends JavaPlugin {
	
	public static String Menssagems = "§5§lVastusMC §7➡ ";
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		getCommand("maquina").setExecutor(new Maquina());
		getCommand("combustivel").setExecutor(new Combustivel());
	}
	
	public void onDisable() {
		
	}

}
