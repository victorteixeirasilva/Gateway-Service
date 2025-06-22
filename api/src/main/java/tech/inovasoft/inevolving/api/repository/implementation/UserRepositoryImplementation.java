package tech.inovasoft.inevolving.api.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepository;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepositoryJPA;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImplementation implements UserRepository {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Override
    public User findById(UUID idUser) {
        Optional<User> optionalUser = userRepositoryJPA.findById(idUser);
        return optionalUser.orElse(null);
    }

    @Override
    public void saveInDatabase(User user) {
        try {
            userRepositoryJPA.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
