package tech.inovasoft.inevolving.api.repository.interfaces;

import org.springframework.stereotype.Repository;
import tech.inovasoft.inevolving.api.domain.model.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository {
    User findById(UUID idUser);

    void saveInDatabase(User user);

    List<User> getUsersIsVerifiedAndActive();
}
