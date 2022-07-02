package dev.vastusmc.maquinas.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.vastusmc.maquinas.Main;
import dev.vastusmc.maquinas.api.VerificarGrupo;

public class Combustivel implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("combustivel")) {
			if (sender instanceof Player) {
				Player p = (Player)sender;
				if (VerificarGrupo.Gerentecia(p)) {
					if (args.length == 0) {
						sender.sendMessage(Main.Menssagems + "§fUse: /combustivel dar (Jogador) (Basico | Avancado).");
						return true;
					}
					if (args.length == 1) {
						sender.sendMessage(Main.Menssagems + "§fUse: /combustivel dar (Jogador) (Basico | Avancado).");
						return true;
					}
					Player target = Bukkit.getPlayer(args[1]);
					if (args.length == 2) {
						if (target == null) {
							sender.sendMessage("§cJogador n§o encontrado.");
							return true;
						}
						sender.sendMessage(Main.Menssagems + "§fUse: /combustivel dar (Jogador) (Basico | Avancado).");
						return true;
					}
					if (args.length == 3) {
						if (args[0].equalsIgnoreCase("dar")) {
							if (args[2].equalsIgnoreCase("basico")) {
								if (target == null) {
									sender.sendMessage("§cJogador n§o encontrado.");
									return true;
								}
								ItemStack item = new ItemStack(Material.COAL);
								ItemMeta itemm = item.getItemMeta();
								itemm.setDisplayName("§eCombustivel Basico");
								item.setItemMeta(itemm);
								target.getInventory().addItem(item);
								sender.sendMessage(Main.Menssagems + "§fVoc§ deu um combustivel basico para: §5" + target.getName());
								target.sendMessage(Main.Menssagems + "§fVoc§ ganhou um combustivel §5Basico§f.");
								return true;
							}
							if (args[2].equalsIgnoreCase("avancado")) {
								if (target == null) {
									sender.sendMessage("§cJogador n§o encontrado.");
									return true;
								}
								ItemStack item = new ItemStack(Material.COAL);
								ItemMeta itemm = item.getItemMeta();
								itemm.setDisplayName("§cCombustivel Avancado");
								item.setItemMeta(itemm);
								target.getInventory().addItem(item);
								sender.sendMessage(Main.Menssagems + "§fVoc§ deu um combustivel avancado para: §5" + target.getName());
								target.sendMessage(Main.Menssagems + "§fVoc§ ganhou um combustivel §5Avancado§f.");
								return true;
							}
							return true;
						}
						return true;
					}
					return true;
				} else {
					p.sendMessage("§cSem permiss§o.");
					return true;
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.Menssagems + "§fUse: /combustivel dar (Jogador) (Basico | Avancado).");
					return true;
				}
				if (args.length == 1) {
					sender.sendMessage(Main.Menssagems + "§fUse: /combustivel dar (Jogador) (Basico | Avancado).");
					return true;
				}
				Player target = Bukkit.getPlayer(args[1]);
				if (args.length == 2) {
					if (target == null) {
						sender.sendMessage("§cJogador n§o encontrado.");
						return true;
					}
					sender.sendMessage(Main.Menssagems + "§fUse: /combustivel dar (Jogador) (Basico | Avancado).");
					return true;
				}
				if (args.length == 3) {
					if (args[0].equalsIgnoreCase("dar")) {
						if (args[2].equalsIgnoreCase("basico")) {
							if (target == null) {
								sender.sendMessage("§cJogador n§o encontrado.");
								return true;
							}
							ItemStack item = new ItemStack(Material.COAL);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§eCombustivel Basico");
							item.setItemMeta(itemm);
							target.getInventory().addItem(item);
							sender.sendMessage(Main.Menssagems + "§fVoc§ deu um combustivel basico para: §5" + target.getName());
							target.sendMessage(Main.Menssagems + "§fVoc§ ganhou um combustivel §5Basico§f.");
							return true;
						}
						if (args[2].equalsIgnoreCase("avancado")) {
							if (target == null) {
								sender.sendMessage("§cJogador n§o encontrado.");
								return true;
							}
							ItemStack item = new ItemStack(Material.COAL);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§cCombustivel Avancado");
							item.setItemMeta(itemm);
							target.getInventory().addItem(item);
							sender.sendMessage(Main.Menssagems + "§fVoc§ deu um combustivel avancado para: §5" + target.getName());
							target.sendMessage(Main.Menssagems + "§fVoc§ ganhou um combustivel §5Avancado§f.");
							return true;
						}
						return true;
					}
					return true;
				}
				return true;
			}
		}
		return false;
	}

}
