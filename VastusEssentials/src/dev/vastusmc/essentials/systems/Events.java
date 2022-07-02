package dev.vastusmc.essentials.systems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.util.Vector;

import dev.vastusmc.essentials.Main;
import dev.vastusmc.essentials.api.VerificarGrupo;
import dev.vastusmc.essentials.commands.Jail;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.Effect;
import org.bukkit.entity.Entity;

public class Events implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Arrays.tpa.put(p.getName(), "off");
		for (Player todos : Arrays.Invisivel) {
			if (!VerificarGrupo.Moderacao(p)) {
				p.hidePlayer(todos);
			}
		}

		if (Jail.jail.get(p) == null) {
			Jail.jail.put(p, false);
		}

		if (Jail.jail.get(p) == true) {
			Location loc = LocationUtil.getLocation(Main.plugin.getConfig().getString("jail"));
			p.teleport(loc);
		}
		e.setJoinMessage(null);
		Location loc = LocationUtil.getLocation(Main.plugin.getConfig().getString("spawn"));

		p.teleport(loc);
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (Arrays.god.contains(p)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void cairVoid(EntityDamageEvent evento) {
		if ((evento.getEntity() instanceof Player)) {
			if (evento.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
				Player jogador = (Player) evento.getEntity();
				evento.setCancelled(true);
				jogador.teleport(jogador.getWorld().getSpawnLocation());
			}
		}
	}

	@EventHandler
	public void ReSpawn(PlayerRespawnEvent e) {
		e.setRespawnLocation(Bukkit.getWorld("Rankup").getSpawnLocation());
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onExplodir(EntityExplodeEvent e) {
		e.setCancelled(true);
		for (Block p : e.blockList()) {
			float x = (float) -2 + (float) (Math.random() + ((2 - -2) + 1));
			float y = (float) -1 + (float) (Math.random() + ((2 - -2) + 1));
			float z = (float) -2.5 + (float) (Math.random() + ((2.5 - -2.5) + 1));

			FallingBlock fallingBlock = p.getWorld().spawnFallingBlock(p.getLocation(), p.getType(), p.getData());
			fallingBlock.setDropItem(false);
			fallingBlock.setVelocity(new Vector(x, y, z));

			p.setType(Material.AIR);
		}
	}

	@EventHandler
	public void placacoloridinha(SignChangeEvent event) {
		String l0 = event.getLine(0);
		String l1 = event.getLine(1);
		String l2 = event.getLine(2);
		String l3 = event.getLine(3);
		event.setLine(0, l0.replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&k", "§k").replaceAll("&l", "§l").replaceAll("&m", "§m").replaceAll("&n", "§n").replaceAll("&o", "§o").replaceAll("&r", "§r"));
		event.setLine(1, l1.replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&k", "§k").replaceAll("&l", "§l").replaceAll("&m", "§m").replaceAll("&n", "§n").replaceAll("&o", "§o").replaceAll("&r", "§r"));
		event.setLine(2, l2.replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&k", "§k").replaceAll("&l", "§l").replaceAll("&m", "§m").replaceAll("&n", "§n").replaceAll("&o", "§o").replaceAll("&r", "§r"));
		event.setLine(3, l3.replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&k", "§k").replaceAll("&l", "§l").replaceAll("&m", "§m").replaceAll("&n", "§n").replaceAll("&o", "§o").replaceAll("&r", "§r"));
	}

	@EventHandler
	public void onExplosionPrime(ExplosionPrimeEvent event) {
		@SuppressWarnings("unused")
		Entity entity = event.getEntity();
		Location loc = event.getEntity().getLocation();
		event.getEntity().getLocation().getWorld().playEffect(loc, Effect.EXTINGUISH, 10);
		event.getEntity().getLocation().getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 10);
		event.getEntity().getLocation().getWorld().playEffect(loc, Effect.GHAST_SHOOT, 10);
		event.getEntity().setFallDistance(50.0F);
		event.setCancelled(true);
	}

	@EventHandler
	public void Redstone(BlockRedstoneEvent e) {
		if (e.getBlock().getWorld().getName().equalsIgnoreCase("Rankup"))
			e.setNewCurrent(0);
	}

	@EventHandler
	public void onPistao1(BlockPistonExtendEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onPistao2(BlockPistonRetractEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onSair(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}

	@EventHandler
	private void onPlayerSendCommand(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();

		if (Jail.jail.get(player) == null) {
			return;
		}
		if (Jail.jail.get(player) == true) {
			event.setCancelled(true);
			player.sendMessage("§cVoce n§o pode utilizar comandos enquanto est§ na jail.");
			return;
		}
	}

	@EventHandler
	public void TrocarDeMundo(PlayerChangedWorldEvent e) {
		if (e.getPlayer().getWorld().getName().equalsIgnoreCase(Main.plotworld) == false) {
			Player p = e.getPlayer();
			if ((VerificarGrupo.Moderacao(p) == false) && (p.getAllowFlight())) {
				p.setAllowFlight(false);
				return;
			}
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Arrays.Invisivel.contains(e.getPlayer())) {
			Arrays.Invisivel.remove(e.getPlayer());
		}
		if (Arrays.god.contains(e.getPlayer())) {
			Arrays.god.remove(e.getPlayer());
		}

		if (Jail.jail.get(e.getPlayer()) != null && Jail.jail.get(e.getPlayer()) == true) {
			for (Player todos : Bukkit.getOnlinePlayers()) {
				if (VerificarGrupo.Moderacao(todos)) {
					todos.sendMessage("§c" + e.getPlayer().getName() + " deslogou enquanto estava na jail!");
				}
			}
		}
		List<HumanEntity> fechar = new ArrayList<HumanEntity>();
		fechar.addAll(p.getInventory().getViewers());
		fechar.addAll(p.getEnderChest().getViewers());
		for (HumanEntity he : fechar) {
			he.closeInventory();
			he.sendMessage("§cO jogador " + p.getName() + " deslogou, invsee/enderchest fechado!");
		}
	}

	@EventHandler
	public void login(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (e.getResult() == Result.KICK_FULL) {
			if (p.hasPermission("essentials.entrar")) {
				e.setResult(Result.ALLOWED);
			}
		}
		if (e.getResult() == Result.KICK_WHITELIST) {
			e.setKickMessage("§cServidor est§ em manuten§§o.");
		}
	}

	@EventHandler
	public void NaoFicarComFome(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
	}

	@EventHandler
	public void SemCairFolhas(LeavesDecayEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void SemChuva(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void SemDurmir(PlayerBedEnterEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage(null);
	}

	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
		if (e.getLocation().getWorld().getName().contains("plotworld")) {
			if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM) {
				return;
			}
			if (e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.SPAWNER) {
				e.setCancelled(true);
			}
		} else if ((e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.CUSTOM)
				&& (e.getEntityType() != EntityType.VILLAGER)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void invClick(InventoryClickEvent e) {
		if (e.getInventory().getName().contains("§aInv: ")) {
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			e.setCancelled(true);
		}
	}
}