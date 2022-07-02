package dev.vastusmc.caixas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.caixas.commands.CaixaMisteriosa;
import dev.vastusmc.caixas.systems.Events;
import dev.vastusmc.caixas.systems.Itens;

public class Main extends JavaPlugin {

	public static Main plugin;
	public static String Menssagems = "§5§lVastusMC §7➡ ";

	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		getCommand("caixamisteriosa").setExecutor(new CaixaMisteriosa());
		Itens.Minerador();
		Itens.Basica();
		Itens.Media();
		Itens.Futurista();
	}

	public void onDisable() {
		
	}
	
}