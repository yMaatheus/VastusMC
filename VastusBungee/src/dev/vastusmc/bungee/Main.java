package dev.vastusmc.bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dev.vastusmc.bungee.commands.Discord;
import dev.vastusmc.bungee.commands.LobbyCommand;
import dev.vastusmc.bungee.commands.Site;
import dev.vastusmc.bungee.commands.Twitter;
import dev.vastusmc.bungee.systems.Events;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	public static String Mensagens = "§5§lVastusMC §7➡ ";

	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new LobbyCommand("lobby"));
		getProxy().getPluginManager().registerCommand(this, new Discord("discord"));
		getProxy().getPluginManager().registerCommand(this, new Twitter("twitter"));
		getProxy().getPluginManager().registerCommand(this, new Site("site"));
		getProxy().getPluginManager().registerListener(this, new Events());
		getPlayers();
	}

	public void onDisable() {

	}

	public void getPlayers() {
		BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
			public void run() {
				for (String server : getProxy().getServers().keySet()) {
					int players = getProxy().getServerInfo(server).getPlayers().size();
					sendToBukkit("online", server + ";" + players, getProxy().getServerInfo("lobby"));
				}
				sendToBukkit("all", getProxy().getOnlineCount() + "", getProxy().getServerInfo("lobby"));
			}
		}, 0L, 3L, TimeUnit.SECONDS);
	}

	public void sendToBukkit(String channel, String message, ServerInfo server) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(stream);
		try {
			out.writeUTF(channel);
			out.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		server.sendData("Lobby", stream.toByteArray());
	}

}
