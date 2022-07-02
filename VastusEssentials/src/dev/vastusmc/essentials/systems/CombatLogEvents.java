package dev.vastusmc.essentials.systems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.vastusmc.essentials.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CombatLogEvents implements Listener {

	@EventHandler (priority = EventPriority.MONITOR)
	public void Bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.isCancelled() || e.getDamage() < 1 || e.getDamage() == 0) {
				return;
			}
			if (e.getDamage() > 0) {
			Player p = (Player) e.getEntity();
			if (e.getDamager() instanceof Player) {
				Player t = (Player) e.getDamager();
				if (CombatlogManager.Combate.containsKey(p.getName())) {
					CombatlogManager.addCombat(p);
				}
				if (CombatlogManager.Combate.containsKey(p.getName()) == false) {
					CombatlogManager.addCombat(p);
					p.sendMessage("§cVoc§ entrou em combate com: " + t.getName());
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							CombatlogManager.Combate.remove(p.getName());
							p.sendMessage("§cVoce saiu de combate!");
						}
					}, 30 * 20);
				}
				if (CombatlogManager.Combate.containsKey(t.getName())) {
					CombatlogManager.addCombat(t);
				}
				if (CombatlogManager.Combate.containsKey(t.getName()) == false) {
					CombatlogManager.addCombat(t);
					t.sendMessage("§cVoc§ entrou em combate com: " + p.getName());
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							CombatlogManager.Combate.remove(t.getName());
							t.sendMessage("§cVoce saiu de combate!");
						}
					}, 30 * 20);
				}
			}

			if (e.getDamager() instanceof Player == false) {
				if (e.getDamager() instanceof Projectile) {
					Entity s = e.getDamager();
					s = (Entity) ((Projectile) s).getShooter();
					if (s instanceof Player) {
						Player t = (Player) s;
						if (CombatlogManager.Combate.containsKey(t.getName())) {
							CombatlogManager.addCombat(t);
							if (CombatlogManager.Combate.containsKey(t.getName()) == false) {
								CombatlogManager.addCombat(t);
								t.sendMessage("§cVoc§ entrou em combate com: " + p.getName());
								}
							}
						}
					}
				}
			}
		}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void BloquearCmds(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (CombatlogManager.Combate.containsKey(p.getName()) == true) {
			String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
			boolean outros = grupo.equalsIgnoreCase("Coordenador") || grupo.equalsIgnoreCase("Moderador");
			boolean VerificarStaff = grupo.equalsIgnoreCase("Master") || grupo.equalsIgnoreCase("Gerente") || grupo.equalsIgnoreCase("Developer") || grupo.equalsIgnoreCase("Admin") || outros;
			if (VerificarStaff) {
				e.setCancelled(false);
				return;
			}
			if (e.getMessage().contains("/g")) {
				e.setCancelled(false);
				return;
			}
			if (e.getMessage().contains("/report")) {
				e.setCancelled(false);
				return;
			}
			if (e.getMessage().contains("/l")) {
				e.setCancelled(false);
				return;
			}
			if (e.getMessage().contains("/tell")) {
				e.setCancelled(false);
				return;
			}
			if (e.getMessage().contains("/gladiador")) {
				e.setCancelled(false);
				return;
			}
			e.setCancelled(true);
			p.sendMessage("§cVoce est§ em combate!");
		}
	}
	
	@EventHandler
	public void Morrer(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = e.getEntity();
			if (CombatlogManager.Combate.containsKey(p.getName())) {
				CombatlogManager.Combate.remove(p.getName());
				return;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void Sair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (p.isDead() == false) {
			if (CombatlogManager.Combate.containsKey(p.getName())) {
				String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
				boolean outros = grupo.equalsIgnoreCase("Coordenador") || grupo.equalsIgnoreCase("Moderador");
				boolean VerificarStaff = grupo.equalsIgnoreCase("Master") || grupo.equalsIgnoreCase("Gerente") || grupo.equalsIgnoreCase("Developer") || grupo.equalsIgnoreCase("Admin") || outros;
				if (VerificarStaff) {
					CombatlogManager.Combate.remove(p.getName());
					return;
				}
				p.damage(1000.0D);
				CombatlogManager.Combate.remove(p.getName());
				Bukkit.broadcastMessage("§c" + p.getName() + " §cDeslogou em combate!");
			}
		}
	}

}