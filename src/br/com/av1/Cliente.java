package br.com.av1;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import org.jfree.data.time.Millisecond;
import org.jfree.ui.RefineryUtilities;

public class Cliente implements Runnable {
	private boolean comprado1;
	private boolean comprado12;
	private boolean comprado2;
	private boolean comprado22;
	private boolean comprado3;
	private boolean comprado32;
	private boolean comprado4;
	private boolean comprado42;
	private ArrayList<Double> fechamentoAtivo1;
	private ArrayList<Double> fechamentoAtivo2;
	private ArrayList<Double> fechamentoAtivo3;
	private ArrayList<Double> fechamentoAtivo4;
	Controle controle1;
	Controle controle2;
	Controle controle3;
	Controle controle4;
	private double saldo;
	double valorAgora;
	private String nome;
	double aux1;
	private Semaphore caixa;
	int contadorCompra = 0;
	int contadorVenda = 0;
	boolean paraCompra = false;
	private Validacao validacao = new Validacao();

	public Cliente(int saldo, ArrayList<Double> fechamentoAtivo1, ArrayList<Double> fechamentoAtivo2,
			ArrayList<Double> fechamentoAtivo3, ArrayList<Double> fechamentoAtivo4, String nome, Semaphore caixa) {

		this.saldo = saldo;
		this.fechamentoAtivo1 = fechamentoAtivo1;
		this.fechamentoAtivo1 = fechamentoAtivo2;
		this.fechamentoAtivo1 = fechamentoAtivo3;
		this.fechamentoAtivo1 = fechamentoAtivo4;
		this.nome = nome;
		this.caixa = caixa;

		controle1 = new Controle(fechamentoAtivo1);
		controle2 = new Controle(fechamentoAtivo2);
		controle3 = new Controle(fechamentoAtivo3);
		controle4 = new Controle(fechamentoAtivo4);

		Thread cliente = new Thread(this);
		cliente.start();

	}

	@Override
	public void run() {

		try {

			for (int i = 0; i < fechamentoAtivo1.size(); i++) {
				//System.out.println(System.currentTimeMillis());
				Millisecond horario = new Millisecond();
				if (controle1.compra1 == true && comprado1 == false && comprado12 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle1.getValorAgora1();

						comprado1 = true;

						System.out.println(nome + " comprou ativo 1 por " + controle1.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(1);
						Thread.sleep(500);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle1.compra2 == true && comprado12 == false && comprado1 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle1.getValorAgora1();

						comprado12 = true;

						System.out.println(nome + " comprou vendido ativo 1 por " + controle1.getValorAgora1()
								+ "- Possui " + saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(9);
						Thread.sleep(500);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle1.vendaEntrarComprado == true && comprado1 == true) {
					try {
						caixa.acquire();
						comprado1 = false;

						saldo = saldo + controle1.getValorAgora1();
						System.out.println(nome + " vendeu ativo 1 por " + controle1.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorVenda++;
						validacao.valida(5);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}
				if (controle1.vendaEntrarVendido == true && comprado12 == true) {
					try {
						caixa.acquire();

						comprado12 = false;
						saldo = saldo + controle1.aux2 + (controle1.aux2 - controle1.getValorAgora1());
						System.out.println(nome + " vendeu ativo 1 por " + controle1.getValorAgora1() + "- Possui "
								+ " -- " + horario);
						contadorVenda++;
						validacao.valida(13);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle2.compra1 == true && comprado2 == false && comprado22 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle2.getValorAgora1();
						comprado2 = true;
						System.out.println(nome + " comprou ativo 2 por " + controle2.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(2);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle2.compra2 == true && comprado22 == false && comprado2 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle2.getValorAgora1();

						comprado22 = true;

						System.out.println(nome + " comprou vendido ativo 2 por " + controle2.getValorAgora1()
								+ "- Possui " + saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(10);
						Thread.sleep(500);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle2.vendaEntrarComprado == true && comprado2 == true) {
					try {
						caixa.acquire();
						comprado2 = false;
						saldo = saldo + controle2.getValorAgora1();
						System.out.println(nome + " vendeu ativo 2 por " + controle2.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorVenda++;
						validacao.valida(6);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle2.vendaEntrarVendido == true && comprado22 == true) {
					try {
						caixa.acquire();

						comprado22 = false;
						saldo = saldo + controle2.aux2 + (controle2.aux2 - controle2.getValorAgora1());
						System.out.println(nome + " vendeu ativo 2 por " + controle2.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorVenda++;
						validacao.valida(14);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle3.compra1 == true && comprado3 == false && comprado32 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle3.getValorAgora1();
						comprado3 = true;
						System.out.println(nome + " comprou ativo 3 por " + controle3.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(3);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle3.compra2 == true && comprado32 == false && comprado3 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle3.getValorAgora1();

						comprado32 = true;

						System.out.println(nome + " comprou vendido ativo 3 por " + controle3.getValorAgora1()
								+ "- Possui " + saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(11);
						Thread.sleep(500);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle3.vendaEntrarComprado == true && comprado3 == true) {
					try {
						caixa.acquire();
						comprado3 = false;
						saldo = saldo + controle3.getValorAgora1();
						System.out.println(nome + " vendeu ativo 3 por " + controle3.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorVenda++;
						validacao.valida(7);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle3.vendaEntrarVendido == true && comprado32 == true) {
					try {
						caixa.acquire();

						comprado32 = false;
						saldo = saldo + controle3.aux2 + (controle3.aux2 - controle3.getValorAgora1());
						System.out.println(nome + " vendeu ativo 3 por " + controle3.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorVenda++;
						validacao.valida(15);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle4.compra1 == true && comprado4 == false && comprado42 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle4.getValorAgora1();
						comprado4 = true;
						System.out.println(nome + " comprou ativo 4 por " + controle4.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(4);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle4.compra2 == true && comprado42 == false && comprado4 == false && paraCompra == false) {
					try {
						caixa.acquire();
						saldo = saldo - controle4.getValorAgora1();

						comprado42 = true;

						System.out.println(nome + " comprou vendido ativo 4 por " + controle4.getValorAgora1()
								+ "- Possui " + saldo + " -- " + horario);
						contadorCompra++;
						validacao.valida(12);
						Thread.sleep(500);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle4.vendaEntrarComprado == true && comprado4 == true) {
					try {
						caixa.acquire();
						comprado4 = false;
						saldo = saldo + controle4.getValorAgora1();
						System.out.println(nome + " vendeu ativo 4 por " + controle4.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorVenda++;
						validacao.valida(8);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}

				if (controle4.vendaEntrarVendido == true && comprado42 == true) {
					try {
						caixa.acquire();

						comprado42 = false;
						saldo = saldo + controle4.aux2 + (controle4.aux2 - controle4.getValorAgora1());
						System.out.println(nome + " vendeu ativo 4 por " + controle4.getValorAgora1() + "- Possui "
								+ saldo + " -- " + horario);
						contadorVenda++;
						validacao.valida(16);
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					caixa.release();
				}
				if (contadorCompra >= 15) {
					paraCompra = true;
					if (contadorCompra == contadorVenda) {
						System.out.println(nome + " finalizou");
						validacao.imprimirSaida(nome);
						break;
					}
				}

				Thread.sleep(10);

			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
