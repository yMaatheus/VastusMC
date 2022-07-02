package dev.vastusmc.kits.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.vastusmc.kits.Main;
import dev.vastusmc.kits.gui.InventoryApi;
import dev.vastusmc.kits.systems.Arrays;
import dev.vastusmc.kits.systems.KitInventory;
import dev.vastusmc.kits.systems.PlayerPOO;
import dev.vastusmc.kits.systems.TimeManager;

public class Kit implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player == false) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				PlayerPOO.CreateJogador(p.getName().toLowerCase());
				PlayerPOO.deBug(p.getName().toLowerCase());
				InventoryApi.openKits(p);
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("pvp")) {
					PlayerPOO.CreateJogador(p.getName().toLowerCase());
					PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
					long kit = player.pvp;
					if (kit != 0) {
						p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
						if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
							player.pvp = 0;
							player.save = true;
						}
						return true;
					}
					KitInventory.DarKitPvP(p);
					p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5PvP§f.");
					long cooldown = TimeManager.converte(0, 0, 20, 1);
					player.pvp = cooldown;
					player.save = true;
					Arrays.playerdados.put(p.getName().toLowerCase(), player);
					return true;
				}
				if (args[0].equalsIgnoreCase("mercurio")) {
					if (p.hasPermission("kit.mercurio")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.mercurio;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.mercurio = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitMercurio(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Mercurio§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.mercurio = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("venus")) {
					if (p.hasPermission("kit.venus")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.venus;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.venus = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitVenus(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.venus = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("terra")) {
					if (p.hasPermission("kit.terra")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.terra;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.terra = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitTerra(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.terra = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("marte")) {
					if (p.hasPermission("kit.marte")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.marte;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.marte = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitMarte(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.marte = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("jupiter")) {
					if (p.hasPermission("kit.jupiter")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.jupiter;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.jupiter = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitJupiter(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.jupiter = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("saturno")) {
					if (p.hasPermission("kit.saturno")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.saturno;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.saturno = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitSaturno(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.saturno = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("urano")) {
					if (p.hasPermission("kit.urano")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.urano;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.urano = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitUrano(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.urano = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("netuno")) {
					if (p.hasPermission("kit.netuno")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.netuno;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.netuno = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitUrano(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.netuno = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("nasa")) {
					if (p.hasPermission("kit.nasa")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.nasa;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.nasa = 0;
								player.save = true;
							}
							return true;
						}
						KitInventory.DarKitNasa(p);
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5Venus§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.nasa = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("lunardiario")) {
					if (p.hasPermission("kit.lunar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.lunardiario;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.lunardiario = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5LunarDiario§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.lunardiario = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("lunarsemanal")) {
					if (p.hasPermission("kit.lunar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.lunarsemanal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.lunarsemanal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5LunarSemanal§f.");
						long cooldown = TimeManager.converte(7, 0, 0, 1);
						player.lunarsemanal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("lunarmensal")) {
					if (p.hasPermission("kit.lunar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.lunarmensal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.lunarmensal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5LunarMensal§f.");
						long cooldown = TimeManager.converte(30, 0, 0, 1);
						player.lunarmensal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("solardiario")) {
					if (p.hasPermission("kit.solar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.solardiario;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.solardiario = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5SolarDiario§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.solardiario = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("solarsemanal")) {
					if (p.hasPermission("kit.solar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.solarsemanal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.solarsemanal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5SolarSemanal§f.");
						long cooldown = TimeManager.converte(7, 0, 0, 1);
						player.solarsemanal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("solarmensal")) {
					if (p.hasPermission("kit.solar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.solarmensal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.solarmensal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5SolarMensal§f.");
						long cooldown = TimeManager.converte(30, 0, 0, 1);
						player.solarmensal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("estelardiario")) {
					if (p.hasPermission("kit.estelar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.estelardiario;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.estelardiario = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5EstelarDiario§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.estelardiario = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				
				if (args[0].equalsIgnoreCase("estelarsemanal")) {
					if (p.hasPermission("kit.estelar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.estelarsemanal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.estelarsemanal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5EstelarSemanal§f.");
						long cooldown = TimeManager.converte(7, 0, 0, 1);
						player.estelarsemanal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				
				if (args[0].equalsIgnoreCase("estelarmensal")) {
					if (p.hasPermission("kit.estelar")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.estelarmensal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.estelarmensal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5EstelarMensal§f.");
						long cooldown = TimeManager.converte(30, 0, 0, 1);
						player.estelarmensal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("universaldiario")) {
					if (p.hasPermission("kit.universal")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.universaldiario;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.universaldiario = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5UniversalDiario§f.");
						long cooldown = TimeManager.converte(1, 0, 0, 1);
						player.universaldiario = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("universalsemanal")) {
					if (p.hasPermission("kit.universal")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.universalsemanal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.universalsemanal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5UniversalSemanal§f.");
						long cooldown = TimeManager.converte(7, 0, 0, 1);
						player.universalsemanal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				
				if (args[0].equalsIgnoreCase("universalmensal")) {
					if (p.hasPermission("kit.universal")) {
						PlayerPOO.CreateJogador(p.getName().toLowerCase());
						PlayerPOO player = Arrays.playerdados.get(p.getName().toLowerCase());
						long kit = player.universalmensal;
						if (kit != 0) {
							p.sendMessage(Main.Mensagens + "§fVoc§ est§ em delay aguarde: §5" + TimeManager.getMSGBunitu(Long.valueOf(kit)));
							if (TimeManager.getMSGBunitu(Long.valueOf(kit)) == "0") {
								player.universalmensal = 0;
								player.save = true;
							}
							return true;
						}
						p.sendMessage(Main.Mensagens + "§fVoc§ recebeu o kit §5UniversalMensal§f.");
						long cooldown = TimeManager.converte(30, 0, 0, 1);
						player.universalmensal = cooldown;
						player.save = true;
						Arrays.playerdados.put(p.getName().toLowerCase(), player);
					} else {
						p.sendMessage("§cSem permiss§o.");
					}
					return true;
				}
				return true;
			}
		}
		return false;
	}

}