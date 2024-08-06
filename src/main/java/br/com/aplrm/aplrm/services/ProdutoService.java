package br.com.aplrm.aplrm.services;

import br.com.aplrm.aplrm.dto.ProdutoDTO;
import br.com.aplrm.aplrm.entities.Produto;
import br.com.aplrm.aplrm.repositories.ProdutoRepository;
import br.com.aplrm.aplrm.services.exceptions.ResourceNotFoundExceptions;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    /*injetando repositorio jpa*/
            ProdutoRepository repository;

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Integer id) {
//        Optional<Produto> resul = repository.findById(id);
//        if(resul.isPresent()){
//            Produto produto=resul.get();
//            return new ProdutoDTO(produto);
//        }throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        Produto produto = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundExceptions("Recurso nao encontrado"));
        return new ProdutoDTO(produto);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findAll(Pageable page) {
        Page<Produto> resul = repository.findAll(page);
        return resul.map(x -> new ProdutoDTO(x));


    }

    @Transactional
    public ProdutoDTO insert(ProdutoDTO dto) {
        Produto produto = new Produto(dto); // Converte DTO para entidade
        produto = repository.save(produto); // Salva a entidade no banco e obtém a instância persistida
        return new ProdutoDTO(produto); // Cria e retorna o DTO a partir da entidade salva
    }

    @Transactional
    public ProdutoDTO update(Integer id, ProdutoDTO produtoAtualizado) {
        try {
        /* Obtém uma referência ao objeto Produto existente no banco de dados pelo seu ID.
         'getReferenceById' retorna uma instância que está associada ao contexto de persistência
         , mas não carrega os dados até que seja realmente necessário.*/
            Produto produtoExistente = repository.getReferenceById(id);

            // Atualiza o nome do produto existente com o nome fornecido no DTO.
            produtoExistente.setNome(produtoAtualizado.getNome());

            // Atualiza o preço do produto existente com o preço fornecido no DTO.
            produtoExistente.setPreco(produtoAtualizado.getPreco());

            // Atualiza a descrição do produto existente com a descrição fornecida no DTO.
            produtoExistente.setDescricao(produtoAtualizado.getDescricao());

            // Atualiza a URL da imagem do produto existente com a URL fornecida no DTO.
            produtoExistente.setImgUrl(produtoAtualizado.getImgUrl());

            // Salva as alterações no banco de dados. O método 'save' faz a atualização persistindo as mudanças.
            // O objeto retornado é a instância atualizada do produto.
            produtoExistente = repository.save(produtoExistente);

        /*Retorna um novo DTO (Data Transfer Object) criado a partir do produto atualizado.
        Isso geralmente é feito para encapsular os dados e expor apenas as informações necessárias.*/
            return new ProdutoDTO(produtoExistente);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExceptions("Recurso não encontrado para atualização");

        }
    }

    @Transactional
    public void delete(Integer id) {
         try{
            repository.deleteById(id);
         }catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundExceptions("Recurso nao encontado com id*" + id);
         }
    }
}