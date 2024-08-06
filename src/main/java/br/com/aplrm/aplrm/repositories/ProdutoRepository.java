package br.com.aplrm.aplrm.repositories;

import br.com.aplrm.aplrm.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}
