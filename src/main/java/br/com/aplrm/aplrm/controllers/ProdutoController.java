package br.com.aplrm.aplrm.controllers;

import br.com.aplrm.aplrm.dto.ProdutoDTO;
import br.com.aplrm.aplrm.repositories.ProdutoRepository;
import br.com.aplrm.aplrm.services.ProdutoService;
import br.com.aplrm.aplrm.services.exceptions.DataBaseException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {


    @Autowired
    /*injetando servico*/
    private ProdutoService service;
    ProdutoRepository repository;

    @GetMapping(value = "/{id}")
    /*buscar a entidade por id*/
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
        ProdutoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    /*lista a consulta por pagina*/
    public ResponseEntity<Page<ProdutoDTO>> findAll(Pageable pageable) {
        Page<ProdutoDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> insert(@Valid @RequestBody ProdutoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id,@Valid @RequestBody ProdutoDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
      try{  ProdutoDTO  produto= service.findById(id);
            service.delete(id);
            return ResponseEntity.ok(produto);
      }catch (DataIntegrityViolationException e){
          throw new DataBaseException("Falha na Integridade Referincial, o produto está associado a um outro pedido");
      }


    }
}

/*na url para ordenar pelo preco
http://localhost:8080/produto?size=12&sort=preco*/