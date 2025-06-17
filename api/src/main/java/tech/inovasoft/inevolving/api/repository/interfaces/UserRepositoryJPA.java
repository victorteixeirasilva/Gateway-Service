package tech.inovasoft.inevolving.api.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import tech.inovasoft.inevolving.api.domain.model.User;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);
}
