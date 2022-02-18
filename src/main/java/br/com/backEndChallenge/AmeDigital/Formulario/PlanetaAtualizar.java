package br.com.backEndChallenge.AmeDigital.Formulario;

import br.com.backEndChallenge.AmeDigital.Model.Planeta;
import br.com.backEndChallenge.AmeDigital.Repository.PlanetaRepository;

public class PlanetaAtualizar {

	private String nome;

	private String clima;

	private String terreno;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Planeta atualizarPlaneta(Long id, PlanetaRepository planetaRepository) {
		Planeta planeta = planetaRepository.getById(id);
		planeta.setClima(clima);
		planeta.setNome(nome);
		planeta.setTerreno(terreno);
		return planeta;

	}

}
