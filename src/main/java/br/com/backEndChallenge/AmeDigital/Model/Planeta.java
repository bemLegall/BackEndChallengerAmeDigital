package br.com.backEndChallenge.AmeDigital.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String clima;
	private String terreno;
	
	private int NumeroDeVezesQueApareceu = 0;

	public Planeta() {
	}
	
	public Planeta(String nome, String clima, String terreno) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public int getNumeroDeVezesQueApareceu() {
		return NumeroDeVezesQueApareceu;
	}

	public void setNumeroDeVezesQueApareceu(int numeroDeVezesQueApareceu) {
		NumeroDeVezesQueApareceu = numeroDeVezesQueApareceu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Long getId() {
		return id;
	}

}
