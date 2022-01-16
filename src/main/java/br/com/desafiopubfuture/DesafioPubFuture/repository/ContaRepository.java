package br.com.desafiopubfuture.DesafioPubFuture.repository;

import br.com.desafiopubfuture.DesafioPubFuture.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
    @Query("select sum(saldo) from Conta")
    public BigDecimal somaSaldo();
}
