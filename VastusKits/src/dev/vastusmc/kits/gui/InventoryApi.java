package dev.vastusmc.kits.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryApi {
	
	public static void openKits(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 3 * 9, "§aKitsInventory");

		ItemStack KitsMembros = new ItemStack(Material.ARROW);
		ItemMeta KitsMembrosm = KitsMembros.getItemMeta();
		KitsMembrosm.setDisplayName("§eKits normais");
		KitsMembros.setItemMeta(KitsMembrosm);
		inv.setItem(11, KitsMembros);
		
		ItemStack KitsVip = new ItemStack(Material.DIAMOND);
		ItemMeta KitsVipm = KitsVip.getItemMeta();
		KitsVipm.setDisplayName("§eKits especiais");
		KitsVip.setItemMeta(KitsVipm);
		inv.setItem(14, KitsVip);
		
		p.openInventory(inv);
		p.updateInventory();
	}
	
	@SuppressWarnings("deprecation")
	public static void openKitsNormais(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 4 * 9, "§aKitsNormaisInventory");

		ItemStack KitPvP = new ItemStack(Material.IRON_SWORD);
		ItemMeta KitPvPm = KitPvP.getItemMeta();
		KitPvPm.setDisplayName("§eKit PvP");
		ArrayList<String> desc = new ArrayList<String>();
		desc.add("");
		desc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		desc.add("§7Bot§o direito: §5Ver itens.");
		desc.add("");
		KitPvPm.setLore(desc);
		KitPvP.setItemMeta(KitPvPm);
		inv.setItem(11, KitPvP);
		
		ItemStack KitMercurio = new ItemStack(351,1,(byte) 1);
		ItemMeta KitMercuriom = KitMercurio.getItemMeta();
		KitMercuriom.setDisplayName("§eKit Mercurio");
		ArrayList<String> Mercuriodesc = new ArrayList<String>();
		Mercuriodesc.add("");
		Mercuriodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		Mercuriodesc.add("§7Bot§o direito: §5Ver itens.");
		Mercuriodesc.add("");
		KitMercuriom.setLore(Mercuriodesc);
		KitMercurio.setItemMeta(KitMercuriom);
		inv.setItem(12, KitMercurio);
		
		ItemStack KitVenus = new ItemStack(351,1,(byte) 14);
		ItemMeta KitVenusm = KitVenus.getItemMeta();
		KitVenusm.setDisplayName("§eKit Venus");
		ArrayList<String> KitVenusdesc = new ArrayList<String>();
		KitVenusdesc.add("");
		KitVenusdesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitVenusdesc.add("§7Bot§o direito: §5Ver itens.");
		KitVenusdesc.add("");
		KitVenusm.setLore(KitVenusdesc);
		KitVenus.setItemMeta(KitVenusm);
		inv.setItem(13, KitVenus);
		
		ItemStack KitTerra = new ItemStack(351,1,(byte) 12);
		ItemMeta KitTerram = KitTerra.getItemMeta();
		KitTerram.setDisplayName("§eKit Terra");
		ArrayList<String> KitTerradesc = new ArrayList<String>();
		KitTerradesc.add("");
		KitTerradesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitTerradesc.add("§7Bot§o direito: §5Ver itens.");
		KitTerradesc.add("");
		KitTerram.setLore(KitTerradesc);
		KitTerra.setItemMeta(KitTerram);
		inv.setItem(14, KitTerra);
		
		ItemStack KitMarte = new ItemStack(12,1,(byte) 1);
		ItemMeta KitMartem = KitMarte.getItemMeta();
		KitMartem.setDisplayName("§eKit Marte");
		ArrayList<String> KitMartedesc = new ArrayList<String>();
		KitMartedesc.add("");
		KitMartedesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitMartedesc.add("§7Bot§o direito: §5Ver itens.");
		KitMartedesc.add("");
		KitMartem.setLore(KitMartedesc);
		KitMarte.setItemMeta(KitMartem);
		inv.setItem(15, KitMarte);
		
		ItemStack KitJupiter = new ItemStack(351,1,(byte) 11);
		ItemMeta KitJupiterm = KitJupiter.getItemMeta();
		KitJupiterm.setDisplayName("§eKit Jupiter");
		ArrayList<String> KitJupiterdesc = new ArrayList<String>();
		KitJupiterdesc.add("");
		KitJupiterdesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitJupiterdesc.add("§7Bot§o direito: §5Ver itens.");
		KitJupiterdesc.add("");
		KitJupiterm.setLore(KitJupiterdesc);
		KitJupiter.setItemMeta(KitJupiterm);
		inv.setItem(20, KitJupiter);
		
		ItemStack KitSaturno = new ItemStack(351,1,(byte) 10);
		ItemMeta KitSaturnom = KitSaturno.getItemMeta();
		KitSaturnom.setDisplayName("§eKit Saturno");
		ArrayList<String> KitSaturnodesc = new ArrayList<String>();
		KitSaturnodesc.add("");
		KitSaturnodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitSaturnodesc.add("§7Bot§o direito: §5Ver itens.");
		KitSaturnodesc.add("");
		KitSaturnom.setLore(KitSaturnodesc);
		KitSaturno.setItemMeta(KitSaturnom);
		inv.setItem(21, KitSaturno);
		
		ItemStack KitUrano = new ItemStack(351,1,(byte) 6);
		ItemMeta KitUranom = KitUrano.getItemMeta();
		KitUranom.setDisplayName("§eKit Urano");
		ArrayList<String> KitUranodesc = new ArrayList<String>();
		KitUranodesc.add("");
		KitUranodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitUranodesc.add("§7Bot§o direito: §5Ver itens.");
		KitUranodesc.add("");
		KitUranom.setLore(KitUranodesc);
		KitUrano.setItemMeta(KitUranom);
		inv.setItem(22, KitUrano);
		
		ItemStack KitNetuno = new ItemStack(351,1,(byte) 4);
		ItemMeta KitNetunom = KitNetuno.getItemMeta();
		KitNetunom.setDisplayName("§eKit Netuno");
		ArrayList<String> KitNetunodesc = new ArrayList<String>();
		KitNetunodesc.add("");
		KitNetunodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitNetunodesc.add("§7Bot§o direito: §5Ver itens.");
		KitNetunodesc.add("");
		KitNetunom.setLore(KitNetunodesc);
		KitNetuno.setItemMeta(KitNetunom);
		inv.setItem(23, KitNetuno);
		
		ItemStack KitNasa = new ItemStack(353);
		ItemMeta KitNasam = KitNasa.getItemMeta();
		KitNasam.setDisplayName("§eKit Nasa");
		ArrayList<String> KitNasadesc = new ArrayList<String>();
		KitNasadesc.add("");
		KitNasadesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitNasadesc.add("§7Bot§o direito: §5Ver itens.");
		KitNasadesc.add("");
		KitNasam.setLore(KitNasadesc);
		KitNasa.setItemMeta(KitNasam);
		inv.setItem(24, KitNasa);
		
		p.openInventory(inv);
		p.updateInventory();
	}
	
	@SuppressWarnings("deprecation")
	public static void openKitsEspeciais(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 5 * 9, "§aKitsEspeciaisInventory");
		
		ItemStack KitLunarMensal = new ItemStack(173);
		ItemMeta KitLunarMensalm = KitLunarMensal.getItemMeta();
		KitLunarMensalm.setDisplayName("§eKit Lunar Mensal");
		ArrayList<String> KitLunarMensaldesc = new ArrayList<String>();
		KitLunarMensaldesc.add("");
		KitLunarMensaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitLunarMensaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitLunarMensaldesc.add("");
		KitLunarMensalm.setLore(KitLunarMensaldesc);
		KitLunarMensal.setItemMeta(KitLunarMensalm);
		inv.setItem(11, KitLunarMensal);
		
		ItemStack KitSolarMensal = new ItemStack(41);
		ItemMeta KitSolarMensalm = KitSolarMensal.getItemMeta();
		KitSolarMensalm.setDisplayName("§eKit Solar Mensal");
		ArrayList<String> KitSolarMensaldesc = new ArrayList<String>();
		KitSolarMensaldesc.add("");
		KitSolarMensaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitSolarMensaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitSolarMensaldesc.add("");
		KitSolarMensalm.setLore(KitSolarMensaldesc);
		KitSolarMensal.setItemMeta(KitSolarMensalm);
		inv.setItem(12, KitSolarMensal);
		
		ItemStack KitEstelarMensal = new ItemStack(155);
		ItemMeta KitEstelarMensalm = KitEstelarMensal.getItemMeta();
		KitEstelarMensalm.setDisplayName("§eKit Estelar Mensal");
		ArrayList<String> KitEstelarMensaldesc = new ArrayList<String>();
		KitEstelarMensaldesc.add("");
		KitEstelarMensaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitEstelarMensaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitEstelarMensaldesc.add("");
		KitEstelarMensalm.setLore(KitEstelarMensaldesc);
		KitEstelarMensal.setItemMeta(KitEstelarMensalm);
		inv.setItem(14, KitEstelarMensal);
		
		ItemStack KitUniversalMensal = new ItemStack(133);
		ItemMeta KitUniversalMensalm = KitUniversalMensal.getItemMeta();
		KitUniversalMensalm.setDisplayName("§eKit Universal Mensal");
		ArrayList<String> KitUniversalMensaldesc = new ArrayList<String>();
		KitUniversalMensaldesc.add("");
		KitUniversalMensaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitUniversalMensaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitUniversalMensaldesc.add("");
		KitUniversalMensalm.setLore(KitUniversalMensaldesc);
		KitUniversalMensal.setItemMeta(KitUniversalMensalm);
		inv.setItem(15, KitUniversalMensal);
		
		ItemStack KitLunarSemanal = new ItemStack(16);
		ItemMeta KitLunarSemanalm = KitLunarSemanal.getItemMeta();
		KitLunarSemanalm.setDisplayName("§eKit Lunar Semanal");
		ArrayList<String> KitLunarSemanaldesc = new ArrayList<String>();
		KitLunarSemanaldesc.add("");
		KitLunarSemanaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitLunarSemanaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitLunarSemanaldesc.add("");
		KitLunarSemanalm.setLore(KitLunarSemanaldesc);
		KitLunarSemanal.setItemMeta(KitLunarSemanalm);
		inv.setItem(20, KitLunarSemanal);
		
		ItemStack KitSolarSemanal = new ItemStack(14);
		ItemMeta KitSolarSemanalm = KitSolarSemanal.getItemMeta();
		KitSolarSemanalm.setDisplayName("§eKit Solar Semanal");
		ArrayList<String> KitSolarSemanaldesc = new ArrayList<String>();
		KitSolarSemanaldesc.add("");
		KitSolarSemanaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitSolarSemanaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitSolarSemanaldesc.add("");
		KitSolarSemanalm.setLore(KitSolarSemanaldesc);
		KitSolarSemanal.setItemMeta(KitSolarSemanalm);
		inv.setItem(21, KitSolarSemanal);
		
		ItemStack KitEstelarSemanal = new ItemStack(153);
		ItemMeta KitEstelarSemanalm = KitEstelarSemanal.getItemMeta();
		KitEstelarSemanalm.setDisplayName("§eKit Estelar Semanal");
		ArrayList<String> KitEstelarSemanaldesc = new ArrayList<String>();
		KitEstelarSemanaldesc.add("");
		KitEstelarSemanaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitEstelarSemanaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitEstelarSemanaldesc.add("");
		KitEstelarSemanalm.setLore(KitEstelarSemanaldesc);
		KitEstelarSemanal.setItemMeta(KitEstelarSemanalm);
		inv.setItem(23, KitEstelarSemanal);
		
		ItemStack KitUniversalSemanal = new ItemStack(129);
		ItemMeta KitUniversalSemanalm = KitUniversalSemanal.getItemMeta();
		KitUniversalSemanalm.setDisplayName("§eKit Universal Semanal");
		ArrayList<String> KitUniversalSemanaldesc = new ArrayList<String>();
		KitUniversalSemanaldesc.add("");
		KitUniversalSemanaldesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitUniversalSemanaldesc.add("§7Bot§o direito: §5Ver itens.");
		KitUniversalSemanaldesc.add("");
		KitUniversalSemanalm.setLore(KitUniversalSemanaldesc);
		KitUniversalSemanal.setItemMeta(KitUniversalSemanalm);
		inv.setItem(24, KitUniversalSemanal);
		
		ItemStack KitLunarDiario = new ItemStack(263);
		ItemMeta KitLunarDiariom = KitLunarDiario.getItemMeta();
		KitLunarDiariom.setDisplayName("§eKit Lunar Diario");
		ArrayList<String> KitLunarDiariodesc = new ArrayList<String>();
		KitLunarDiariodesc.add("");
		KitLunarDiariodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitLunarDiariodesc.add("§7Bot§o direito: §5Ver itens.");
		KitLunarDiariodesc.add("");
		KitLunarDiariom.setLore(KitLunarDiariodesc);
		KitLunarDiario.setItemMeta(KitLunarDiariom);
		inv.setItem(29, KitLunarDiario);
		
		ItemStack KitSolarDiario = new ItemStack(266);
		ItemMeta KitSolarDiariom = KitSolarDiario.getItemMeta();
		KitSolarDiariom.setDisplayName("§eKit Solar Diario");
		ArrayList<String> KitSolarDiariodesc = new ArrayList<String>();
		KitSolarDiariodesc.add("");
		KitSolarDiariodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitSolarDiariodesc.add("§7Bot§o direito: §5Ver itens.");
		KitSolarDiariodesc.add("");
		KitSolarDiariom.setLore(KitSolarDiariodesc);
		KitSolarDiario.setItemMeta(KitSolarDiariom);
		inv.setItem(30, KitSolarDiario);
		
		ItemStack KitEstelarDiario = new ItemStack(399);
		ItemMeta KitEstelarDiariom = KitEstelarDiario.getItemMeta();
		KitEstelarDiariom.setDisplayName("§eKit Estelar Diario");
		ArrayList<String> KitEstelarDiariodesc = new ArrayList<String>();
		KitEstelarDiariodesc.add("");
		KitEstelarDiariodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitEstelarDiariodesc.add("§7Bot§o direito: §5Ver itens.");
		KitEstelarDiariodesc.add("");
		KitEstelarDiariom.setLore(KitEstelarDiariodesc);
		KitEstelarDiario.setItemMeta(KitEstelarDiariom);
		inv.setItem(32, KitEstelarDiario);
		
		ItemStack KitUniversalDiario = new ItemStack(388);
		ItemMeta KitUniversalDiariom = KitUniversalDiario.getItemMeta();
		KitUniversalDiariom.setDisplayName("§eKit Universal Diario");
		ArrayList<String> KitUniversalDiariodesc = new ArrayList<String>();
		KitUniversalDiariodesc.add("");
		KitUniversalDiariodesc.add("§7Bot§o esquerdo: §5Pegar o kit.");
		KitUniversalDiariodesc.add("§7Bot§o direito: §5Ver itens.");
		KitUniversalDiariodesc.add("");
		KitUniversalDiariom.setLore(KitUniversalDiariodesc);
		KitUniversalDiario.setItemMeta(KitUniversalDiariom);
		inv.setItem(33, KitUniversalDiario);
		
		p.openInventory(inv);
		p.updateInventory();
	}

}
