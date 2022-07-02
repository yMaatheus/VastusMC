package dev.vastusmc.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;

public class Invsee implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("invsee")) {
			if (VerificarGrupo.Moderacao(p)) {
				if (args.length == 0) {
					p.sendMessage(Main.Menssagems + "§fUse o comando: /invsee (jogador)");
					return false;
				} 
				if (args.length >= 1) {
					if (!Bukkit.getOfflinePlayer(args[0]).isOnline()) {
						p.sendMessage(Main.off);
						return false;
					}

					Player target = Bukkit.getPlayer(args[0]);
					if (args.length == 1) {
						if (p.getName() == target.getName()) {
							p.sendMessage(Main.Menssagems + "§fVocê não pode ver seu proprio inventario.");
							return false;
						}
						
						p.openInventory(target.getInventory());
						p.sendMessage(Main.Menssagems + "§fVoc§ esta vendo o inventario de §5" + target.getName() + "§f.");
						return false;
					}

					Inventory inv = Bukkit.createInventory(null, 9, "INV: " + target.getName());

					ItemStack capacete = new ItemStack(Material.AIR);
					ItemStack peitoral = new ItemStack(Material.AIR);
					ItemStack calca = new ItemStack(Material.AIR);
					ItemStack bota = new ItemStack(Material.AIR);

					if (target.getInventory().getHelmet() != null) {
						capacete = target.getInventory().getHelmet();
					}
					if (target.getInventory().getChestplate() != null) {
						peitoral = target.getInventory().getChestplate();
					}
					if (target.getInventory().getLeggings() != null) {
						calca = target.getInventory().getLeggings();
					}
					if (target.getInventory().getBoots() != null) {
						bota = target.getInventory().getBoots();
					}
					inv.setItem(0, capacete);
					inv.setItem(1, peitoral);
					inv.setItem(2, calca);
					inv.setItem(3, bota);

					p.openInventory(inv);
					p.sendMessage(Main.Menssagems + "§fVocê esta vendo a armadura de §5" + target.getName() + "§f.");
					return false;
				}
			} else {
				p.sendMessage(Main.nperm);
				return true;
			}
		}
		return false;
	}

}