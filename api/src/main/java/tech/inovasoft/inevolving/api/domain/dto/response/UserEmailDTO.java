package tech.inovasoft.inevolving.api.domain.dto.response;

import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.domain.model.UserRole;

import java.sql.Date;
import java.util.UUID;

public record UserEmailDTO(
        UUID id,
        String email,
        boolean emailVerified,
        boolean isActive
) {
    public UserEmailDTO(User user) {
        this(
                user.getId(),
                user.getEmail(),
                user.isEmailVerified(),
                user.isActive()
        );
    }
}
