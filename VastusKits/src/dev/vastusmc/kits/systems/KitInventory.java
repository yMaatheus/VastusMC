package dev.vastusmc.kits.systems;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitInventory {

	public static void DarItens(Player p, String NomeItens, int enchant) {
		String name = NomeItens;
		int enchantlevel = enchant;
		ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta EspadaMeta = Espada.getItemMeta();
		EspadaMeta.setDisplayName(name);
		EspadaMeta.addEnchant(Enchantment.DAMAGE_ALL, enchantlevel, true);
		EspadaMeta.addEnchant(Enchantment.DURABILITY, enchantlevel, true);
		Espada.setItemMeta(EspadaMeta);

		ItemStack Helmo = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta HelmoMeta = Helmo.getItemMeta();
		HelmoMeta.setDisplayName(name);
		HelmoMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchantlevel, true);
		HelmoMeta.addEnchant(Enchantment.DURABILITY, enchantlevel, true);
		Helmo.setItemMeta(HelmoMeta);

		ItemStack Peitoral = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta PeitoralMeta = Peitoral.getItemMeta();
		PeitoralMeta.setDisplayName(name);
		PeitoralMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchantlevel, true);
		PeitoralMeta.addEnchant(Enchantment.DURABILITY, enchantlevel, true);
		Peitoral.setItemMeta(PeitoralMeta);

		ItemStack Calca = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta CalcaMeta = Calca.getItemMeta();
		CalcaMeta.setDisplayName(name);
		CalcaMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchantlevel, true);
		CalcaMeta.addEnchant(Enchantment.DURABILITY, enchantlevel, true);
		Calca.setItemMeta(CalcaMeta);

		ItemStack Botas = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta BotasMeta = Botas.getItemMeta();
		BotasMeta.setDisplayName(name);
		BotasMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchantlevel, true);
		BotasMeta.addEnchant(Enchantment.DURABILITY, enchantlevel, true);
		Botas.setItemMeta(BotasMeta);

		ItemStack Maca = new ItemStack(Material.GOLDEN_APPLE, 10, (byte) 1);
		ItemMeta MacaMeta = Maca.getItemMeta();
		MacaMeta.setDisplayName(name);
		Maca.setItemMeta(MacaMeta);

		p.getInventory().addItem(Espada);
		p.getInventory().addItem(Helmo);
		p.getInventory().addItem(Peitoral);
		p.getInventory().addItem(Calca);
		p.getInventory().addItem(Botas);
		p.getInventory().addItem(Maca);
	}

	public static void DarItensVip(Player p, String NomeItens, int enchant) {
		ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta EspadaMeta = Espada.getItemMeta();
		EspadaMeta.setDisplayName(NomeItens);
		EspadaMeta.addEnchant(Enchantment.DAMAGE_ALL, enchant, true);
		EspadaMeta.addEnchant(Enchantment.FIRE_ASPECT, enchant, true);
		EspadaMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Espada.setItemMeta(EspadaMeta);

		ItemStack Helmo = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta HelmoMeta = Helmo.getItemMeta();
		HelmoMeta.setDisplayName(NomeItens);
		HelmoMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		HelmoMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Helmo.setItemMeta(HelmoMeta);

		ItemStack Peitoral = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta PeitoralMeta = Peitoral.getItemMeta();
		PeitoralMeta.setDisplayName(NomeItens);
		PeitoralMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		PeitoralMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Peitoral.setItemMeta(PeitoralMeta);

		ItemStack Calca = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta CalcaMeta = Calca.getItemMeta();
		CalcaMeta.setDisplayName(NomeItens);
		CalcaMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		CalcaMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Calca.setItemMeta(CalcaMeta);

		ItemStack Botas = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta BotasMeta = Botas.getItemMeta();
		BotasMeta.setDisplayName(NomeItens);
		BotasMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		BotasMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Botas.setItemMeta(BotasMeta);

		ItemStack Machado = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta MachadoMeta = Machado.getItemMeta();
		MachadoMeta.setDisplayName(NomeItens);
		MachadoMeta.addEnchant(Enchantment.DAMAGE_ALL, enchant, true);
		MachadoMeta.addEnchant(Enchantment.FIRE_ASPECT, enchant, true);
		MachadoMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Machado.setItemMeta(MachadoMeta);

		ItemStack Picareta = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta PicaretaMeta = Picareta.getItemMeta();
		PicaretaMeta.setDisplayName(NomeItens);
		PicaretaMeta.addEnchant(Enchantment.DIG_SPEED, enchant, true);
		PicaretaMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, enchant, true);
		PicaretaMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Picareta.setItemMeta(PicaretaMeta);

		ItemStack EnderChest = new ItemStack(Material.ENDER_CHEST);

		ItemStack Diamantes = new ItemStack(Material.DIAMOND, 64);

		ItemStack PoDeBlaze = new ItemStack(Material.BLAZE_ROD, 15);

		ItemStack SuporteDePocao = new ItemStack(Material.BREWING_STAND);

		ItemStack LagrimasDeGhast = new ItemStack(Material.GHAST_TEAR, 16);

		ItemStack Arco = new ItemStack(Material.BOW);
		ItemMeta ArcoMeta = Arco.getItemMeta();
		ArcoMeta.setDisplayName(NomeItens);
		ArcoMeta.addEnchant(Enchantment.ARROW_DAMAGE, enchant, true);
		ArcoMeta.addEnchant(Enchantment.ARROW_FIRE, enchant, true);
		ArcoMeta.addEnchant(Enchantment.ARROW_INFINITE, enchant, true);
		ArcoMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Arco.setItemMeta(ArcoMeta);

		ItemStack Flechas = new ItemStack(Material.ARROW);

		p.getInventory().addItem(Espada);
		p.getInventory().addItem(Helmo);
		p.getInventory().addItem(Peitoral);
		p.getInventory().addItem(Calca);
		p.getInventory().addItem(Botas);
		p.getInventory().addItem(Machado);
		p.getInventory().addItem(Picareta);
		p.getInventory().addItem(EnderChest);
		p.getInventory().addItem(Diamantes);
		p.getInventory().addItem(PoDeBlaze);
		p.getInventory().addItem(SuporteDePocao);
		p.getInventory().addItem(LagrimasDeGhast);
		p.getInventory().addItem(Arco);
		p.getInventory().addItem(Flechas);
	}

	public static void DarKitPvP(Player p) {
		DarItens(p, "§eKit PvP", 4);
	}

	public static void DarKitMercurio(Player p) {
		DarItens(p, "§eKit Merc§rio", 6);
	}

	public static void DarKitVenus(Player p) {
		DarItens(p, "§eKit V§nus", 7);
	}

	public static void DarKitTerra(Player p) {
		DarItens(p, "§eKit Terra", 8);
	}

	public static void DarKitMarte(Player p) {
		DarItens(p, "§eKit Marte", 9);
	}

	public static void DarKitJupiter(Player p) {
		DarItens(p, "§eKit Jupiter", 10);
	}

	public static void DarKitSaturno(Player p) {
		DarItens(p, "§eKit Saturno", 11);
	}

	public static void DarKitUrano(Player p) {
		DarItens(p, "§eKit Urano", 12);
	}

	public static void DarKitNetuno(Player p) {
		DarItens(p, "§eKit Netuno", 13);
	}

	public static void DarKitNasa(Player p) {
		DarItens(p, "§eKit Nasa", 14);
	}

	public static void DarKitLunarDiario(Player p) {
	}

	public static void DarKitLunarSemanal(Player p) {
	}

	@SuppressWarnings("deprecation")
	public static void DarKitLunarMensal(Player p) {
		DarItensVip(p, "§eLunar Mensal", 15);
		ItemStack PocaoDeForca = new ItemStack(373, 15, (byte) 8233);
		ItemStack PocaoDeVelocidade = new ItemStack(373, 15, (byte) 8226);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "maquina dar " + p.getName() + " lunar");
		p.getInventory().addItem(PocaoDeForca);
		p.getInventory().addItem(PocaoDeVelocidade);
	}

	public static void DarKitSolarDiario(Player p) {
	}

	public static void DarKitSolarSemanal(Player p) {
	}

	@SuppressWarnings("deprecation")
	public static void DarKitSolarMensal(Player p) {
		String NomeItens = "§eSolar Mensal";
		int enchant = 15;
		DarItensVip(p, "§eSolar Mensal", 15);
		ItemStack Helmo = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta HelmoMeta = Helmo.getItemMeta();
		HelmoMeta.setDisplayName(NomeItens);
		HelmoMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		HelmoMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Helmo.setItemMeta(HelmoMeta);

		ItemStack Peitoral = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta PeitoralMeta = Peitoral.getItemMeta();
		PeitoralMeta.setDisplayName(NomeItens);
		PeitoralMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		PeitoralMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Peitoral.setItemMeta(PeitoralMeta);

		ItemStack Calca = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta CalcaMeta = Calca.getItemMeta();
		CalcaMeta.setDisplayName(NomeItens);
		CalcaMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		CalcaMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Calca.setItemMeta(CalcaMeta);

		ItemStack Botas = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta BotasMeta = Botas.getItemMeta();
		BotasMeta.setDisplayName(NomeItens);
		BotasMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		BotasMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Botas.setItemMeta(BotasMeta);
		ItemStack PocaoDeForca = new ItemStack(373, 30, (byte) 8233);
		ItemStack PocaoDeVelocidade = new ItemStack(373, 30, (byte) 8226);
		p.getInventory().addItem(Helmo);
		p.getInventory().addItem(Peitoral);
		p.getInventory().addItem(Calca);
		p.getInventory().addItem(Botas);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "maquina dar " + p.getName() + " solar");
		p.getInventory().addItem(PocaoDeForca);
		p.getInventory().addItem(PocaoDeVelocidade);
	}

	public static void DarKitEstelarDiario(Player p) {
	}

	public static void DarKitEstelarSemanal(Player p) {
	}

	@SuppressWarnings("deprecation")
	public static void DarKitEstelarMensal(Player p) {
		String NomeItens = "§eEstelar Mensal";
		int enchant = 15;
		DarItensVip(p, "§eEstelar Mensal", 15);
		ItemStack Helmo = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta HelmoMeta = Helmo.getItemMeta();
		HelmoMeta.setDisplayName(NomeItens);
		HelmoMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		HelmoMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Helmo.setItemMeta(HelmoMeta);

		ItemStack Peitoral = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta PeitoralMeta = Peitoral.getItemMeta();
		PeitoralMeta.setDisplayName(NomeItens);
		PeitoralMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		PeitoralMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Peitoral.setItemMeta(PeitoralMeta);

		ItemStack Calca = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta CalcaMeta = Calca.getItemMeta();
		CalcaMeta.setDisplayName(NomeItens);
		CalcaMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		CalcaMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Calca.setItemMeta(CalcaMeta);

		ItemStack Botas = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta BotasMeta = Botas.getItemMeta();
		BotasMeta.setDisplayName(NomeItens);
		BotasMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		BotasMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Botas.setItemMeta(BotasMeta);
		ItemStack PocaoDeForca = new ItemStack(373, 60, (byte) 8233);
		ItemStack PocaoDeVelocidade = new ItemStack(373, 60, (byte) 8226);
		p.getInventory().addItem(Helmo);
		p.getInventory().addItem(Peitoral);
		p.getInventory().addItem(Calca);
		p.getInventory().addItem(Botas);
		p.getInventory().addItem(Helmo);
		p.getInventory().addItem(Peitoral);
		p.getInventory().addItem(Calca);
		p.getInventory().addItem(Botas);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "maquina dar " + p.getName() + " estelar");
		p.getInventory().addItem(PocaoDeForca);
		p.getInventory().addItem(PocaoDeVelocidade);
	}

	public static void DarKitUniversalDiario(Player p) {
	}

	public static void DarKitUniversalSemanal(Player p) {
	}

	@SuppressWarnings("deprecation")
	public static void DarKitUniversalMensal(Player p) {
		String NomeItens = "§eUniversal Mensal";
		int enchant = 15;
		DarItensVip(p, "§eUniversal Mensal", 15);
		ItemStack Helmo = new ItemStack(Material.DIAMOND_HELMET, 2);
		ItemMeta HelmoMeta = Helmo.getItemMeta();
		HelmoMeta.setDisplayName(NomeItens);
		HelmoMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		HelmoMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Helmo.setItemMeta(HelmoMeta);

		ItemStack Peitoral = new ItemStack(Material.DIAMOND_CHESTPLATE, 2);
		ItemMeta PeitoralMeta = Peitoral.getItemMeta();
		PeitoralMeta.setDisplayName(NomeItens);
		PeitoralMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		PeitoralMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Peitoral.setItemMeta(PeitoralMeta);

		ItemStack Calca = new ItemStack(Material.DIAMOND_LEGGINGS, 2);
		ItemMeta CalcaMeta = Calca.getItemMeta();
		CalcaMeta.setDisplayName(NomeItens);
		CalcaMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		CalcaMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Calca.setItemMeta(CalcaMeta);

		ItemStack Botas = new ItemStack(Material.DIAMOND_BOOTS, 2);
		ItemMeta BotasMeta = Botas.getItemMeta();
		BotasMeta.setDisplayName(NomeItens);
		BotasMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchant, true);
		BotasMeta.addEnchant(Enchantment.DURABILITY, enchant, true);
		Botas.setItemMeta(BotasMeta);
		ItemStack PocaoDeForca = new ItemStack(373, 60, (byte) 8233);
		ItemStack PocaoDeVelocidade = new ItemStack(373, 60, (byte) 8226);
		p.getInventory().addItem(Helmo);
		p.getInventory().addItem(Peitoral);
		p.getInventory().addItem(Calca);
		p.getInventory().addItem(Botas);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "maquina dar " + p.getName() + " universal");
		p.getInventory().addItem(PocaoDeForca);
		p.getInventory().addItem(PocaoDeVelocidade);
	}

}
