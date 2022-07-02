package dev.vastusmc.reparador.api;

import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class VerificarGrupo {
	
	@SuppressWarnings("deprecation")
	public static boolean Staff(Player p) {
		String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
		boolean gerente = grupo.equalsIgnoreCase("Gerente") || grupo.equalsIgnoreCase("Coordenador");
		boolean moderador = grupo.equalsIgnoreCase("Moderador");
		boolean Grupos = grupo.equalsIgnoreCase("Master") || gerente || grupo.equalsIgnoreCase("Admin") || moderador || grupo.equalsIgnoreCase("Ajudante");
		return Grupos;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Moderacao(Player p) {
		String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
		boolean gerente = grupo.equalsIgnoreCase("Gerente") || grupo.equalsIgnoreCase("Coordenador");
		boolean moderador = grupo.equalsIgnoreCase("Moderador");
		boolean Grupos = grupo.equalsIgnoreCase("Master") || gerente || grupo.equalsIgnoreCase("Admin") || moderador;
		return Grupos;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Administracao(Player p) {
		String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
		boolean gerente = grupo.equalsIgnoreCase("Gerente") || grupo.equalsIgnoreCase("Coordenador");
		boolean Grupos = grupo.equalsIgnoreCase("Master") || gerente || grupo.equalsIgnoreCase("Admin");
		return Grupos;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Coordenacao(Player p) {
		String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
		boolean gerente = grupo.equalsIgnoreCase("Gerente") || grupo.equalsIgnoreCase("Coordenador");
		boolean Grupos = grupo.equalsIgnoreCase("Master") || gerente;
		return Grupos;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Gerentecia(Player p) {
		String grupo = PermissionsEx.getUser(p).getGroups()[0].getName();
		boolean Grupos = grupo.equalsIgnoreCase("Master") || grupo.equalsIgnoreCase("Gerente");
		return Grupos;
	}
}
