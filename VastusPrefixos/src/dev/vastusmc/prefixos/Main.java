package dev.vastusmc.prefixos;

import org.bukkit.plugin.java.JavaPlugin;

import dev.vastusmc.prefixos.systems.Arrays;
import dev.vastusmc.prefixos.systems.Prefixos;

public class Main extends JavaPlugin {

	public static Main plugin;
	public static String Menssagems = "§5§lVastusMC §7➡ ";

	public void onEnable() {
		plugin = this;
		tags();
		Prefixos.runUpdate();
	}
	
	public void onDisable() {
		
	}

	public static void tags() {
		Arrays.grupoOrdem.put("master", 100);
		Arrays.grupoOrdem.put("gerente", 102);
		Arrays.grupoOrdem.put("coordenador", 103);
		Arrays.grupoOrdem.put("developer", 104);
		Arrays.grupoOrdem.put("admin", 105);
		Arrays.grupoOrdem.put("moderador", 106);
		Arrays.grupoOrdem.put("youtuber+", 107);
		Arrays.grupoOrdem.put("ajudante", 108);
		Arrays.grupoOrdem.put("youtuber", 110);
		Arrays.grupoOrdem.put("miniyt", 111);
		Arrays.grupoOrdem.put("universal", 112);
		Arrays.grupoOrdem.put("estelar", 113);
		Arrays.grupoOrdem.put("solar", 114);
		Arrays.grupoOrdem.put("lunar", 115);
		Arrays.grupoOrdem.put("nasa", 116);
		Arrays.grupoOrdem.put("netuno", 117);
		Arrays.grupoOrdem.put("urano", 118);
		Arrays.grupoOrdem.put("saturno", 119);
		Arrays.grupoOrdem.put("jupiter", 120);
		Arrays.grupoOrdem.put("marte", 121);
		Arrays.grupoOrdem.put("terra", 122);
		Arrays.grupoOrdem.put("venus", 123);
		Arrays.grupoOrdem.put("mercurio", 124);
		Arrays.grupoOrdem.put("membro", 999);
		
		Arrays.grupoPrefix.put("master", "§6[Master] ");
		Arrays.grupoPrefix.put("gerente", "§4[Gerente] ");
		Arrays.grupoPrefix.put("coordenador", "§3[Coord] ");
		Arrays.grupoPrefix.put("developer", "§e[Developer] ");
		Arrays.grupoPrefix.put("admin", "§c[Admin] ");
		Arrays.grupoPrefix.put("moderador", "§2[Moderador] ");
		Arrays.grupoPrefix.put("youtuber+", "§c[Youtuber+] ");
		Arrays.grupoPrefix.put("ajudante", "§a[Ajudante] ");
		Arrays.grupoPrefix.put("youtuber", "§c[Youtuber] ");
		Arrays.grupoPrefix.put("miniyt", "§c[MiniYt] ");
		Arrays.grupoPrefix.put("universal", "§a[VipUniversal] ");
		Arrays.grupoPrefix.put("estelar", "§6[VipEstrelar] ");
		Arrays.grupoPrefix.put("solar", "§e[VipSolar] ");
		Arrays.grupoPrefix.put("lunar", "§8[VipLunar] ");
		Arrays.grupoPrefix.put("nasa", "§9[Nasa] "); // PermissionsEx.getPermissionManager().getGroup("").getPrefix().replace("&", "§")
		Arrays.grupoPrefix.put("netuno", "§9[Netuno] ");
		Arrays.grupoPrefix.put("urano", "§3[Urano] ");
		Arrays.grupoPrefix.put("saturno", "§3[Saturno] ");
		Arrays.grupoPrefix.put("jupiter", "§e[Júpiter] ");
		Arrays.grupoPrefix.put("marte", "§c[Marte] ");
		Arrays.grupoPrefix.put("terra", "§b[Terra] ");
		Arrays.grupoPrefix.put("venus", "§6[Vênus] ");
		Arrays.grupoPrefix.put("mercurio", "§c[Mercúrio] ");
		Arrays.grupoPrefix.put("membro", "§7");
	}

}
