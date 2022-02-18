package br.com.backEndChallenge.AmeDigital.Model.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.backEndChallenge.AmeDigital.Dto.PlanetaDto;
import br.com.backEndChallenge.AmeDigital.Formulario.PlanetaAtualizar;
import br.com.backEndChallenge.AmeDigital.Formulario.PlanetaFormulario;
import br.com.backEndChallenge.AmeDigital.Model.Completo;
import br.com.backEndChallenge.AmeDigital.Model.Planeta;
import br.com.backEndChallenge.AmeDigital.Model.Results;
import br.com.backEndChallenge.AmeDigital.Model.Repository.PlanetaRepository;

@RestController
@RequestMapping("amedigital")
public class PlanetaController {

	private PlanetaRepository planetaRepository;

	public PlanetaController(PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}

	@GetMapping
	public ResponseEntity<List<PlanetaDto>> listarPlanetas() {
		List<Planeta> planetas = planetaRepository.findAll();
		return ResponseEntity.ok(PlanetaDto.converterParaLista(planetas));

	}

	@GetMapping(path = "{id}")
	public ResponseEntity<PlanetaDto> buscarPlanetaPorId(@PathVariable Long id) {

		Optional<Planeta> planeta = planetaRepository.findById(id);

		if (!planeta.isPresent()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(PlanetaDto.converter(planeta.get()));
	}

	@GetMapping(path = "nome/{nome}")
	public ResponseEntity<PlanetaDto> buscarPlanetaPorNome(@PathVariable String nome) {

		Optional<Planeta> planeta = planetaRepository.findByNome(nome);
		if (!planeta.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(PlanetaDto.converter(planeta.get()));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PlanetaDto> novoPlaneta(@RequestBody PlanetaFormulario formulario,
			UriComponentsBuilder uriBuilder) {
		Planeta planeta = formulario.novoPlaneta();

		if (planetaRepository.existsByNome(planeta.getNome())) {
			return ResponseEntity.badRequest().build();
		}
		try {
			List<String> films = getPlanet(planeta.getNome());
			planeta.setNumeroDeVezesQueApareceu(films.size());
		} catch (Exception e) {
			planetaRepository.save(planeta);
			URI uri = uriBuilder.path("/amedigital/{id}").buildAndExpand(planeta.getId()).toUri();
			return ResponseEntity.created(uri).body(new PlanetaDto(planeta));
		}

		planetaRepository.save(planeta);
		URI uri = uriBuilder.path("/amedigital/{id}").buildAndExpand(planeta.getId()).toUri();
		return ResponseEntity.created(uri).body(new PlanetaDto(planeta));
	}

	@PutMapping(path = "/{id}")
	@Transactional
	public ResponseEntity<PlanetaDto> atualizarPlaneta(@RequestBody PlanetaAtualizar atualizar, @PathVariable Long id) {
		Optional<Planeta> planeta = planetaRepository.findById(id);
		if (!planeta.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		atualizar.atualizarPlaneta(id, planetaRepository);
		return ResponseEntity.ok(new PlanetaDto(planeta.get()));
	}

	@DeleteMapping(path = "{id}")
	@Transactional
	public ResponseEntity<List<PlanetaDto>> deletarPlaneta(@PathVariable Long id) {

		Optional<Planeta> planeta = planetaRepository.findById(id);
		if (!planeta.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		planetaRepository.deleteById(id);
		List<Planeta> planetas = planetaRepository.findAll();
		return ResponseEntity.ok(PlanetaDto.converterParaLista(planetas));
	}

	@Value("${urlApi}")
	private String urlApi;
	@Value("${json}")
	private String json;
	@GetMapping("aparicoes/{planeta}")
	public List<String> getPlanet(@PathVariable String planeta) {
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder stringBuilder = new StringBuilder();
		String urlFinal = stringBuilder.append(urlApi).append(planeta).append(json).toString();
		ResponseEntity<Completo> entity = restTemplate.getForEntity(urlFinal, Completo.class);
		return entity.getBody().getResults().get(0).getFilms();
	}
	
	@Value("${page}")
	private String pagina;
	@GetMapping("/todosPlanetas/{page}")
	public List<Results> getPlanetsApiSW(@PathVariable String page) {
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder stringBuilder = new StringBuilder();
		String urlBase = "https://swapi.dev/api/planets";
		String urlFinal = stringBuilder.append(urlBase).append(pagina).append(page).append(json).toString();
		ResponseEntity<Completo> entity = restTemplate.getForEntity(urlFinal, Completo.class);
		System.out.println(entity.getBody().getCount());
		System.out.println(urlFinal);
		return entity.getBody().getResults();
	}	
	
}
