package br.com.desafiopubfuture.DesafioPubFuture.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.desafiopubfuture.DesafioPubFuture.model.ReceitaType;

@Data
public class ReceitaVM {

    private BigDecimal valor;
    private LocalDate dataRecebimento;
    private LocalDate dataRecebimentoEsperado;
    private ReceitaType tipoReceita;
    private String descricao;
    private Integer conta_id;

    public ReceitaVM(BigDecimal valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado, ReceitaType tipoReceita, String descricao, Integer conta_id) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.tipoReceita = tipoReceita;
        this.descricao = descricao;
        this.conta_id = conta_id;
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

    public Integer getConta_id() {
        return conta_id;
    }

    public void setConta_id(Integer conta_id) {
        this.conta_id = conta_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
