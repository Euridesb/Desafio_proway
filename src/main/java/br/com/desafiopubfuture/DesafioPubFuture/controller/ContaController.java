package br.com.desafiopubfuture.DesafioPubFuture.controller;

import br.com.desafiopubfuture.DesafioPubFuture.model.Conta;
import br.com.desafiopubfuture.DesafioPubFuture.model.SomaResponse;
import br.com.desafiopubfuture.DesafioPubFuture.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    ContaService contaService;

    @GetMapping("")
    public List<Conta> list() {
        return contaService.listAllContas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> get(@PathVariable Integer id) {
        try {
            Conta conta = contaService.getConta(id);
            return new ResponseEntity<Conta>(conta, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Conta conta) {
        System.out.println(conta.getInstituicaoFinanceira());
        System.out.println(conta.getSaldo());
        contaService.saveConta(conta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Conta conta, @PathVariable Integer id) {
        try {
            Conta existConta = contaService.getConta(id);
            conta.setId(id);
            contaService.saveConta(conta);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        contaService.deleteConta(id);
    }

    @GetMapping("/soma")
    @ResponseBody
    public SomaResponse soma(){
        return new SomaResponse(contaService.calculaSomaTotal());
    }
}