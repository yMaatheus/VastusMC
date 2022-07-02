package dev.vastusmc.kits.systems;

public class TimeManager {
	
	public static String getMSGBunitu(long endOfBan) {
		String message = "";

		long now = System.currentTimeMillis();
		long diff = endOfBan - now;
		int seconds = (int) (diff / 1000);

		if (seconds >= 60 * 60 * 24) {
			int days = seconds / (60 * 60 * 24);
			seconds = seconds % (60 * 60 * 24);

			message += days + " dia(s) ";
		}
		if (seconds >= 60 * 60) {
			int hours = seconds / (60 * 60);
			seconds = seconds % (60 * 60);

			message += hours + " hora(s) ";
		}
		if (seconds >= 60) {
			int min = seconds / 60;
			seconds = seconds % 60;

			message += min + " minutos(s) ";
		}
		if (seconds >= 0) {
			message += seconds + " segundos(s) ";
		}
		
		if (message == "") {
			return "0";
		}
		return message;
	}
	
	public static long converte(long dia, long hora, long minuto, long segu) {
		long x = 0;

		long min = minuto * 60;
		long hor = hora * 3600;
		long dias = dia * 86400;

		x = min + hor + dias + segu;
		long tempo1 = System.currentTimeMillis() + x * 1000;
		return tempo1;
	}

	public static String getallArgs(String[] args, int inicio) {
		String str = "";

		for (int x = inicio; x < args.length; x++) {
			str = args[x] + " ";
		}

		return str;
	}

}