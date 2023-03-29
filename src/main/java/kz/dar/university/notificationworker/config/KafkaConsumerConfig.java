package kz.dar.university.notificationworker.config;

import kz.dar.university.notificationworker.model.TaskDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-server}")
    private String bootstrapServer;

    @Value("${Spring.kafka.consumer.group-id}")
    private String kafkaGroupId;

    @Bean
    public ConsumerFactory<String , Object> consumerFactory(){
        Map<String , Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);props.put(
                ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public KafkaListenerContainerFactory<?> singleFactory(){
        ConcurrentKafkaListenerContainerFactory<String , TaskDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
