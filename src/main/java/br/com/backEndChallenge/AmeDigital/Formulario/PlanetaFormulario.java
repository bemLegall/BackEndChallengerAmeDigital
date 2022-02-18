package br.com.backEndChallenge.AmeDigital.Formulario;

import br.com.backEndChallenge.AmeDigital.Model.Planeta;

public class PlanetaFormulario {

	private String nome;
	private String clima;
	private String terreno;

	
	public PlanetaFormulario() {
	}
	
	public PlanetaFormulario(Planeta planeta) {
		planeta.setNome(nome);
		planeta.setClima(clima);
		planeta.setTerreno(terreno);
	}
	
	
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Planeta novoPlaneta() {		
		return new Planeta(nome, clima, terreno);
	}
}
