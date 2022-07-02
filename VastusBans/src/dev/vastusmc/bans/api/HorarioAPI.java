package dev.vastusmc.bans.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class HorarioAPI {
	  
    public static String getHorario() {
	TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
	Calendar calendar = GregorianCalendar.getInstance(tz);
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	return sdf.format(calendar.getTime());
    }
}
