package kz.dar.university.notificationworker.service;

import kz.dar.university.notificationworker.model.TaskDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiverService {

    @KafkaListener(id = "${spring.kafka.consumer.group-id}" ,topics = "${spring.kafka.topic}")
    public void consumeMassage(TaskDTO task){

        log.info("Received from kafka : {}" ,task);

    }

}
