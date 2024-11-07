package com.msatest.orderService.config;

import com.msatest.orderService.order.dto.OrderDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "http://172.23.0.4:9092, http://172.23.0.5:9093, http://172.23.0.6:9094");
//                "kafka-1:9092"); // single kafka ("172.23.0.4:9092" 도 가능)
//                "kafka-1:9092, kafka-2:9093, kafka-3:9094"); // 동작 확인 o (컨테이너 환경)
//                "localhost:9092, localhost:9093, localhost:9094");
                "localhost:29092, localhost:39092, localhost:49092");
//                "localhost:9092");
//                "kafka-1:9092");
//                "http://172.23.0.101:9092");

        // 프로듀서가 처음 연결할 kafka broker 주소
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // 메시지를 보내기 위해 key,value 값을 직렬화할 때 사용할 클래스

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        // kafka producer (producer factory를 통해 생성) 의 기본동작을 수행하는 wrapper class
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, OrderDto> orderProducerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "http://172.23.0.4:9092, http://172.23.0.5:9093, http://172.23.0.6:9094");
//                "http://127.0.0.1:9092, http://127.0.0.1:9093, http://127.0.0.1:9094");
//                "http://10.10.10.59:9092, http://10.10.10.59:9093, http://10.10.10.59:9094");
//                "http://172.23.0.3:9092");
//                "kafka-1:9092, kafka-2:9093, kafka-3:9094"); // 동작 확인 o (컨테이너 환경)
//                "localhost:9092, localhost:9093, localhost:9094");
                "localhost:29092, localhost:39092, localhost:49092");
//                "localhost:9092");
//                "kafka-1:9092");
//                "http://172.23.0.101:9092");

        return new DefaultKafkaProducerFactory<>(config, new StringSerializer(), new JsonSerializer<OrderDto>());
    }

    @Bean
    public KafkaTemplate<String, OrderDto> orderKafkaTemplate() {
        return new KafkaTemplate<>(orderProducerFactory());
    }

    @Bean
    public ProducerFactory<String, List<OrderDto>> orderListProducerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "http://172.23.0.4:9092, http://172.23.0.5:9093, http://172.23.0.6:9094");
//                "http://127.0.0.1:9092, http://127.0.0.1:9093, http://127.0.0.1:9094");
//                "http://10.10.10.59:9092, http://10.10.10.59:9093, http://10.10.10.59:9094");
//                "http://172.23.0.3:9092");
//                "kafka-1:9092, kafka-2:9093, kafka-3:9094"); // 동작 확인 o (컨테이너 환경)
//                "localhost:9092, localhost:9093, localhost:9094");
                "localhost:29092, localhost:39092, localhost:49092");
//                "localhost:9092");
//                "kafka-1:9092");
//                "http://172.23.0.101:9092");

        return new DefaultKafkaProducerFactory<>(config, new StringSerializer(), new JsonSerializer<List<OrderDto>>());
    }

    @Bean
    public KafkaTemplate<String, List<OrderDto>> orderListKafkaTemplate() {
        return new KafkaTemplate<>(orderListProducerFactory());
    }

}
