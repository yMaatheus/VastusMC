package dev.vastusmc.bans.api;

import dev.vastusmc.bans.systems.Arrays;

public class IpApi {
	
	public static String getIp(String jogador) {
		if (Arrays.IpSave.containsKey(jogador.toLowerCase())) {
			return Arrays.IpSave.get(jogador.toLowerCase());
		} else {
			return "null";
		}
	}

}
