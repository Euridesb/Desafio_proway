package br.com.desafiopubfuture.DesafioPubFuture.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.desafiopubfuture.DesafioPubFuture.model.Conta;
import lombok.Getter;
import lombok.Setter;
import br.com.desafiopubfuture.DesafioPubFuture.model.DespesaType;

@Getter
@Setter
@Entity
@Table(name = "despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private LocalDate dataPagamentoEsperado;
    @Enumerated(EnumType.STRING)
    private DespesaType tipoDespesa;
    @ManyToOne
    @JoinColumn(name="conta_id", nullable = false)
    private Conta conta;

    public Despesa() {
    }

    public Despesa(int id, BigDecimal valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, DespesaType tipoDespesa, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
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

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(LocalDate dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public DespesaType getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(DespesaType tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}