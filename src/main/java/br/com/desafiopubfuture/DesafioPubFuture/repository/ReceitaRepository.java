package br.com.desafiopubfuture.DesafioPubFuture.repository;

import br.com.desafiopubfuture.DesafioPubFuture.model.Despesa;
import br.com.desafiopubfuture.DesafioPubFuture.model.Receita;
import br.com.desafiopubfuture.DesafioPubFuture.model.ReceitaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
    @Query("select sum(valor) from Receita")
    public BigDecimal somaTotal();

    @Query("select r from Receita r where r.tipoReceita = :tipo")
    public List<Receita> listByType(@Param("tipo") ReceitaType tipo);

}