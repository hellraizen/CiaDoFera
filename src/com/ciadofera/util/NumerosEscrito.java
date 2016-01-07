package com.ciadofera.util;

public class NumerosEscrito {
	  private static String trioextenso[][]={
		       {"dummy", "um", "dois", "tr�s", "quatro", "cinco", "seis", "sete",
		        "oito", "nove"},
		       {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis",
		        "dezessete", "dezoito", "dezenove"},
		       {"dummy", "dummy", "vinte", "trinta", "quarenta",
		        "cinquenta", "sessenta", "setenta", "oitenta", "noventa"},
		       {"dummy", "cento", "duzentos", "trezentos",
		        "quatrocentos", "quinhentos", "seiscentos",
		        "setecentos", "oitocentos", "novecentos"}
		    };

		   private static String classextenso[] ={
		               "dummy", "mil", "milh", "bilh", "trilh", "quatrilh",
		               "quintilh", "sextilh", "septilh", "octilh",
		               "nonilh", "decilh", "undecilh", "duodecilh",
		               "tredecilh", "quatordecilh", "quindecilh",
		               "sexdecilh", "setedecilh", "octodecilh",
		               "novedecilh", "vigesilh" };

		   /* Adiciona conjun��o 'e' no extenso de um trio. */
		   public static String adicionar_conjuncao_e(String saida) {

		       /* Retira espa�o inicial */
		       if(saida.charAt(0) == ' ') saida = saida.substring(1) ;

		       /* Retira espa�o final */
		       if(saida.charAt(saida.length()-1) == ' ')
		           saida = saida.substring(0, saida.length()-1) ;

		       /* Troca " " por " e " */
		       saida = saida.replaceAll(" ", " e ") ;

		       return saida ;
		   }

		   /* Recebe um trio da forma cdu e o transforma
		    * em extenso.
		    */
		   public static String escrever_trio_extenso(String trio) {
		       String saida="" ;
		       char u, d, c;

		       u=trio.charAt(2);
		       d=trio.charAt(1);
		       c=trio.charAt(0);

		       if(trio.equals("100")) saida="cem" ;
		       else if(trio.equals("000")) saida="zero" ;
		       else {
		           if(c!='0') saida=trioextenso[3][c-'0'];
		           if(d=='1') saida=saida+" "+trioextenso[1][u-'0'];
		           else {
		               if(d!='0') saida=saida+" "+trioextenso[2][d-'0'];
		               if(u!='0') saida=saida+" "+trioextenso[0][u-'0'] ;
		           }
		       }

		       saida = adicionar_conjuncao_e(saida) ;

		       return saida ;
		   }

		   /* Retorna um vetor de Strings sendo cada elemento
		    * um trio. A ordem dos trios est� inversa em
		    * rela��o ao original.
		    */
		   private static String[] getTriosAoContrario(String numero) {
		       String[] vetorTrios ;
		       int t ;

		       t=numero.length()/3 ;
		       vetorTrios = new String[t] ;

		       for(String s : numero.replaceAll("...", "$0,").split(",")) {
		           vetorTrios[t-1]=s; t-- ;
		       }

		       return vetorTrios ;
		   }

		   private static boolean nao_e_ultimo_trio(String[] vetorTrios, int contador) {
		       return (vetorTrios.length != contador+1) ;
		   }

		   private static boolean trio_a_esquerda_eq_zero(String[] vetorTrios, int contador) {
		       return (vetorTrios[contador+1].equals("000")) ;
		   }

		    public static String getExtenso(String numero) {
		        String saida = "", extensoFinal = "";
		        String[] vetorTrios;
		        int contador = 0;
		        int t ;

		        /* Padding: Garante que a quantidade de alg.
		         * do n�mero seja multipla de tr�s.
		         */
		        t = numero.length() % 3;
		        if (t == 1) {
		            numero = "00" + numero;
		        } else if (t == 2) {
		            numero = "0" + numero;
		        }

		        /* N�mero zero. */
		        if(numero.equals("000")) return "zero" ;

		        vetorTrios = getTriosAoContrario(numero);

		        /* Para cada trio na ordem inversa ... */
		        for (String trio : vetorTrios) {
		            if (!trio.equals("000")) {
		                saida = escrever_trio_extenso(trio);
		                /* Obt�m a classe. */
		                if (contador > 0) {
		                    saida = saida + " " + classextenso[contador];
		                }
		                /* Plural das classes. */
		                if (contador > 1) {
		                    if (Integer.parseInt(trio)>1) {
		                        saida = saida + "�es";
		                    } else {
		                        saida = saida + "�o";
		                    }
		                }

		                /* Jun��o dos extensos. */
		                if (nao_e_ultimo_trio(vetorTrios, contador)) {
		                    if (trio_a_esquerda_eq_zero(vetorTrios, contador)) {
		                        saida = " e " + saida;
		                    } else if (trio.charAt(0) != '0') {
		                        saida = ", " + saida;
		                    } else {
		                        saida = " e " + saida;
		                    }
		                }
		                extensoFinal = saida + extensoFinal;
		            }
		            contador++;
		        }

		        return extensoFinal;
		    }
		

}
