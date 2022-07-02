package dev.vastusmc.lobby.api;

import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class VerificarGrupo {

	@SuppressWarnings("deprecation")
	public static boolean Vips(Player p) {
		String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
		boolean Vips = grupo.equalsIgnoreCase("Youtuber");
		boolean Moderadores = grupo.equalsIgnoreCase("Moderador+") || grupo.equalsIgnoreCase("Moderador");
		boolean Grupos = grupo.equalsIgnoreCase("Master") || grupo.equalsIgnoreCase("Gerente") || grupo.equalsIgnoreCase("Admin") || Moderadores || grupo.equalsIgnoreCase("Ajudante") || Vips;
		return Grupos;
	}
}
