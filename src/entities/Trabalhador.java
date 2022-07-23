package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	
	public Trabalhador() {
	}
	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.departamento = departamento;
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public NivelTrabalhador getNivel() {
		return nivel;
	}
	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<ContratoPorHora> getContrato() {
		return contratos;
	}
	public void adicionarContrato(ContratoPorHora contrato) {
		contratos.add(contrato);
	}
	public void removerContrato(ContratoPorHora contrato) {
		contratos.remove(contrato);
	}
	public double adicional(int ano, int mes) {
		Double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoPorHora mes_trabalhado : contratos) {
			cal.setTime(mes_trabalhado.getData());
			int ano_trabalhado = cal.get(Calendar.YEAR);
			int mees_trabalhado = 1+cal.get(Calendar.MONTH);
			if (ano == ano_trabalhado && mes == mees_trabalhado) {
				soma += mes_trabalhado.valorTotal();
			}
		}
		return soma;
	}
}
