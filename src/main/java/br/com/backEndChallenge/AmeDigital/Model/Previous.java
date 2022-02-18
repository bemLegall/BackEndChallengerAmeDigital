package br.com.backEndChallenge.AmeDigital.Model;

import lombok.Data;

@Data
public class Previous {

	
	private String previous;
	
	public Previous() {
	}
	
	public Previous(String prev) {
		this.previous = prev;
	}
}
