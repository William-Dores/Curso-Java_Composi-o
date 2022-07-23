package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoPorHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {
	/* PROJETO ELABORADO COM O CURSO DO PROFESSOR NELIO ALVES PELA PLATAFORMA UDEMY! POSTANDO PARA FINS DE MOSTRA MINHA EVOLUÇÃO COM O PASSAR DAS AULAS E ATIVIDADES RESOLVIDAS POR MIM.	 */

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Entre com o nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Entre com os dados do Trabalhador!");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salario Base: ");
		double salarioTrabalhador = sc.nextDouble();
		
		Trabalhador trab = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioTrabalhador, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos tem o trabalhador? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do "+i+"# contrato");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			Double valorHora = sc.nextDouble();
			System.out.print("Tempo de duração do contrato: ");
			int tempoContrato = sc.nextInt();
			
			ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorHora, tempoContrato);
			trab.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Entre com o mes e ano para calcular o salario junto com o adicional (MM/YYYY): ");
		String mes_ano = sc.next();
		int mes = Integer.parseInt(mes_ano.substring(0, 2));
		int ano = Integer.parseInt(mes_ano.substring(3));
		
		System.out.println("Nome: "+trab.getNome());
		System.out.println("Departamento: "+trab.getDepartamento().getNome());
		System.out.println("Salario no"+mes_ano+": "+String.format("%.2f", trab.adicional(ano, mes)));		
	 
		
		
		
		
		sc.close();
	}

}
