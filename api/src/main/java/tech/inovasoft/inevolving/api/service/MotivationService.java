package tech.inovasoft.inevolving.api.service;

import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.RequestDreams;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.*;

import java.util.List;
import java.util.UUID;

@Service
public class MotivationService {

    public Dreams addDream(UUID idUser, DreamRequestDTO dto) {
        //TODO: implement
        return null;
    }

    public Dreams updateDream(UUID idUser, RequestDreams dto) {
        //TODO: implement
        return null;
    }

    public List<Dreams> getDreamsByUserId(UUID idUser) {
        //TODO: implement
        return null;
    }

    public Dreams getDreamByID(UUID idUser, UUID idDream) {
        //TODO: implement
        return null;
    }

    public ResponseVisionBord generateVisionBordByUserId(UUID idUser) {
        //TODO: implement
        return null;
    }

    public ResponseDeleteDream deleteDream(UUID idUser, UUID idDream) {
        //TODO: implement
        return null;
    }
}
