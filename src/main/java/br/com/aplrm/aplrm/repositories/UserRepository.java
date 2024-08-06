package br.com.aplrm.aplrm.repositories;

import br.com.aplrm.aplrm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
