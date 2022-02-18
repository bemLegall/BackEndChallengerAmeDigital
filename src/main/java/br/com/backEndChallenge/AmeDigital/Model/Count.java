package br.com.backEndChallenge.AmeDigital.Model;

import lombok.Data;

@Data
public class Count {

	private int count;
	
	public Count() {
	}
	
	public Count(int prev) {
		this.count = prev;
	}
}
