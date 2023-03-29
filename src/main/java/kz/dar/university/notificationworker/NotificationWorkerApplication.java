package kz.dar.university.notificationworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class NotificationWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationWorkerApplication.class, args);
	}

}
