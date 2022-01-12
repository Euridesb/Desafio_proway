package br.com.desafiopubfuture.DesafioPubFuture.controller;

import br.com.desafiopubfuture.DesafioPubFuture.model.Despesa;
import br.com.desafiopubfuture.DesafioPubFuture.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
    @Autowired
    DespesaService despesaService;

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
    public void add(@RequestBody Despesa despesa) {
        System.out.println(despesa.getValor());
        System.out.println(despesa.getDataPagamento());
        System.out.println(despesa.getDataPagamentoEsperado());
        System.out.println(despesa.getTipoDespesa());
        System.out.println(despesa.getConta());
        despesaService.saveDespesa(despesa);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Despesa despesa, @PathVariable Integer id) {
        try {
            Despesa existDespesa = despesaService.getDespesa(id);
            despesa.setId(id);
            despesaService.saveDespesa(despesa);
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