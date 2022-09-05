package br.com.av1;

import java.io.File;
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

public class Controle implements Runnable {
	private String estadoAnt1 = "";
	private String estadoAnt2 = "";
	private ArrayList<Double> fechamento = new ArrayList<>();;

	boolean comprado1 = false;
	boolean comprado2 = false;
	boolean compra1 = false;
	boolean compra2 = false;
	boolean vendaEntrarComprado = false;
	boolean vendaEntrarVendido = false;
	private int j = 0;
	private int t = 0;
	private int k = 20;
	private int p = 500;
	private int contador = 0;

	private double retornoMediaCurta = 0;

	private double retornoMediaLonga = 0;
	String estado = "";
	private double valorAgora1 = 0;

	double aux1;
	double aux2;

	public Controle(ArrayList fechamento) {
		this.fechamento = fechamento;

		Thread controle = new Thread(this);
		controle.start();
	}

	@Override
	public void run() {
		try {

			for (int i = 0; i < fechamento.size(); i++) {
				valorAgora1 = fechamento.get(i);

				contador++;
				if (contador >= 20) {
					retornoMediaCurta = calculaMediaCurta(fechamento);

				}
				if (contador >= 500) {
					retornoMediaLonga = calculaMediaLonga(fechamento);

					retorno();

				}

				Thread.sleep(15);
			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public double calculaMediaCurta(ArrayList<Double> fechamento) {

		double soma = 0;
		double m = 0;

		for (int i = j; i < k; i++) {
			soma += fechamento.get(i);
			m = soma / 20;
		}

		j++;
		k++;

		return m;
	}

	public double calculaMediaLonga(ArrayList<Double> fechamento) {

		double soma = 0;
		double m = 0;

		for (int i = t; i < p; i++) {
			soma += fechamento.get(i);
			m = soma / 500;
		}

		t++;
		p++;

		return m;
	}

	public boolean analiseComprado() {

		if (retornoMediaCurta >= retornoMediaLonga) {
			estado = "abaixo";
			if (estadoAnt1 == "acima") {

				estadoAnt1 = estado;
				return true;

			}
			estadoAnt1 = estado;
			return false;
		}

		else {
			estado = "acima";
			estadoAnt1 = estado;
			return false;
		}
	}

	public boolean analiseVendido() {
		if (retornoMediaCurta < retornoMediaLonga) {
			estado = "acima";
			if (estadoAnt2 == "abaixo") {
				estadoAnt2 = estado;
				return true;
			}
			estadoAnt2 = estado;
			return false;
		} else {
			estado = "abaixo";
			estadoAnt2 = estado;
			return false;
		}
	}

	public boolean retorno() {
		if (analiseComprado() == true) {
			comprado1 = true;
			aux1 = getValorAgora1();
			compra1 = true;
			vendaEntrarComprado = false;
			vendaEntrarVendido = false;
			return true;

		}
		if (analiseVendido() == true) {
			comprado2 = true;
			aux2 = getValorAgora1();
			compra2 = true;
			vendaEntrarComprado = false;
			vendaEntrarVendido = false;
			return true;
		}
		if (valorAgora1 >= 1.005 * aux1 || valorAgora1 <= 0.993 * aux1) {

			comprado1 = false;
			vendaEntrarComprado = true;
			vendaEntrarVendido = false;
			compra1 = false;

			return true;
		}
		if (valorAgora1 >= 1.007 * aux2 || valorAgora1 <= 0.995 * aux2) {

			comprado2 = false;
			vendaEntrarComprado = false;
			vendaEntrarVendido = true;
			compra2 = false;

			return true;
		}

		compra1 = false;
		compra2 = false;
		vendaEntrarComprado = false;
		vendaEntrarVendido = false;
		return false;
	}

	public double getValorAgora1() {
		return valorAgora1;
	}

	public double getMediaCurta() {
		return retornoMediaCurta;
	}

	public double getMediaLonga() {
		return retornoMediaLonga;
	}
}
