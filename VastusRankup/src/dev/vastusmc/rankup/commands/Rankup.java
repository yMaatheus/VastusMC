package dev.vastusmc.rankup.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import dev.vastusmc.rankup.Main;
import dev.vastusmc.rankup.api.VerificarGrupo;
import dev.vastusmc.rankup.systems.Arrays;
import dev.vastusmc.rankup.systems.PlayerPOO;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Rankup implements CommandExecutor {

	public static FileConfiguration config = Main.plugin.getConfig();

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("rankup")) {
			if (VerificarGrupo.Moderacao(p)) {
				p.sendMessage("§cVoc§ n§o pode upar de rank, po§s faz parte da nossa equipe.");
				return true;
			}
			if (Arrays.playerdados.containsKey(p.getName().toLowerCase()) == false) {
				PlayerPOO player = new PlayerPOO(p.getName().toLowerCase());
				player.jogador = p.getName().toLowerCase();
				player.rank = 1;
				player.save = true;
				
				Arrays.playerdados.put(player.jogador, player);
				p.sendMessage("§aParab§ns, voc§ foi registrado no sistema de rankup!");
				return true;
			}
			PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
			if (player.rank == 1) {
				if (Main.economy.getBalance(p) < config.getInt("Mecurio")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Mecurio") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 2;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Merc§rio");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Mercurio");
					return true;
				}
			}

			if (player.rank == 2) {
				if (Main.economy.getBalance(p) < config.getInt("Venus")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Venus") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 3;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Venus");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Venus");
					PermissionsEx.getUser(p).removeGroup("Mercurio");
					return true;
				}
			}

			if (player.rank == 3) {
				if (Main.economy.getBalance(p) < config.getInt("Terra")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Terra") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 4;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Terra");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Terra");
					PermissionsEx.getUser(p).removeGroup("Venus");
					return true;
				}
			}

			if (player.rank == 4) {
				if (Main.economy.getBalance(p) < config.getInt("Marte")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Marte") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 5;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Marte");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Marte");
					PermissionsEx.getUser(p).removeGroup("Terra");
					return true;
				}
			}

			if (player.rank == 5) {
				if (Main.economy.getBalance(p) < config.getInt("Jupiter")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Jupiter") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 6;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Jupiter");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Jupiter");
					PermissionsEx.getUser(p).removeGroup("Marte");
					return true;
				}
			}

			if (player.rank == 6) {
				if (Main.economy.getBalance(p) < config.getInt("Saturno")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Saturno") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 7;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Saturno");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Saturno");
					PermissionsEx.getUser(p).removeGroup("Jupiter");
					return true;
				}
			}

			if (player.rank == 7) {
				if (Main.economy.getBalance(p) < config.getInt("Urano")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Urano") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 8;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Urano");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Urano");
					PermissionsEx.getUser(p).removeGroup("Saturno");
					return true;
				}
			}

			if (player.rank == 8) {
				if (Main.economy.getBalance(p) < config.getInt("Netuno")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Netuno") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 9;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Netuno");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Netuno");
					PermissionsEx.getUser(p).removeGroup("Urano");
					return true;
				}
			}

			if (player.rank == 9) {
				if (Main.economy.getBalance(p) < config.getInt("Nasa")) {
					p.sendMessage("§cVoc§ precisa de: " + config.getInt("Nasa") + " para ir ao proximo rank.");
					return true;
				} else {
					player.rank = 10;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					p.sendMessage("§aParab§ns, Voc§ foi para o rank: §5Nasa");
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 15.0F, 15.0F);
					PermissionsEx.getUser(p).addGroup("Nasa");
					PermissionsEx.getUser(p).removeGroup("Netuno");
					return true;
				}
			}
			p.sendMessage("§cVoc§ n§o pode upar de rank, po§s j§ est§ no ultimo rank.");
			return true;
		}
		return false;
	}

}
