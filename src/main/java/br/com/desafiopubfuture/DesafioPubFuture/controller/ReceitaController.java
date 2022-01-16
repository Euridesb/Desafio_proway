package br.com.desafiopubfuture.DesafioPubFuture.controller;
import br.com.desafiopubfuture.DesafioPubFuture.model.*;
import br.com.desafiopubfuture.DesafioPubFuture.service.ReceitaService;
import br.com.desafiopubfuture.DesafioPubFuture.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.Id;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    ReceitaService receitaService;

    @Autowired
    ContaService contaService;

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
    public ResponseEntity<?> add(@RequestBody ReceitaVM receita) {
        try {
            Conta conta = contaService.getConta(receita.getConta_id());
            Receita receitaEntity = new Receita();
            receitaEntity.setValor(receita.getValor());
            receitaEntity.setTipoReceita(receita.getTipoReceita());
            receitaEntity.setDataRecebimento(receita.getDataRecebimento());
            receitaEntity.setDescricao(receita.getDescricao());
            receitaEntity.setDataRecebimentoEsperado(receita.getDataRecebimentoEsperado());
            receitaEntity.setConta(conta);
            receitaService.saveReceita(receitaEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ReceitaVM receita, @PathVariable Integer id) {
        try {
            Receita existReceita = receitaService.getReceita(id);
            Conta existConta = contaService.getConta(receita.getConta_id());
            existReceita.setId(id);
            existReceita.setValor(receita.getValor());
            existReceita.setTipoReceita(receita.getTipoReceita());
            existReceita.setDataRecebimento(receita.getDataRecebimento());
            existReceita.setDescricao(receita.getDescricao());
            existReceita.setDataRecebimentoEsperado(receita.getDataRecebimentoEsperado());
            existReceita.setConta(existConta);
            receitaService.saveReceita(existReceita);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        receitaService.deleteReceita(id);
    }

    @GetMapping("/total")
    @ResponseBody
    public SomaResponse total(){
        return new SomaResponse(receitaService.somaTotal());
    }

    @GetMapping("/tipo/{tipo}")
    @ResponseBody
    public List<Receita> listByType(@PathVariable String tipo){
        return receitaService.listByType(tipo);
    }
}