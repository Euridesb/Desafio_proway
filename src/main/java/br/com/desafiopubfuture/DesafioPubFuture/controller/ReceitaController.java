package br.com.desafiopubfuture.DesafioPubFuture.controller;

import br.com.desafiopubfuture.DesafioPubFuture.model.Receita;
import br.com.desafiopubfuture.DesafioPubFuture.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    ReceitaService receitaService;

    @GetMapping("")
    public List<Receita> list() {
        return receitaService.listAllReceitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> get(@PathVariable Integer id) {
        try {
            Receita receita = receitaService.getReceita(id);
            return new ResponseEntity<Receita>(receita, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Receita>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Receita receita) {
        System.out.println(receita.getvalor());
        System.out.println(receita.getdataRecebimento());
        System.out.println(receita.getdataRecebimentoEsperado());
        System.out.println(receita.getdescrição());
        System.out.println(receita.getconta());
        System.out.println(receita.gettipoReceita());
        contaService.saveConta(conta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Receita receita, @PathVariable Integer id) {
        try {
            Receita existConta = receitaService.getReceita(id);
            receita.setId(id);
            receitaService.saveReceita(receita);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        contaService.deleteConta(id);
    }
}