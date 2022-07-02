package dev.vastusmc.reports;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.reports.commands.Report;
import dev.vastusmc.reports.commands.Reports;
import dev.vastusmc.reports.commands.Silent;
import dev.vastusmc.reports.gui.ReportsInvetory;

public class Main extends JavaPlugin {

	public static Main plugin;
	public static String Menssagems = "§5§lVastusMC §7➡ ";

	public static CommandSender console = Bukkit.getConsoleSender();

	public void onEnable() {
		plugin = this;
		getCommand("report").setExecutor(new Report());
		getCommand("silent").setExecutor(new Silent());
		getCommand("reports").setExecutor(new Reports());
		Bukkit.getPluginManager().registerEvents(new ReportsInvetory(), this);
	}

	public void onDisable() {

	}
}