package br.com.backEndChallenge.AmeDigital.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class Results {

	private String name;
	private String diameter;
	private String rotation_period;
	private String orbital_period;
	private String gravity;
	private String population;
	private String climate;
	private String terrain;
	private String surface_water;
	private List<String> residents = new ArrayList<String>();
	private List<String>films = new ArrayList<String>();
	private String url;
	private String created;
	private String edited;
	private List<Results>planets = new ArrayList<Results>();
	public Results() {
		// TODO Auto-generated constructor stub
	}
	
	public Results(String name, String diameter, String rotation_period, String orbital_period, String gravity,
			String population, String climate, String terrain, String surface_water, List<String> residents, List<String> films,
			String url, String created, String edited, List<Results>planets) {
		this.name = name;
		this.diameter = diameter;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.gravity = gravity;
		this.population = population;
		this.climate = climate;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.residents = residents;
		this.films = films;
		this.url = url;
		this.created = created;
		this.edited = edited;
		this.planets = planets;
	}

	
	
	
}
