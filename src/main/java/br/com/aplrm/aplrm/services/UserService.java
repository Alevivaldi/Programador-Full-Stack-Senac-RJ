package br.com.aplrm.aplrm.services;

import br.com.aplrm.aplrm.dto.ProdutoDTO;
import br.com.aplrm.aplrm.dto.UserDTO;
import br.com.aplrm.aplrm.entities.Produto;
import br.com.aplrm.aplrm.entities.User;
import br.com.aplrm.aplrm.repositories.ProdutoRepository;
import br.com.aplrm.aplrm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    /*injetando repositorio jpa*/
           UserRepository repository;






    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable page) {
        Page<User> resul = repository.findAll(page);
        return resul.map(x -> new UserDTO(x));


    }
}
