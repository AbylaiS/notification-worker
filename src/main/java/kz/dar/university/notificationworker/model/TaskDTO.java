package kz.dar.university.notificationworker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private String taskId;
    private String initiatorId;
    private String executorId;
    private String description;
}
