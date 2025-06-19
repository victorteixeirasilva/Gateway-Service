package tech.inovasoft.inevolving.api.service;

import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.CreateObjectiveDTO;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.Objective;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.ResponseMessageDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ObjectivesService {
    public Objective add(UUID idUser, CreateObjectiveDTO dto) {
        //TODO: implement
        return null;
    }

    public Objective update(UUID idUser, CreateObjectiveDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseMessageDTO completeObjective(UUID idUser, UUID idObjective, LocalDate conclusionDate) {
        //TODO: implement
        return null;
    }

    public Objective getObjectiveById(UUID idUser, UUID idObjective) {
        //TODO: implement
        return null;
    }

    public List<Objective> getObjectivesByIdUser(UUID idUser) {
        //TODO: implement
        return null;
    }

    public List<Objective> getObjectivesByIdUserToDo(UUID idUser) {
        //TODO: implement
        return null;
    }


    public List<Objective> getObjectivesByIdUserDone(UUID idUser) {
        //TODO: implement
        return null;
    }
}
