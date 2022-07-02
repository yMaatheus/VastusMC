package dev.vastusmc.reparador.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dev.vastusmc.reparador.Main;
import dev.vastusmc.reparador.api.VerificarGrupo;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

public class SetReparador implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setreparador")) {
			if (VerificarGrupo.Gerentecia(p)) {
				Villager villager = (Villager)p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
				villager.setAdult();
				villager.setCustomName("§aReparador");
				villager.setCustomNameVisible(true);
				villager.setProfession(Profession.BLACKSMITH);
				villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99*99*99, 7));
				
				Entity nmsEntity = ((CraftEntity) villager).getHandle();
				NBTTagCompound tag = nmsEntity.getNBTTag();
				if (tag == null) {
					tag = new NBTTagCompound();
				}
				nmsEntity.c(tag);
				tag.setInt("NoAI", 1);
				nmsEntity.f(tag);
				
				p.sendMessage(Main.Menssagems + "§fVoc§ spawnou o §5Reparador§f.");
				return true;
			}
		}
		return false;
	}

}
