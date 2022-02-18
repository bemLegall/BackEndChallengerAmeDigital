package br.com.backEndChallenge.AmeDigital.Model;

import lombok.Data;

@Data
public class Next {

	private String next;
	
	public Next() {
	}
	
	public Next(String prev) {
		this.next = prev;
	}
}
