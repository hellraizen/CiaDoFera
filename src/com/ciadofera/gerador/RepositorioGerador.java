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
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.ciadofera.util.NumerosEscrito;
import com.ciadofera.util.TrataDataBr;

public class RepositorioGerador {
	
public void gerar(String nome,String cpf, Date data, int quantidade,String valor,String endereco) throws FileNotFoundException, IOException{
	
	
	
	
	
	JFileChooser win = new JFileChooser();
	int returValor = win.showOpenDialog(null);

	if (returValor == JFileChooser.APPROVE_OPTION) {
		XWPFDocument document = new XWPFDocument(new FileInputStream(win.getSelectedFile()));

	XWPFWordExtractor pegar = new XWPFWordExtractor(document);
	
	
	XWPFParagraph paragraph = document.createParagraph();
	XWPFRun run = paragraph.createRun();
	for (int i = 0; i < quantidade; i++) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.MONTH,i );
		
		
		String dataCorrente = TrataDataBr.trataData(c.getTime());
		String dia = TrataDataBr.tranformarDataDia(c.getTime());
		String mes = TrataDataBr.tranformarDataMes(c.getTime());
		String ano = TrataDataBr.tranformarDataAno(c.getTime());
		
		
		String valorEstenso = NumerosEscrito.getExtenso(valor); 
		
		
		
		
		run.setText("********************************** |CIA do Fera| *******************************");
		run.addBreak();
		run.setText(" ********************************* Nota Promissória *****************************");
		run.addBreak();
		run.addBreak();
		run.setText("_____________________________________________________________________________");
		run.addBreak();
		run.setText("Nª "+(i+1)+"/"+quantidade+"          -           Vencimento :"+dataCorrente+"          -           Valor R$ ("+valor+",00).");
		run.addBreak();
		run.addBreak();
		run.setText("	Aos dias "+dia+" do mês de "+mes+" do ano de "+ano+", pagaremos por esta única via de NOTA PROMISSORIA  a CIA do Fera , CNPJ 16860387/0001-96  ou a sua ordem, a quantia de R$ "+valor+",00 ( "+valorEstenso+" reais ) em moeda corrente do pais.");
		run.addBreak();
		run.setText("Pagável em Caruaru - PERNAMBUCO.");
		run.addBreak();
		run.addBreak();
		run.setText("                                                                                                            Caruaru ,"+dia+" de "+mes+" de "+ano+" .");
		run.addBreak();
		run.addBreak();
		run.addBreak();
		run.setText("          EMITENTE(S): ________________________________________________ ");
		run.addBreak();
		run.setText("                                        "+nome+" / CPF : "+cpf);
		run.addBreak();
		run.setText("                                        "+endereco+".");
		run.addBreak();
		run.addBreak();
		run.setText("------------------------------------------------------------------------------------------------------------------------------");
		run.addBreak();
		run.addBreak();
		run.addBreak();
		run.addBreak();
		run.addBreak();
		run.setText("------------------------------------------------------------------------------------------------------------------------------");
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
