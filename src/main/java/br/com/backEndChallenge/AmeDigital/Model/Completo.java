package br.com.backEndChallenge.AmeDigital.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Completo {
	
	
	
	private Count count;
	private Next next;
	private Previous previous;
	private List<Results> results = new ArrayList<Results>();
	//private List<Films> films = new ArrayList<Films>();
	
	

}
