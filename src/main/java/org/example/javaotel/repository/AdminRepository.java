package org.example.javaotel.repository;

import org.example.javaotel.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUserNameAndPassword(String userName, String password);
}
