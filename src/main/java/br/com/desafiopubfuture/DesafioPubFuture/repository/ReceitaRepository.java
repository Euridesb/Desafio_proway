package br.com.desafiopubfuture.DesafioPubFuture.repository;

import br.com.desafiopubfuture.DesafioPubFuture.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}