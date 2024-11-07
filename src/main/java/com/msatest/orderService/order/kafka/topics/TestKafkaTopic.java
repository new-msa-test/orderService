//package com.msatest.orderService.order.kafka.topics;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//
//public class TestKafkaTopic {
//
//    @Bean
//    public KafkaAdmin admin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
////                "http://172.23.0.4:9092, http://172.23.0.5:9093, http://172.23.0.6:9094");
////                "http://172.17.0.3:9092, http://172.17.0.4:9093, http://172.17.0.5:9094");
////                "http://localhost:9092, http://172.17.0.4:9093, http://172.17.0.5:9094");
////                "kafka-1:9092, kafka-2:9093, kafka-3:9094");
////                "http://10.10.10.59:9092, http://10.10.10.59:9093, http://10.10.10.59:9094");
//        "http://172.23.0.3:9092");
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public NewTopic topic1() {
//        return TopicBuilder.name("test-topic1")
//                .partitions(3)
//                .replicas(2)
//                .build();
//    }
//
//    @Bean
//    public NewTopic topic2() {
//        return TopicBuilder.name("test-topic2")
//                .partitions(5)
//                .replicas(2)
//                .build();
//    }
//
//    @Bean
//    public NewTopic topic3() {
//        return TopicBuilder.name("order-topic")
//                .partitions(3)
//                .replicas(2)
//                .build();
//    }
//}
