package br.com.desafiopubfuture.DesafioPubFuture.repository;

import br.com.desafiopubfuture.DesafioPubFuture.model.Despesa;
import br.com.desafiopubfuture.DesafioPubFuture.model.DespesaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {
    @Query("select sum(valor) from Despesa")
    public BigDecimal somaTotal();

    @Query("select d from Despesa d where d.tipoDespesa = :tipo")
    public List<Despesa> listByType(@Param("tipo") DespesaType tipo);
}