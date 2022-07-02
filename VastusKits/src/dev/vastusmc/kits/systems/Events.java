package dev.vastusmc.kits.systems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import dev.vastusmc.kits.gui.InventoryApi;

public class Events implements Listener {

	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("§aKitsInventory")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKits normais")) {
				InventoryApi.openKitsNormais(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKits especiais")) {
				InventoryApi.openKitsEspeciais(p);
				return;
			}
		}
		if (e.getInventory().getName().equalsIgnoreCase("§aKitsNormaisInventory")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			if (e.getClick() == ClickType.RIGHT) {
				e.getWhoClicked().sendMessage("§cEm breve.");
				return;
			}
			if (e.getClick() == ClickType.LEFT) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit PvP")) {
					p.chat("/kit pvp");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Mercurio")) {
					p.chat("/kit mercurio");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Venus")) {
					p.chat("/kit venus");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Terra")) {
					p.chat("/kit terra");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Marte")) {
					p.chat("/kit marte");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Jupiter")) {
					p.chat("/kit jupiter");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Saturno")) {
					p.chat("/kit saturno");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Urano")) {
					p.chat("/kit urano");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Netuno")) {
					p.chat("/kit netuno");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Nasa")) {
					p.chat("/kit nasa");
					p.closeInventory();
					return;
				}
				return;
			}
		}
		if (e.getInventory().getName().equalsIgnoreCase("§aKitsEspeciaisInventory")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			if (e.getClick() == ClickType.RIGHT) {
				e.getWhoClicked().sendMessage("§cEm breve.");
				return;
			}
			if (e.getClick() == ClickType.LEFT) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Lunar Mensal")) {
					p.chat("/kit lunarmensal");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Solar Mensal")) {
					p.chat("/kit solarmensal");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Estelar Mensal")) {
					p.chat("/kit estelarmensal");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Universal Mensal")) {
					p.chat("/kit universalmensal");
					p.closeInventory();
					return;
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Lunar Semanal")) {
					p.chat("/kit lunarsemanal");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Solar Semanal")) {
					p.chat("/kit solarsemanal");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Estelar Semanal")) {
					p.chat("/kit estelarsemanal");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Universal Semanal")) {
					p.chat("/kit universalsemanal");
					p.closeInventory();
					return;
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Lunar Diario")) {
					p.chat("/kit lunardiario");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Solar Diario")) {
					p.chat("/kit solardiario");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Estelar Diario")) {
					p.chat("/kit estelardiario");
					p.closeInventory();
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eKit Universal Diario")) {
					p.chat("/kit universaldiario");
					p.closeInventory();
					return;
				}
				return;
			}
		}
	}

}
