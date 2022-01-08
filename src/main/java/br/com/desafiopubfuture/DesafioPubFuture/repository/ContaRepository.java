package br.com.desafiopubfuture.DesafioPubFuture.repository;

import br.com.desafiopubfuture.DesafioPubFuture.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}