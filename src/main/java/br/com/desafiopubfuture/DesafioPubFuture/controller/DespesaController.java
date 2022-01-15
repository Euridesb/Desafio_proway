package br.com.desafiopubfuture.DesafioPubFuture.controller;

import br.com.desafiopubfuture.DesafioPubFuture.model.Conta;
import br.com.desafiopubfuture.DesafioPubFuture.model.Despesa;
import br.com.desafiopubfuture.DesafioPubFuture.model.DespesaVM;
import br.com.desafiopubfuture.DesafioPubFuture.service.DespesaService;
import br.com.desafiopubfuture.DesafioPubFuture.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
    @Autowired
    DespesaService despesaService;

    @Autowired
    ContaService contaService;

    @GetMapping("")
    public List<Despesa> list() { return despesaService.listAllDespesa(); }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> get(@PathVariable Integer id) {
        try {
            Despesa despesa = despesaService.getDespesa(id);
            return new ResponseEntity<Despesa>(despesa, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Despesa>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody DespesaVM despesa) {
        try {
        Conta conta = contaService.getConta(despesa.getConta_id());
        Despesa despesaEntity = new Despesa();
        despesaEntity.setValor(despesa.getValor());
        despesaEntity.setTipoDespesa(despesa.getTipoDespesa());
        despesaEntity.setDataPagamento(despesa.getDataPagamento());
        despesaEntity.setDataPagamentoEsperado(despesa.getDataPagamentoEsperado());
        despesaEntity.setConta(conta);
        despesaService.saveDespesa(despesaEntity);
        return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DespesaVM despesa, @PathVariable Integer id) {
        try {
            Despesa existDespesa = despesaService.getDespesa(id);
            Conta existConta = contaService.getConta(despesa.getConta_id());
            existDespesa.setId(id);
            existDespesa.setValor(despesa.getValor());
            existDespesa.setTipoDespesa(despesa.getTipoDespesa());
            existDespesa.setDataPagamento(despesa.getDataPagamento());
            existDespesa.setDataPagamentoEsperado(despesa.getDataPagamentoEsperado());
            existDespesa.setConta(existConta);
            despesaService.saveDespesa(existDespesa);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        despesaService.deleteDespesa(id);
    }
}