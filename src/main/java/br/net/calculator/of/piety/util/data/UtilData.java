package br.net.calculator.of.piety.util.data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class UtilData {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA_MINUTO = "dd/MM/yyyy HH:mm";
	public static final String FORMATO_DATA_HORA_MINUTO_SEGUNDO = "dd/MM/yyyy HH:mm:ss";


	
	/**
	 * 
	 * @param data1
	 * @param data2
	 * @return retorna a diferença em meses entre duas datas data2 - data1
	 *         considerando o dia do mes ou seja se data1 = 15/01/2017 e a data2
	 *         = 14/02/2017 retorna 0
	 */
	public static long retornaDiferencaEmMesesEntreDatas(final Date data1, final Date data2) {

		
		LocalDate ldData1 = dateToLocalDate(zerarHora(data1));
		LocalDate ldData2 = dateToLocalDate(zerarHora(data2));

		long diferencaEmDias = ChronoUnit.MONTHS.between(ldData1, ldData2);

		return diferencaEmDias;
	}
	
	public static long retornaDiferencaEmDiasEntreDatas(final LocalDate data1, final LocalDate data2) {
		long diferencaEmDias = ChronoUnit.DAYS.between(data1, data2 );

		return diferencaEmDias;
	}

	public static long retornaDiferencaEmDiasEntreDatas(final Date data1, final Date data2) {

		LocalDate ldData1 = dateToLocalDate(zerarHora(data1));
		LocalDate ldData2 = dateToLocalDate(zerarHora(data2));
		

		return retornaDiferencaEmDiasEntreDatas(ldData1, ldData2);
	}

	
	public static LocalDate dateToLocalDate(final Date data1) {
		Instant instant = data1.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate ldDatea = zdt.toLocalDate();
		return ldDatea;
	}
	
	
	public static Date zerarHora(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
