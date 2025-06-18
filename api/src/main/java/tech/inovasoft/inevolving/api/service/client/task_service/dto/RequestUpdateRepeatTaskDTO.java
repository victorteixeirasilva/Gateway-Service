package tech.inovasoft.inevolving.api.service.client.task_service.dto;

import java.util.UUID;

public record RequestUpdateRepeatTaskDTO(
        String nameTask,
        String descriptionTask,
        UUID idObjective,
        DaysOfTheWeekDTO daysOfTheWeekDTO
) {
}
