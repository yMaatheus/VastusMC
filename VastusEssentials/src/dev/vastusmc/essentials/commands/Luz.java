package dev.vastusmc.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.systems.Arrays;

public class Luz implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("luz")) {
			if (Arrays.luz.contains(p.getName()) == false) {
				Arrays.luz.add(p.getName());
				p.sendMessage(Main.Menssagems + "§fVoc§ §5ativou §fsua luz.");
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
				return true;
			} else {
				Arrays.luz.remove(p.getName());
				p.sendMessage(Main.Menssagems + "§fVoc§ §5desativou §fsua luz.");
				p.removePotionEffect(PotionEffectType.NIGHT_VISION);
				return true;
			}
		}
		return false;
	}

}