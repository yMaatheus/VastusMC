package dev.vastusmc.caixas.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.vastusmc.caixas.Main;
import dev.vastusmc.caixas.api.VerificarGrupo;
import dev.vastusmc.caixas.gui.InventoryGui;

public class CaixaMisteriosa implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("caixamisteriosa")) {
			if (args.length == 0) {
				p.sendMessage(Main.Menssagems + "§fUse: /caixamisteriosa (Give | Ver) (Jogador) (Minerador | Basica | Media | Futurista).");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("ver")) {
					InventoryGui.OpenVerCaixas(p);
					p.sendMessage(Main.Menssagems + "§fVoc§ abriu a lista de itens que pode vir nas caixas.");
					return true;
				}
				p.sendMessage(Main.Menssagems + "§fUse: /caixamisteriosa (Give | Ver) (Jogador) (Minerador | Basica | Media | Futurista).");
				return true;
			}
			Player target = Bukkit.getPlayer(args[1]);
			if (args.length == 2) {
				p.sendMessage(Main.Menssagems + "§fUse: /caixamisteriosa (Give | Ver) (Jogador) (Minerador | Basica | Media | Futurista).");
				return true;
			}
			if (args.length == 3) {
				if (VerificarGrupo.Gerentecia(p) == false) {
					p.sendMessage("§cSem permiss§o.");
					return true;
				}
				if (args[2].equalsIgnoreCase("minerador")) {
					ItemStack CaixaBasica = new ItemStack(Material.CHEST);
					ItemMeta CaixaBasica_Meta = CaixaBasica.getItemMeta();
					CaixaBasica_Meta.setDisplayName("§eCaixa Minerador");
					
					CaixaBasica.setItemMeta(CaixaBasica_Meta);
					target.getInventory().addItem(CaixaBasica);
				}
				if (args[2].equalsIgnoreCase("basica")) {
					ItemStack CaixaBasica = new ItemStack(Material.CHEST);
					ItemMeta CaixaBasica_Meta = CaixaBasica.getItemMeta();
					CaixaBasica_Meta.setDisplayName("§6Caixa Basica");
					
					CaixaBasica.setItemMeta(CaixaBasica_Meta);
					target.getInventory().addItem(CaixaBasica);
				}
				if (args[2].equalsIgnoreCase("media")) {
					ItemStack CaixaAvancada = new ItemStack(Material.ENDER_CHEST);
					ItemMeta CaixaAvancada_Meta = CaixaAvancada.getItemMeta();
					CaixaAvancada_Meta.setDisplayName("§5Caixa Media");
					
					CaixaAvancada.setItemMeta(CaixaAvancada_Meta);
					target.getInventory().addItem(CaixaAvancada);
				}
				if (args[2].equalsIgnoreCase("futurista")) {
					ItemStack CaixaAvancada = new ItemStack(Material.ENDER_CHEST);
					ItemMeta CaixaAvancada_Meta = CaixaAvancada.getItemMeta();
					CaixaAvancada_Meta.setDisplayName("§cCaixa Futurista");
					
					CaixaAvancada.setItemMeta(CaixaAvancada_Meta);
					target.getInventory().addItem(CaixaAvancada);
				}
			}
		}
		return false;
	}

}