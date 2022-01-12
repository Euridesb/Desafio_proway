package br.com.desafiopubfuture.DesafioPubFuture.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Despesa")
public class Despesa {
    private int id;
    private BigDecimal valor;
    private String dataPagamento;
    private String dataPagamentoEsperado;
    private BigDecimal tipoDespesa;
    private BigDecimal conta;
    public Despesa() {
    }

    public Despesa(int id, BigDecimal valor, String dataPagamento, String dataPagamentoEsperado,
                   BigDecimal tipoDespesa, BigDecimal conta) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(String dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public BigDecimal getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(BigDecimal tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public BigDecimal getConta() {
        return conta;
    }

    public void setConta(BigDecimal conta) {
        this.conta = conta;
    }
}