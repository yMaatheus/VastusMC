package dev.vastusmc.bans.systems;

import java.sql.SQLException;
import java.sql.Statement;

import dev.vastusmc.bans.sql.Mysql;

public class PlayerPOO {

	public String jogador;
	public String por;
	public String motivo;
	public String ip;
	public String data;

	public boolean save = false;

	public PlayerPOO(String jogador) {
		this.jogador = jogador;
	}

	public void PlayerUpdate(Statement stmt, String jogador) throws SQLException {
		if (Mysql.ExistePlayer(jogador.toLowerCase()) == false) {
			String v = Mysql.v;
			stmt.execute("INSERT INTO " + Mysql.tabela + " (Jogador, Por, Motivo, Ip, Data) VALUES ('" + jogador + v + this.por + v + this.motivo + v + this.ip + v + this.data + "');");
		}
	}

}
