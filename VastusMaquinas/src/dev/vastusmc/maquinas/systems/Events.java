package dev.vastusmc.maquinas.systems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import dev.vastusmc.maquinas.Main;

public class Events implements Listener {

	@EventHandler
	public void Ativar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if (e.getClickedBlock().getType() == Material.ENDER_PORTAL_FRAME) {
				if (p.getItemInHand().getType() != null) {
					if (p.getItemInHand().getType() == Material.COAL) {
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eCombustivel Basico")) {
							e.setCancelled(true);
							Arrays.maquinasligadas.add(e.getClickedBlock().getLocation());
							p.sendMessage(Main.Menssagems + "§fVoc§ abasteceu a maquina com sucesso.");
							ItemStack item = new ItemStack(Material.COAL, p.getItemInHand().getAmount() - 1);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§eCombustivel Basico");
							item.setItemMeta(itemm);
							p.getInventory().setItemInHand(item);
							new BukkitRunnable() {
								public void run() {
									if (Arrays.maquinasligadas.contains(e.getClickedBlock().getLocation()) == false) {
										cancel();
										return;
									}
									ItemStack item = new ItemStack(Material.BRICK, 64);
									p.getWorld().dropItem(e.getClickedBlock().getLocation(), item);
								}
							}.runTaskTimer(Main.plugin, 0L, 5 * 20L);

							new BukkitRunnable() {

								@Override
								public void run() {
									Arrays.maquinasligadas.remove(e.getClickedBlock().getLocation());
									p.sendMessage("§cO combustivel da sua maquina acabou.");
								}
							}.runTaskLater(Main.plugin, 60 * 20L);
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cCombustivel Avancado")) {
							e.setCancelled(true);
							Arrays.maquinasligadas.add(e.getClickedBlock().getLocation());
							p.sendMessage(Main.Menssagems + "§fVoc§ abasteceu a maquina com sucesso.");
							ItemStack item = new ItemStack(Material.COAL, p.getItemInHand().getAmount() - 1);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§cCombustivel Avancado");
							item.setItemMeta(itemm);
							p.getInventory().setItemInHand(item);
							new BukkitRunnable() {
								public void run() {
									if (Arrays.maquinasligadas.contains(e.getClickedBlock().getLocation()) == false) {
										cancel();
										return;
									}
									ItemStack item = new ItemStack(Material.BRICK, 64);
									p.getWorld().dropItem(e.getClickedBlock().getLocation(), item);
								}
							}.runTaskTimer(Main.plugin, 0L, 5 * 20L);
							new BukkitRunnable() {

								@Override
								public void run() {
									Arrays.maquinasligadas.remove(e.getClickedBlock().getLocation());
									p.sendMessage("§cO combustivel da sua maquina acabou.");
								}
							}.runTaskLater(Main.plugin, 180 * 20L);
						}
						e.setCancelled(true);
						return;
					}
				}
				e.setCancelled(true);
				return;
			}

			if (e.getClickedBlock().getType() == Material.REDSTONE_BLOCK) {
				if (p.getItemInHand().getType() != null) {
					if (p.getItemInHand().getType() == Material.COAL) {
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eCombustivel Basico")) {
							e.setCancelled(true);
							Arrays.maquinasligadas.add(e.getClickedBlock().getLocation());
							p.sendMessage(Main.Menssagems + "§fVoc§ abasteceu a maquina com sucesso.");
							ItemStack item = new ItemStack(Material.COAL, p.getItemInHand().getAmount() - 1);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§eCombustivel Basico");
							item.setItemMeta(itemm);
							p.getInventory().setItemInHand(item);
							new BukkitRunnable() {
								public void run() {
									if (Arrays.maquinasligadas.contains(e.getClickedBlock().getLocation()) == false) {
										cancel();
										return;
									}
									ItemStack item = new ItemStack(Material.NETHER_STAR, 64);
									p.getWorld().dropItem(e.getClickedBlock().getLocation(), item);
								}
							}.runTaskTimer(Main.plugin, 0L, 5 * 20L);
							new BukkitRunnable() {

								@Override
								public void run() {
									Arrays.maquinasligadas.remove(e.getClickedBlock().getLocation());
									p.sendMessage("§cO combustivel da sua maquina acabou.");
								}
							}.runTaskLater(Main.plugin, 60 * 20L);
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cCombustivel Avancado")) {
							e.setCancelled(true);
							Arrays.maquinasligadas.add(e.getClickedBlock().getLocation());
							p.sendMessage(Main.Menssagems + "§fVoc§ abasteceu a maquina com sucesso.");
							ItemStack item = new ItemStack(Material.COAL, p.getItemInHand().getAmount() - 1);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§cCombustivel Avancado");
							item.setItemMeta(itemm);
							p.getInventory().setItemInHand(item);
							new BukkitRunnable() {
								public void run() {
									if (Arrays.maquinasligadas.contains(e.getClickedBlock().getLocation()) == false) {
										cancel();
										return;
									}
									ItemStack item = new ItemStack(Material.NETHER_STAR, 64);
									p.getWorld().dropItem(e.getClickedBlock().getLocation(), item);
								}
							}.runTaskTimer(Main.plugin, 0L, 5 * 20L);
							new BukkitRunnable() {

								@Override
								public void run() {
									Arrays.maquinasligadas.remove(e.getClickedBlock().getLocation());
									p.sendMessage("§cO combustivel da sua maquina acabou.");
								}
							}.runTaskLater(Main.plugin, 180 * 20L);
						}
						e.setCancelled(true);
						return;
					}
				}
				e.setCancelled(true);
				return;
			}

			if (e.getClickedBlock().getType() == Material.OBSIDIAN) {
				if (p.getItemInHand().getType() != null) {
					if (p.getItemInHand().getType() == Material.COAL) {
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eCombustivel Basico")) {
							e.setCancelled(true);
							Arrays.maquinasligadas.add(e.getClickedBlock().getLocation());
							p.sendMessage(Main.Menssagems + "§fVoc§ abasteceu a maquina com sucesso.");
							ItemStack item = new ItemStack(Material.COAL, p.getItemInHand().getAmount() - 1);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§eCombustivel Basico");
							item.setItemMeta(itemm);
							p.getInventory().setItemInHand(item);
							new BukkitRunnable() {

								public void run() {
									if (Arrays.maquinasligadas.contains(e.getClickedBlock().getLocation()) == false) {
										cancel();
										return;
									}
									ItemStack item = new ItemStack(Material.MAGMA_CREAM, 64);
									p.getWorld().dropItem(e.getClickedBlock().getLocation(), item);
								}
							}.runTaskTimer(Main.plugin, 0L, 5 * 20L);
							new BukkitRunnable() {

								@Override
								public void run() {
									Arrays.maquinasligadas.remove(e.getClickedBlock().getLocation());
									p.sendMessage("§cO combustivel da sua maquina acabou.");
								}
							}.runTaskLater(Main.plugin, 60 * 20L);
						}
						if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cCombustivel Avancado")) {
							e.setCancelled(true);
							Arrays.maquinasligadas.add(e.getClickedBlock().getLocation());
							p.sendMessage(Main.Menssagems + "§fVoc§ abasteceu a maquina com sucesso.");
							ItemStack item = new ItemStack(Material.COAL, p.getItemInHand().getAmount() - 1);
							ItemMeta itemm = item.getItemMeta();
							itemm.setDisplayName("§cCombustivel Avancado");
							item.setItemMeta(itemm);
							p.getInventory().setItemInHand(item);
							new BukkitRunnable() {
								public void run() {
									if (Arrays.maquinasligadas.contains(e.getClickedBlock().getLocation()) == false) {
										cancel();
										return;
									}
									ItemStack item = new ItemStack(Material.MAGMA_CREAM, 64);
									p.getWorld().dropItem(e.getClickedBlock().getLocation(), item);
								}
							}.runTaskTimer(Main.plugin, 0L, 5 * 20L);
							new BukkitRunnable() {

								@Override
								public void run() {
									Arrays.maquinasligadas.remove(e.getClickedBlock().getLocation());
									p.sendMessage("§cO combustivel da sua maquina acabou.");
								}
							}.runTaskLater(Main.plugin, 180 * 20L);
						}
						e.setCancelled(true);
						return;
					}
				}
				e.setCancelled(true);
				return;
			}
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack s = new ItemStack(Material.OBSIDIAN);
		ItemMeta sm = s.getItemMeta();
		sm.setDisplayName("§6Maquina Solar");
		s.setItemMeta(sm);

		ItemStack estelar = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta estelarm = estelar.getItemMeta();
		estelarm.setDisplayName("§eMaquina Estelar");
		estelar.setItemMeta(estelarm);

		ItemStack f = new ItemStack(Material.ENDER_PORTAL_FRAME);
		ItemMeta fm = f.getItemMeta();
		fm.setDisplayName("§fMaquina Lunar");
		f.setItemMeta(fm);

		if (e.getBlock().getType() == Material.ENDER_PORTAL_FRAME) {
			p.getInventory().addItem(f);
			return;
		}

		if (e.getBlock().getType() == Material.REDSTONE_BLOCK) {
			p.getInventory().addItem(estelar);
			return;
		}

		if (e.getBlock().getType() == Material.OBSIDIAN) {
			p.getInventory().addItem(s);
			return;
		}
	}

	@EventHandler
	public void Drop(ItemSpawnEvent e) {
		if (e.getEntity().getItemStack().getType() == Material.OBSIDIAN) {
			e.setCancelled(true);
			return;
		}
		if (e.getEntity().getItemStack().getType() == Material.ENDER_PORTAL_FRAME) {
			e.setCancelled(true);
			return;
		}
		if (e.getEntity().getItemStack().getType() == Material.REDSTONE_BLOCK) {
			e.setCancelled(true);
			return;
		}
	}

}
