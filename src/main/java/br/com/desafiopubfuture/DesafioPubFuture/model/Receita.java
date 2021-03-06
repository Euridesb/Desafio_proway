package br.com.desafiopubfuture.DesafioPubFuture.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


import br.com.desafiopubfuture.DesafioPubFuture.model.Conta;
import lombok.Getter;
import lombok.Setter;
import br.com.desafiopubfuture.DesafioPubFuture.model.ReceitaType;

@Getter
@Setter
@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal valor;
    private LocalDate dataRecebimento;
    private LocalDate dataRecebimentoEsperado;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private ReceitaType tipoReceita;
    @ManyToOne
    @JoinColumn(name="conta_id", nullable = false)
    private Conta conta;

    public Receita() {
    }

    public Receita(int id, BigDecimal valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado, String descricao, ReceitaType tipoReceita, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDate getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(LocalDate dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public ReceitaType getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(ReceitaType tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}