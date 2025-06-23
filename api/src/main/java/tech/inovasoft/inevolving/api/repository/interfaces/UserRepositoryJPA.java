package tech.inovasoft.inevolving.api.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import tech.inovasoft.inevolving.api.domain.model.User;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<User, UUID> {
    Optional<UserDetails> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.isActive = true AND u.emailVerified = true")
    List<User> findAllVerifiedAndActive();

    @Query("SELECT u FROM User u WHERE u.isActive = true AND u.emailVerified = true AND u.lastLogin = :date")
    List<User> findAllDisconnectedAndActive(@Param("date") Date date);
}
