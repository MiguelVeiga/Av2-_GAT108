package br.com.av1;

public class Validacao {
	private int id;
	private int nroComprasAtivo1 = 0;
	private int nroComprasAtivo2 = 0;
	private int nroComprasAtivo3 = 0;
	private int nroComprasAtivo4 = 0;
	private int nroVendasAtivo1 = 0;
	private int nroVendasAtivo2 = 0;
	private int nroVendasAtivo3 = 0;
	private int nroVendasAtivo4 = 0;
	private int nroEntrarVendidoAtivo1 = 0;
	private int nroEntrarVendidoAtivo2 = 0;
	private int nroEntrarVendidoAtivo3 = 0;
	private int nroEntrarVendidoAtivo4 = 0;
	private int nroSairVendidoAtivo1 = 0;
	private int nroSairVendidoAtivo2 = 0;
	private int nroSairVendidoAtivo3 = 0;
	private int nroSairVendidoAtivo4 = 0;

	public Validacao() {

	}

	public void valida(int id) {
		this.id = id;
		switch (id) {
		case 1:
			nroComprasAtivo1++;
			break;
		case 2:
			nroComprasAtivo2++;
			break;
		case 3:
			nroComprasAtivo3++;
			break;
		case 4:
			nroComprasAtivo4++;
			break;
		case 5:
			nroVendasAtivo1++;
			break;
		case 6:
			nroVendasAtivo2++;
			break;
		case 7:
			nroVendasAtivo3++;
			break;
		case 8:
			nroVendasAtivo4++;
			break;
		case 9:
			nroEntrarVendidoAtivo1++;
			break;
		case 10:
			nroEntrarVendidoAtivo2++;
			break;
		case 11:
			nroEntrarVendidoAtivo3++;
			break;
		case 12:
			nroEntrarVendidoAtivo4++;
			break;
		case 13:
			nroSairVendidoAtivo1++;
			break;
		case 14:
			nroSairVendidoAtivo2++;
			break;
		case 15:
			nroSairVendidoAtivo3++;
			break;
		case 16:
			nroSairVendidoAtivo4++;
			break;
		}
	}

	public void imprimirSaida(String nome) {
		System.out.println("cliente "+nome+" comprou "+nroComprasAtivo1+" e vendeu "+nroVendasAtivo1+" ativo 1");
		System.out.println("cliente "+nome+" comprou "+nroComprasAtivo2+" e vendeu "+nroVendasAtivo2+" ativo 2");
		System.out.println("cliente "+nome+" comprou "+nroComprasAtivo3+" e vendeu "+nroVendasAtivo3+" ativo 3");
		System.out.println("cliente "+nome+" comprou "+nroComprasAtivo4+" e vendeu "+nroVendasAtivo4+" ativo 4");
		System.out.println("cliente "+nome+" entrou vendido "+nroEntrarVendidoAtivo1+" e saiu vendido "+nroSairVendidoAtivo1+" ativo 1");
		System.out.println("cliente "+nome+" entrou vendido "+nroEntrarVendidoAtivo2+" e saiu vendido "+nroSairVendidoAtivo2+" ativo 2");
		System.out.println("cliente "+nome+" entrou vendido "+nroEntrarVendidoAtivo3+" e saiu vendido "+nroSairVendidoAtivo3+" ativo 3");
		System.out.println("cliente "+nome+" entrou vendido "+nroEntrarVendidoAtivo4+" e saiu vendido "+nroSairVendidoAtivo4+" ativo 4");
	}
}
