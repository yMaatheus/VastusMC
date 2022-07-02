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

public class Maquina implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("maquina")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (VerificarGrupo.Gerentecia(p)) {
					if (args.length == 0) {
						sender.sendMessage(Main.Menssagems + "§fUse: /maquina dar (Jogador) (Lunar | Estelar | Solar).");
						return true;
					}
					if (args.length == 1) {
						sender.sendMessage(Main.Menssagems + "§fUse: /maquina dar (Jogador) (Lunar | Estelar | Solar).");
						return true;
					}
					Player target = Bukkit.getPlayer(args[1]);
					if (args.length == 2) {
						if (target == null) {
							sender.sendMessage("§cJogador n§o encontrado.");
							return true;
						}
						sender.sendMessage(Main.Menssagems + "§fUse: /maquina dar (Jogador) (Lunar | Estelar | Solar).");
						return true;
					}
					if (args.length == 3) {
						if (args[2].equalsIgnoreCase("lunar")) {
							if (target == null) {
								sender.sendMessage("§cJogador n§o encontrado.");
								return true;
							}
							ItemStack f = new ItemStack(Material.ENDER_PORTAL_FRAME);
							ItemMeta fm = f.getItemMeta();
							fm.setDisplayName("§fMaquina Lunar");
							f.setItemMeta(fm);
							target.getInventory().addItem(f);
							sender.sendMessage(Main.Menssagems + "§fVoc§ deu uma maquina de lunar para: §5" + target.getName());
							target.sendMessage(Main.Menssagems + "§fVoc§ ganhou uma maquina §5Lunar§f.");
							return true;
						}
						if (args[2].equalsIgnoreCase("estelar")) {
							if (target == null) {
								sender.sendMessage("§cJogador n§o encontrado.");
								return true;
							}
							ItemStack o = new ItemStack(Material.REDSTONE_BLOCK);
							ItemMeta om = o.getItemMeta();
							om.setDisplayName("§eMaquina Estelar");
							o.setItemMeta(om);
							target.getInventory().addItem(o);
							sender.sendMessage(
									Main.Menssagems + "§fVoc§ deu uma maquina de estelar para: §5" + target.getName());
							target.sendMessage(Main.Menssagems + "§fVoc§ ganhou uma maquina de §5Estelar§f.");
							return true;
						}
						if (args[2].equalsIgnoreCase("solar")) {
							if (target == null) {
								sender.sendMessage("§cJogador n§o encontrado.");
								return true;
							}
							ItemStack e = new ItemStack(Material.OBSIDIAN);
							ItemMeta em = e.getItemMeta();
							em.setDisplayName("§6Maquina Solar");
							e.setItemMeta(em);
							target.getInventory().addItem(e);
							sender.sendMessage(Main.Menssagems + "§fVoc§ deu uma maquina solar para: §5" + target.getName());
							target.sendMessage(Main.Menssagems + "§fVoc§ ganhou uma maquina §5Solar§f.");
							return true;
						}
						return true;
					}
				} else {
					p.sendMessage("§cSem permiss§o.");
					return true;
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.Menssagems + "§fUse: /maquina dar (Jogador) (Lunar | Estelar | Solar).");
					return true;
				}
				if (args.length == 1) {
					sender.sendMessage(Main.Menssagems + "§fUse: /maquina dar (Jogador) (Lunar | Estelar | Solar).");
					return true;
				}
				Player target = Bukkit.getPlayer(args[1]);
				if (args.length == 2) {
					if (target == null) {
						sender.sendMessage("§cJogador n§o encontrado.");
						return true;
					}
					sender.sendMessage(Main.Menssagems + "§fUse: /maquina dar (Jogador) (Lunar | Estelar | Solar).");
					return true;
				}
				if (args.length == 3) {
					if (args[2].equalsIgnoreCase("lunar")) {
						if (target == null) {
							sender.sendMessage("§cJogador n§o encontrado.");
							return true;
						}
						ItemStack f = new ItemStack(Material.ENDER_PORTAL_FRAME);
						ItemMeta fm = f.getItemMeta();
						fm.setDisplayName("§fMaquina Lunar");
						f.setItemMeta(fm);
						target.getInventory().addItem(f);
						sender.sendMessage(Main.Menssagems + "§fVoc§ deu uma maquina de lunar para: §5" + target.getName());
						target.sendMessage(Main.Menssagems + "§fVoc§ ganhou uma maquina §5Lunar§f.");
						return true;
					}
					if (args[2].equalsIgnoreCase("estelar")) {
						if (target == null) {
							sender.sendMessage("§cJogador n§o encontrado.");
							return true;
						}
						ItemStack o = new ItemStack(Material.REDSTONE_BLOCK);
						ItemMeta om = o.getItemMeta();
						om.setDisplayName("§eMaquina Estelar");
						o.setItemMeta(om);
						target.getInventory().addItem(o);
						sender.sendMessage(
								Main.Menssagems + "§fVoc§ deu uma maquina de estelar para: §5" + target.getName());
						target.sendMessage(Main.Menssagems + "§fVoc§ ganhou uma maquina de §5Estelar§f.");
						return true;
					}
					if (args[2].equalsIgnoreCase("solar")) {
						if (target == null) {
							sender.sendMessage("§cJogador n§o encontrado.");
							return true;
						}
						ItemStack e = new ItemStack(Material.OBSIDIAN);
						ItemMeta em = e.getItemMeta();
						em.setDisplayName("§6Maquina Solar");
						e.setItemMeta(em);
						target.getInventory().addItem(e);
						sender.sendMessage(Main.Menssagems + "§fVoc§ deu uma maquina solar para: §5" + target.getName());
						target.sendMessage(Main.Menssagems + "§fVoc§ ganhou uma maquina §5Solar§f.");
						return true;
					}
					return true;
				}
			}
		}
		return false;
	}

}
