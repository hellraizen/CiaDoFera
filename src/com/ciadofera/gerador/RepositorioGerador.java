package com.ciadofera.gerador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.ciadofera.util.NumerosEscrito;
import com.ciadofera.util.TrataDataBr;

public class RepositorioGerador {
	
public void gerar(String nome,String cpf, Date data, int quantidade,String valor,String endereco) throws FileNotFoundException, IOException{
	
	
	
	
	
	JFileChooser win = new JFileChooser();
	int returValor = win.showSaveDialog(null);

	if (returValor == JFileChooser.APPROVE_OPTION) {
		XWPFDocument document = new XWPFDocument();

	XWPFWordExtractor pegar = new XWPFWordExtractor(document);
	
	
	
	for (int i = 0; i < quantidade; i++) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.MONTH,i );
		
		
		String dataCorrente = TrataDataBr.trataData(c.getTime());
		String dia = TrataDataBr.tranformarDataDia(c.getTime());
		String mes = TrataDataBr.tranformarDataMes(c.getTime());
		String ano = TrataDataBr.tranformarDataAno(c.getTime());
		
		
		String valorEstenso = NumerosEscrito.getExtenso(valor); 
		
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		
		
		run.setText("|Cia do FERA|");
		run.setFontSize(20);
		run.setBold(true);
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		XWPFParagraph paragraph2 = document.createParagraph();
		XWPFRun run2 = paragraph2.createRun();
		run2.setText("Nota Promissória");
		run2.setFontSize(20);
		run2.setBold(true);
		run2.setFontFamily("Impact");
		paragraph2.setAlignment(ParagraphAlignment.CENTER);
		
		
		XWPFParagraph paragraph1 = document.createParagraph();
		XWPFRun run1 = paragraph1.createRun();
		run1.addBreak();
		run1.setText("_____________________________________________________________________________");
		run1.addBreak();
		run1.setText("Nª "+(i+1)+"/"+quantidade+"          -           Vencimento :"+dataCorrente+"          -           Valor R$ ("+valor+",00).");
		run1.setBold(true);
		paragraph1.setAlignment(ParagraphAlignment.CENTER);
		XWPFParagraph paragraph3 = document.createParagraph();
		XWPFRun run3 = paragraph3.createRun();
		run3.addBreak();
		run3.setText("	Aos dias "+dia+" do mês de "+mes+" do ano de "+ano+", pagaremos por esta única via de NOTA PROMISSORIA a");
		run3.setText(" FABRICIA KISLLEY BARROS MENDES - ME, CNPJ 16860387/0001-96");
		run3.setText(" ou a sua ordem, a quantia de R$ "+valor+",00 ("+valorEstenso+" reais) em moeda corrente do pais.");
		run3.addBreak();
		run3.setText("Pagável em Caruaru - PERNAMBUCO.");
		run3.addBreak();
		run3.addBreak();
		run3.setText("                                                                                                            Caruaru ,"+dia+" de "+mes+" de "+ano+".");
		run3.addBreak();
		run3.addBreak();
		run3.addBreak();
		run3.setText("          EMITENTE: ________________________________________________ ");
		run3.addBreak();
		run3.setText("                                        "+nome+" / CPF: "+cpf);
		run3.addBreak();
		run3.setText("                                        "+endereco+".");
		run3.addBreak();
		run3.addBreak();
		run3.addBreak();
		run3.setText("------------------------------------------------------------------------------------------------------------------------------");
		
	}



	try {
		FileOutputStream output = new FileOutputStream(win.getSelectedFile());
		document.write(output);
		JOptionPane.showMessageDialog(null, "Criado com Sucesso");
		output.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
}
