package ds2020.assignment3.repositories;

import ds2020.assignment3.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findAccountByUserNameAndPassword(String username, String password);
}
