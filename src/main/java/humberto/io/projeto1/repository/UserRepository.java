package humberto.io.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import humberto.io.projeto1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
