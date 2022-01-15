package br.com.desafiopubfuture.DesafioPubFuture.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.desafiopubfuture.DesafioPubFuture.model.DespesaType;

@Data
public class DespesaVM {

    private BigDecimal valor;
    private LocalDate dataPagamento;
    private LocalDate dataPagamentoEsperado;
    private DespesaType tipoDespesa;
    private Integer conta_id;

    public DespesaVM(BigDecimal valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, DespesaType tipoDespesa, Integer conta) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta_id = conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


    public DespesaType getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(DespesaType tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Integer getConta_id() {
        return conta_id;
    }

    public void setConta_id(Integer conta_id) {
        this.conta_id = conta_id;
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
}
