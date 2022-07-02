package dev.vastusmc.caixas.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryGui {

	public static void OpenVerCaixas(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 5 * 9, "§e§lCaixas");

		ItemStack Caixa_Minerador = new ItemStack(Material.CHEST);
		ItemMeta Caixa_MineradorMeta = Caixa_Minerador.getItemMeta();
		Caixa_MineradorMeta.setDisplayName("§eCaixa Minerador");
		Caixa_Minerador.setItemMeta(Caixa_MineradorMeta);

		inv.setItem(10, Caixa_Minerador);

		ItemStack Caixa_Basica = new ItemStack(Material.CHEST);
		ItemMeta Caixa_BasicaMeta = Caixa_Basica.getItemMeta();
		Caixa_BasicaMeta.setDisplayName("§6Caixa Basica");
		Caixa_Basica.setItemMeta(Caixa_BasicaMeta);

		inv.setItem(12, Caixa_Basica);

		ItemStack Caixa_Media = new ItemStack(Material.ENDER_CHEST);
		ItemMeta Caixa_MediaMeta = Caixa_Media.getItemMeta();
		Caixa_MediaMeta.setDisplayName("§5Caixa Media");
		Caixa_Media.setItemMeta(Caixa_MediaMeta);

		inv.setItem(14, Caixa_Media);

		ItemStack Caixa_Futurista = new ItemStack(Material.ENDER_CHEST);
		ItemMeta Caixa_FuturistaMeta = Caixa_Futurista.getItemMeta();
		Caixa_FuturistaMeta.setDisplayName("§cCaixa Futurista");
		Caixa_Futurista.setItemMeta(Caixa_FuturistaMeta);

		inv.setItem(16, Caixa_Futurista);
		p.openInventory(inv);
		p.updateInventory();
	}

	public static void OpenCaixaMinerador(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 5 * 9, "§eCaixa - Minerador");
		
		ItemStack Pick1 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick1Meta = Pick1.getItemMeta();
		Pick1Meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
		Pick1Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
		Pick1Meta.addEnchant(Enchantment.DURABILITY, 1, true);
		Pick1.setItemMeta(Pick1Meta);
		inv.setItem(10, Pick1);
		
		ItemStack Pick2 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick2Meta = Pick2.getItemMeta();
		Pick2Meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
		Pick2Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, true);
		Pick2Meta.addEnchant(Enchantment.DURABILITY, 2, true);
		Pick2.setItemMeta(Pick2Meta);
		inv.setItem(11, Pick2);
		
		ItemStack Pick3 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick3Meta = Pick3.getItemMeta();
		Pick3Meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		Pick3Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		Pick3Meta.addEnchant(Enchantment.DURABILITY, 3, true);
		Pick3.setItemMeta(Pick3Meta);
		inv.setItem(12, Pick3);
		
		ItemStack Pick4 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick4Meta = Pick4.getItemMeta();
		Pick4Meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
		Pick4Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
		Pick4Meta.addEnchant(Enchantment.DURABILITY, 4, true);
		Pick4.setItemMeta(Pick4Meta);
		inv.setItem(13, Pick4);
		
		ItemStack Pick5 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick5Meta = Pick5.getItemMeta();
		Pick5Meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		Pick5Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
		Pick5Meta.addEnchant(Enchantment.DURABILITY, 5, true);
		Pick5.setItemMeta(Pick5Meta);
		inv.setItem(14, Pick5);
		
		ItemStack Pick6 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick6Meta = Pick6.getItemMeta();
		Pick6Meta.addEnchant(Enchantment.DIG_SPEED, 6, true);
		Pick6Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 6, true);
		Pick6Meta.addEnchant(Enchantment.DURABILITY, 6, true);
		Pick6.setItemMeta(Pick6Meta);
		inv.setItem(15, Pick6);
		
		ItemStack Pick7 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick7Meta = Pick7.getItemMeta();
		Pick7Meta.addEnchant(Enchantment.DIG_SPEED, 7, true);
		Pick7Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 7, true);
		Pick7Meta.addEnchant(Enchantment.DURABILITY, 7, true);
		Pick7.setItemMeta(Pick7Meta);
		inv.setItem(16, Pick7);
		
		ItemStack Pick8 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick8Meta = Pick8.getItemMeta();
		Pick8Meta.addEnchant(Enchantment.DIG_SPEED, 8, true);
		Pick8Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 8, true);
		Pick8Meta.addEnchant(Enchantment.DURABILITY, 8, true);
		Pick8.setItemMeta(Pick8Meta);
		inv.setItem(19, Pick8);
		
		ItemStack Pick9 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick9Meta = Pick9.getItemMeta();
		Pick9Meta.addEnchant(Enchantment.DIG_SPEED, 9, true);
		Pick9Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 9, true);
		Pick9Meta.addEnchant(Enchantment.DURABILITY, 9, true);
		Pick9.setItemMeta(Pick9Meta);
		inv.setItem(20, Pick9);
		
		ItemStack Pick10 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta Pick10Meta = Pick10.getItemMeta();
		Pick10Meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
		Pick10Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
		Pick10Meta.addEnchant(Enchantment.DURABILITY, 10, true);
		Pick10.setItemMeta(Pick10Meta);
		inv.setItem(21, Pick10);
		
		p.openInventory(inv);
		p.updateInventory();
	}

	@SuppressWarnings("deprecation")
	public static void OpenCaixaBasica(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 5 * 9, "§eCaixa - Basica");
		ItemStack lapis_block = new ItemStack(Material.LAPIS_BLOCK, 8);
		inv.setItem(9, lapis_block);

		ItemStack ferro_block = new ItemStack(Material.IRON_BLOCK, 8);
		inv.setItem(10, ferro_block);

		ItemStack diamond_block = new ItemStack(Material.DIAMOND_BLOCK, 8);
		inv.setItem(11, diamond_block);

		ItemStack capacete = new ItemStack(Material.DIAMOND_HELMET, 8);
		ItemMeta capacetem = capacete.getItemMeta();
		capacetem.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		capacetem.addEnchant(Enchantment.DURABILITY, 5, true);
		capacete.setItemMeta(capacetem);
		inv.setItem(12, capacete);

		ItemStack peito = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta peitom = peito.getItemMeta();
		peitom.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		peitom.addEnchant(Enchantment.DURABILITY, 5, true);
		peito.setItemMeta(peitom);
		inv.setItem(13, peito);

		ItemStack calca = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		ItemMeta calcam = calca.getItemMeta();
		calcam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		calcam.addEnchant(Enchantment.DURABILITY, 5, true);
		calca.setItemMeta(calcam);
		inv.setItem(14, calca);

		ItemStack bota = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta botam = bota.getItemMeta();
		botam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		botam.addEnchant(Enchantment.DURABILITY, 5, true);
		bota.setItemMeta(botam);
		inv.setItem(15, bota);

		ItemStack espada = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta espadam = espada.getItemMeta();
		espadam.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		espadam.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		espadam.addEnchant(Enchantment.DURABILITY, 5, true);
		espada.setItemMeta(espadam);
		inv.setItem(16, espada);

		ItemStack moeda = new ItemStack(175, 1);
		ItemMeta moedam = moeda.getItemMeta();
		moedam.setDisplayName("§e§lMoeda");
		ArrayList<String> desc = new ArrayList<String>();
		desc.add("&eUse esta moeda para ganhar objetos!");
		moedam.setLore(desc);
		inv.setItem(19, espada);

		p.openInventory(inv);
		p.updateInventory();
	}

	@SuppressWarnings("deprecation")
	public static void OpenCaixaMedia(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 5 * 9, "§eCaixa - Media");

		ItemStack lapis_block = new ItemStack(Material.LAPIS_BLOCK, 32);
		inv.setItem(10, lapis_block);

		ItemStack capacete = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta capacetem = capacete.getItemMeta();
		capacetem.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		capacetem.addEnchant(Enchantment.DURABILITY, 8, true);
		capacete.setItemMeta(capacetem);
		inv.setItem(11, capacete);
		
		ItemStack peito = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta peitom = peito.getItemMeta();
		peitom.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		peitom.addEnchant(Enchantment.DURABILITY, 8, true);
		peito.setItemMeta(peitom);
		inv.setItem(12, peito);

		ItemStack calca = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		ItemMeta calcam = calca.getItemMeta();
		calcam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		calcam.addEnchant(Enchantment.DURABILITY, 8, true);
		calca.setItemMeta(calcam);
		inv.setItem(13, calca);
		
		ItemStack bota = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta botam = bota.getItemMeta();
		botam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		botam.addEnchant(Enchantment.DURABILITY, 8, true);
		bota.setItemMeta(botam);
		inv.setItem(14, bota);

		ItemStack espada = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta espadam = espada.getItemMeta();
		espadam.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
		espadam.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		espadam.addEnchant(Enchantment.DURABILITY, 8, true);
		espada.setItemMeta(espadam);
		inv.setItem(15, espada);

		ItemStack espada5 = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta espadam5 = espada5.getItemMeta();
		espadam5.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		espadam5.addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, true);
		espadam5.addEnchant(Enchantment.DURABILITY, 5, true);
		espada5.setItemMeta(espadam5);
		inv.setItem(16, espada5);

		ItemStack moeda = new ItemStack(175, 3);
		ItemMeta moedam = moeda.getItemMeta();
		moedam.setDisplayName("§e§lMoeda");
		ArrayList<String> desc = new ArrayList<String>();
		desc.add("&eUse esta moeda para ganhar objetos!");
		moedam.setLore(desc);
		moeda.setItemMeta(moedam);
		inv.setItem(19, moeda);

		ItemStack coins = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta coinsm = coins.getItemMeta();
		coinsm.setDisplayName("§e100k");
		coins.setItemMeta(coinsm);
		inv.setItem(20, coins);

		p.openInventory(inv);
		p.updateInventory();
	}

	@SuppressWarnings("deprecation")
	public static void OpenCaixaFuturista(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 5 * 9, "§eCaixa - Futurista");

		ItemStack diamond_block = new ItemStack(Material.DIAMOND_BLOCK, 64);
		inv.setItem(10, diamond_block);
		
		ItemStack capacete = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta capacetem = capacete.getItemMeta();
		capacetem.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		capacetem.addEnchant(Enchantment.DURABILITY, 8, true);
		capacete.setItemMeta(capacetem);
		inv.setItem(11, capacete);
		
		ItemStack peito = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta peitom = peito.getItemMeta();
		peitom.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		peitom.addEnchant(Enchantment.DURABILITY, 8, true);
		peito.setItemMeta(peitom);
		inv.setItem(12, peito);
		
		ItemStack calca = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		ItemMeta calcam = calca.getItemMeta();
		calcam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		calcam.addEnchant(Enchantment.DURABILITY, 8, true);
		calca.setItemMeta(calcam);
		inv.setItem(13, calca);
		
		ItemStack bota = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta botam = bota.getItemMeta();
		botam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
		botam.addEnchant(Enchantment.DURABILITY, 8, true);
		bota.setItemMeta(botam);
		inv.setItem(14, bota);
		
		ItemStack espada = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta espadam = espada.getItemMeta();
		espadam.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		espadam.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
		espadam.addEnchant(Enchantment.DURABILITY, 10, true);
		espada.setItemMeta(espadam);
		inv.setItem(15, espada);
		
		ItemStack espada7 = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta espadam7 = espada7.getItemMeta();
		espadam7.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
		espadam7.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
		espadam7.addEnchant(Enchantment.DURABILITY, 7, true);
		espada7.setItemMeta(espadam7);
		inv.setItem(16, espada7);
		
		ItemStack moeda = new ItemStack(175, 3);
		ItemMeta moedam = moeda.getItemMeta();
		moedam.setDisplayName("§e§lMoeda");
		ArrayList<String> desc = new ArrayList<String>();
		desc.add("&eUse esta moeda para ganhar objetos!");
		moedam.setLore(desc);
		moeda.setItemMeta(moedam);
		inv.setItem(19, moeda);
		
		ItemStack coins = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta coinsm = coins.getItemMeta();
		coinsm.setDisplayName("§e250k");
		coins.setItemMeta(coinsm);
		inv.setItem(20, coins);
		
		ItemStack maca = new ItemStack(Material.GOLDEN_APPLE, 32, (short) 1);
		inv.setItem(21, maca);
		
		p.openInventory(inv);
		p.updateInventory();
	}

}
