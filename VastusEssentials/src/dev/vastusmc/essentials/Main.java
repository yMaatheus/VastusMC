package dev.vastusmc.essentials;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.essentials.commands.Clear;
import dev.vastusmc.essentials.commands.Craft;
import dev.vastusmc.essentials.commands.EnderChest;
import dev.vastusmc.essentials.commands.Fly;
import dev.vastusmc.essentials.commands.Gamemode;
import dev.vastusmc.essentials.commands.God;
import dev.vastusmc.essentials.commands.Head;
import dev.vastusmc.essentials.commands.Invsee;
import dev.vastusmc.essentials.commands.Jail;
import dev.vastusmc.essentials.commands.Kill;
import dev.vastusmc.essentials.commands.LimparChat;
import dev.vastusmc.essentials.commands.Luz;
import dev.vastusmc.essentials.commands.Ping;
import dev.vastusmc.essentials.commands.Reiniciar;
import dev.vastusmc.essentials.commands.Set;
import dev.vastusmc.essentials.commands.Spawn;
import dev.vastusmc.essentials.commands.Tp;
import dev.vastusmc.essentials.commands.Tpa;
import dev.vastusmc.essentials.commands.Tpaccept;
import dev.vastusmc.essentials.commands.Tphere;
import dev.vastusmc.essentials.commands.UnJail;
import dev.vastusmc.essentials.commands.Vanish;
import dev.vastusmc.essentials.systems.Arrays;
import dev.vastusmc.essentials.systems.AutoReiniciar;
import dev.vastusmc.essentials.systems.CombatLogEvents;
import dev.vastusmc.essentials.systems.Events;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

	public static Main plugin;
	public static String nperm = "§cSem permissão.";
	public static String prefix = "§5§lVastusMC";
	public static String Menssagems = "§5§lVastusMC §7➡ ";
	public static String off = "§cJogador não encontrado.";
	public static String plotworld = "terreno";

	public void onEnable() {
		for (Player p : Bukkit.getOnlinePlayers()) {

			Arrays.tpa.put(p.getName(), "off");
			for (Player todos : Arrays.Invisivel) {
				if (!p.hasPermission("essentials.v")) {
					p.hidePlayer(todos);
				}
			}

			for (Player todos : Arrays.Invisivel) {
				p.hidePlayer(todos);
			}

			if (Jail.jail.get(p) == null) {
				Jail.jail.put(p, false);
			}
		}
		plugin = this;
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("tp").setExecutor(new Tp());
		getCommand("tpa").setExecutor(new Tpa());
		getCommand("tpaccept").setExecutor(new Tpaccept());
		getCommand("tphere").setExecutor(new Tphere());
		getCommand("clear").setExecutor(new Clear());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("god").setExecutor(new God());
		getCommand("jail").setExecutor(new Jail());
		getCommand("unjail").setExecutor(new UnJail());
		getCommand("craft").setExecutor(new Craft());
		getCommand("enderchest").setExecutor(new EnderChest());
		getCommand("set").setExecutor(new Set());
		getCommand("reiniciar").setExecutor(new Reiniciar());
		getCommand("kill").setExecutor(new Kill());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("head").setExecutor(new Head());
		getCommand("fly").setExecutor(new Fly());
		getCommand("limparchat").setExecutor(new LimparChat());
		getCommand("luz").setExecutor(new Luz());
		getCommand("ping").setExecutor(new Ping());
		Bukkit.getPluginManager().registerEvents(new CombatLogEvents(), this);
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		AutoReiniciar.AutoIniciarCheck();
	}

	public void onDisable() {

	}

	public void registerLocations() {
		File file = new File(Bukkit.getPluginManager().getPlugin("VastusEssentials").getDataFolder().getPath(),
				"config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

		if (config.getString("Spawn.W") != null) {
			String w = config.getString("Spawn.W");
			double x = config.getDouble("Spawn.X");
			double y = config.getDouble("Spawn.Y");
			double z = config.getDouble("Spawn.Z");
			double Yaw = config.getDouble("Spawn.Yaw");
			double Pitch = config.getDouble("Spawn.Pitch");

			Location local = new Location(Bukkit.getWorld(w), x, y, z);
			local.setPitch((float) Pitch);
			local.setYaw((float) Yaw);

			Arrays.locais.put("Spawn", local);
		}
		if (config.getString("Jail.W") != null) {
			String w = config.getString("Jail.W");
			double x = config.getDouble("Jail.X");
			double y = config.getDouble("Jail.Y");
			double z = config.getDouble("Jail.Z");
			double Yaw = config.getDouble("Jail.Yaw");
			double Pitch = config.getDouble("Jail.Pitch");

			Location local = new Location(Bukkit.getWorld(w), x, y, z);
			local.setPitch((float) Pitch);
			local.setYaw((float) Yaw);

			Arrays.locais.put("jail", local);
		}
	}

	public static Economy economy = null;

	@SuppressWarnings("unused")
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}

		return (economy != null);
	}
}