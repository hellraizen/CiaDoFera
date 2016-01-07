package com.ciadofera.util;


import java.text.SimpleDateFormat;
import java.util.Date;



public class TrataDataBr {
	
	public static String trataData(Date data){
		Date dia= data ;
		SimpleDateFormat sdFormate = new SimpleDateFormat("dd/MM/yyyy");
		String diaFormatado = sdFormate.format(dia);
		return diaFormatado;
		
	}
	
	public static String tranformarDataMes(Date data){
	   
		Date dia= data ;
		SimpleDateFormat sdFormate = new SimpleDateFormat("MMMMMM");
		String diaFormatado = sdFormate.format(dia);
		return diaFormatado;
	}
	
	public static String tranformarDataDia(Date data){
		   
		Date dia= data ;
		SimpleDateFormat sdFormate = new SimpleDateFormat("dd");
		String diaFormatado = sdFormate.format(dia);
		return diaFormatado;
	}
	
	public static String tranformarDataAno(Date data){
		   
		Date dia= data ;
		SimpleDateFormat sdFormate = new SimpleDateFormat("yyyy");
		String diaFormatado = sdFormate.format(dia);
		return diaFormatado;
	}

}
