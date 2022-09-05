package br.com.av1;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import org.jfree.data.time.Millisecond;
import org.jfree.ui.RefineryUtilities;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.util.concurrent.Semaphore;

public class Corretora implements Runnable {
	Semaphore caixa = new Semaphore(2);
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private ArrayList<Double> fechamentoAtivo1 = new ArrayList<>();
	private ArrayList<Double> fechamentoAtivo2 = new ArrayList<>();
	private ArrayList<Double> fechamentoAtivo3 = new ArrayList<>();
	private ArrayList<Double> fechamentoAtivo4 = new ArrayList<>();

	public Corretora() {
		
		Thread corretora = new Thread(this);
		corretora.start();
	}

	@Override
	public void run() {
		
		
		final Grafico ativo1 = new Grafico("Ativo 1");
		ativo1.pack();
		RefineryUtilities.centerFrameOnScreen(ativo1);
		ativo1.setVisible(true);

		LeituraCsv leituraCsv1 = new LeituraCsv();
		LeituraCsv leituraCsv2 = new LeituraCsv();
		LeituraCsv leituraCsv3 = new LeituraCsv();
		LeituraCsv leituraCsv4 = new LeituraCsv();

		fechamentoAtivo1 = leituraCsv1.leituraPalavras("C:\\Users\\MIGUEL\\Desktop\\Automação Avançada\\USDCHF.csv");
		fechamentoAtivo2 = leituraCsv2.leituraPalavras("C:\\Users\\MIGUEL\\Desktop\\Automação Avançada\\EURUSD.csv");
		fechamentoAtivo3 = leituraCsv3.leituraPalavras("C:\\Users\\MIGUEL\\Desktop\\Automação Avançada\\USDCAD.csv");
		fechamentoAtivo4 = leituraCsv4.leituraPalavras("C:\\Users\\MIGUEL\\Desktop\\Automação Avançada\\USDJPY.csv");

		Cliente cliente1 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "1",
				caixa);
		Cliente cliente2 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "2",
				caixa);
		Cliente cliente3 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "3",
				caixa);
		Cliente cliente4 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "4",
				caixa);
		Cliente cliente5 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "5",
				caixa);
		Cliente cliente6 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "6",
				caixa);
		Cliente cliente7 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "7",
				caixa);
		Cliente cliente8 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "8",
				caixa);
		Cliente cliente9 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4, "9",
				caixa);
		Cliente cliente10 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"10", caixa);
		Cliente cliente11 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"11", caixa);
		Cliente cliente12 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"12", caixa);
		Cliente cliente13 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"13", caixa);
		Cliente cliente14 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"14", caixa);
		Cliente cliente15 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"15", caixa);
		Cliente cliente16 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"16", caixa);
		Cliente cliente17 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"17", caixa);
		Cliente cliente18 = new Cliente(500, fechamentoAtivo1, fechamentoAtivo2, fechamentoAtivo3, fechamentoAtivo4,
				"18", caixa);
		

		try {
			WritableWorkbook planilha = Workbook.createWorkbook(new File("C:\\Users\\MIGUEL\\Desktop\\Dados.xls"));

			WritableSheet aba = planilha.createSheet("Médias", 0);

			String cabecalho[] = new String[8];
			cabecalho[0] = "Média Curta Ativo 1";
			cabecalho[1] = "Media Longa Ativo 1";
			cabecalho[2] = "Media Curta Ativo 2";
			cabecalho[3] = "Media Longa Ativo 2";
			cabecalho[4] = "Media Curta Ativo 3";
			cabecalho[5] = "Media Longa Ativo 3";
			cabecalho[6] = "Media Curta Ativo 4";
			cabecalho[7] = "Media Longa Ativo 4";

			Colour bckcolor = Colour.DARK_GREEN;
			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setBackground(bckcolor);

			WritableFont fonte = new WritableFont(WritableFont.ARIAL);
			fonte.setColour(Colour.GOLD);
			cellFormat.setFont(fonte);

			for (int i = 0; i < cabecalho.length; i++) {
				Label label = new Label(i, 0, cabecalho[i]);
				aba.addCell(label);
				WritableCell cell = aba.getWritableCell(i, 0);
				cell.setCellFormat(cellFormat);
			}

			for (int i = 0; i < 8000; i++) {
				//System.out.println(System.currentTimeMillis());
				
				ativo1.getSeries1().add(new Millisecond(), cliente1.controle1.getValorAgora1());
				if (cliente1.controle1.getMediaCurta() != 0) {
					ativo1.getSeries2().add(new Millisecond(), cliente1.controle1.getMediaCurta());
				}

				if (cliente1.controle1.getMediaLonga() != 0) {
					ativo1.getSeries3().add(new Millisecond(), cliente1.controle1.getMediaLonga());
				}

				String s1 = Double.toString(cliente1.controle1.getMediaCurta());
				Label label1 = new Label(0, i + 1, s1);
				aba.addCell(label1);

				String s2 = Double.toString(cliente1.controle1.getMediaLonga());
				Label label2 = new Label(1, i + 1, s2);
				aba.addCell(label2);

				String s3 = Double.toString(cliente1.controle2.getMediaCurta());
				Label label3 = new Label(2, i + 1, s3);
				aba.addCell(label3);

				String s4 = Double.toString(cliente1.controle2.getMediaLonga());
				Label label4 = new Label(3, i + 1, s4);
				aba.addCell(label4);

				String s5 = Double.toString(cliente1.controle3.getMediaCurta());
				Label label5 = new Label(4, i + 1, s5);
				aba.addCell(label5);

				String s6 = Double.toString(cliente1.controle3.getMediaLonga());
				Label label6 = new Label(5, i + 1, s6);
				aba.addCell(label6);

				String s7 = Double.toString(cliente1.controle4.getMediaCurta());
				Label label7 = new Label(6, i + 1, s7);
				aba.addCell(label7);

				String s8 = Double.toString(cliente1.controle4.getMediaLonga());
				Label label8 = new Label(7, i + 1, s8);
				aba.addCell(label8);
			
				Thread.sleep(10);
			
			}
			
			planilha.write();

			planilha.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
