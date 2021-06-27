package orange.talents.control.vehicles.users.repository;

import orange.talents.control.vehicles.users.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {

    boolean existsUserByEmail(String email);

    boolean existsUserByCpf(String cpf);

}
