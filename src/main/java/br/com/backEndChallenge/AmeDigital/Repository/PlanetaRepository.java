package br.com.backEndChallenge.AmeDigital.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.backEndChallenge.AmeDigital.Model.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long>{

	boolean existsByNome(String nome);

	Optional<Planeta> findByNome(String nome);


}
