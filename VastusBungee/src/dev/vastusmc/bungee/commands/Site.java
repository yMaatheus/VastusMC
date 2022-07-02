package dev.vastusmc.bungee.commands;

import dev.vastusmc.bungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Site extends Command {
	public Site(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if ((sender instanceof ProxiedPlayer)) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			p.sendMessage(Main.Mensagens + "§fNosso site: §5http://pagcraft.com.br/VastusMC/");
			return;
		}
	}
}