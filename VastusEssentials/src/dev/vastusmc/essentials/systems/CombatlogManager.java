package dev.vastusmc.essentials.systems;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class CombatlogManager {
	
	public static HashMap<String, Integer> Combate = new HashMap<>();
	
	public static boolean addCombat(Player p) {
		if (p.isOnline()) {
			Combate.put(p.getName(), 30);
			return true;
		}
		return false;
	}
}