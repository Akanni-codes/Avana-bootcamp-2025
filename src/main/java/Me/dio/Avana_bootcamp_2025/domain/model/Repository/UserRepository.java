package Me.dio.Avana_bootcamp_2025.domain.model.Repository;

import Me.dio.Avana_bootcamp_2025.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}
