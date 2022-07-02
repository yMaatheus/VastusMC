package dev.vastusmc.lobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import dev.vastusmc.lobby.commands.Fly;
import dev.vastusmc.lobby.gui.Servidores;
import dev.vastusmc.lobby.systems.Arrays;
import dev.vastusmc.lobby.systems.Events;
import dev.vastusmc.lobby.systems.TagsTablist;

public class Main extends JavaPlugin implements PluginMessageListener {

	public static Main plugin;
	public static String Mensagens = "§5§lVastusMC §7➡ ";
	public static String prefix = "§5§lVastusMC";

	public void onEnable() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		plugin = this;
		getCommand("fly").setExecutor(new Fly());
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		Bukkit.getPluginManager().registerEvents(new Servidores(), this);
		TagsTablist.runUpdate();
		if (!getServer().getMessenger().isOutgoingChannelRegistered(this, "BungeeCord"))
			getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		if (!getServer().getMessenger().isIncomingChannelRegistered(this, "Lobby")) {
			getServer().getMessenger().registerIncomingPluginChannel(this, "Lobby", this);
		}
	}

	public void onDisable() {

	}

	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (channel.equalsIgnoreCase("Lobby")) {
			ByteArrayDataInput in = ByteStreams.newDataInput(message);
			String subchannel = in.readUTF();
			if (subchannel.equals("online")) {
				String value = in.readUTF();
				String server = value.split(";")[0].toLowerCase();
				int on = Integer.parseInt(value.split(";")[1]);
				Arrays.server_players.put(server, Integer.valueOf(on));
			}
			if (subchannel.equalsIgnoreCase("all")) {
				int i = Integer.parseInt(in.readUTF());
				Arrays.server_players.put("network", Integer.valueOf(i));
			}
		}
	}

}
