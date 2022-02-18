package br.com.backEndChallenge.AmeDigital.Dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.backEndChallenge.AmeDigital.Model.Planeta;

public class PlanetaDto {

	@NotBlank
	private String nome;

	@NotBlank
	private String clima;

	@NotBlank
	private String terreno;
	
	private int Numero;

	public PlanetaDto(Planeta planeta) {
		this.nome = planeta.getNome();
		this.clima = planeta.getClima();
		this.terreno = planeta.getTerreno();
		this.Numero = planeta.getNumeroDeVezesQueApareceu();
		
	}

	public String getNome() {
		return nome;
	}

	public String getClima() {
		return clima;
	}

	public String getTerreno() {
		return terreno;
	}
	public int getNumero() {
		return Numero;
	}
	public static List<PlanetaDto> converterParaLista(List<Planeta> planetas){		
		return planetas.stream().map(PlanetaDto :: new).collect(Collectors.toList());
	}
	
	public static PlanetaDto converter(Planeta planeta) {		
		return new PlanetaDto(planeta);
	}
	
	
}
