package dev.vastusmc.fragmentos;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.fragmentos.systems.Events;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Events(), this);
	}
	
	public void onDisable() {
		
	}

}
