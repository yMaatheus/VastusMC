package dev.vastusmc.lobby.systems;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import dev.vastusmc.lobby.Main;
import dev.vastusmc.lobby.api.TitleAPI;

public class Events implements Listener {

	@EventHandler
	public void NaoFicarComFome(FoodLevelChangeEvent evento) {
		evento.setFoodLevel(20);
	}

	@EventHandler
	public void SemCairFolhas(LeavesDecayEvent evento) {
		evento.setCancelled(true);
	}

	@EventHandler
	public void SemChuva(WeatherChangeEvent evento) {
		evento.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPing(ServerListPingEvent e) {
		e.setMotd(Main.prefix + " §eServidor em desenvolvimento!");
	}

	@EventHandler
	public void SemDurmir(PlayerBedEnterEvent evento) {
		evento.setCancelled(true);
	}

	@EventHandler
	public void CancelarPorcentagem(AsyncPlayerChatEvent evento) {
		if (evento.getMessage().contains("%")) {
			evento.setCancelled(true);
		}
	}

	@EventHandler
	public void cancelarTiros(ProjectileLaunchEvent evento) {
		if ((evento.getEntity().getShooter() instanceof Blaze)) {
			evento.setCancelled(true);
			return;
		}
		if ((evento.getEntity().getShooter() instanceof Wither)) {
			evento.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void SemDano(EntityDamageEvent evento) {
		evento.setCancelled(true);
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
	public void SemVerOsCmds(PlayerCommandPreprocessEvent evento) {
		Player jogador = evento.getPlayer();

		if (evento.getMessage().startsWith("/?")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/me")) {
			evento.setCancelled(true);
		} else if (evento.getMessage().startsWith("/bukkit:me")) {
			evento.setCancelled(true);
		} else if (evento.getMessage().startsWith("/bukkit:help")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/help")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/plugins")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/bukkit:plugins")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/pl")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/bukkit:pl")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/about")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/about")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/ver")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/bukkit:ver")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/bukkit:version")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		} else if (evento.getMessage().startsWith("/minecraft:me")) {
			evento.setCancelled(true);
		} else if (evento.getMessage().startsWith("/bukkit:?")) {
			if (!jogador.hasPermission("style.plugins")) {
				evento.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void naoQuebrarBloco(BlockBreakEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.getGameMode() != GameMode.CREATIVE) {
			evento.setCancelled(true);
		}
	}

	@EventHandler
	public void naoInteragir(PlayerInteractEvent evento) {
		if (evento.getAction() == Action.PHYSICAL) {
			evento.setCancelled(true);
		}
	}

	@EventHandler
	public void naoColocarBloco(BlockPlaceEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.getGameMode() != GameMode.CREATIVE) {
			evento.setCancelled(true);
		}
	}

	public static void main(String[] args) {
		System.out.println((float) -5 + (float) (Math.random() + ((5 - 5) + 1)));
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onExplodir(EntityExplodeEvent e) {
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
	public void naoDropar(PlayerDropItemEvent evento) {
		if (evento.getItemDrop().getItemStack().getType().equals(Material.COMPASS)) {
			evento.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
		p.teleport(p.getWorld().getSpawnLocation());
		p.getInventory().clear();
		Score.setScoreboard(p);
		p.setExp(0.0F);
		p.setLevel(0);
		p.setExhaustion(20.0F);
		p.setMaxHealth(20.0D);
		p.setFoodLevel(20);
		p.setGameMode(GameMode.ADVENTURE);
		p.setAllowFlight(false);
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		String site = "pagcraft.com.br/VastusMC";
		String twitter = "@VastusMC";
		TitleAPI.sendTabTitle(p, "\n§5§lVastusMC\n", "\n   §5Site:§f " + site + "   " + "\n§5Twitter:§f " + twitter + "\n");
		
		ItemStack item12 = new ItemStack(Material.COMPASS);
		ItemMeta itemmeta12 = item12.getItemMeta();
		itemmeta12.setDisplayName(Main.prefix);
		item12.setItemMeta(itemmeta12);
		p.getInventory().setItem(4, item12);
		
		p.updateInventory();
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}

	@SuppressWarnings("unused")
	@EventHandler
	public void modificarchat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		e.setCancelled(true);
		//e.setFormat(PermissionsEx.getUser(p.getName()).getGroups()[0].getPrefix().replace("&", "§") + p.getDisplayName() + " §7➡ §7" + e.getMessage().replace("&", "§"));
	}
}