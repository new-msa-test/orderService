package com.msatest.orderService.order.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msatest.orderService.order.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestKafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaTemplate<String, OrderDto> orderKafkaTemplate;
    private final KafkaTemplate<String, List<OrderDto>> orderListKafkaTemplate;

    private final String TOPIC1 = "test-topic1";
    private final String TOPIC2 = "test-topic2";
    private final String ORDER_TOPIC = "order-topic";
    private final String ORDER_OBJECT_TOPIC = "order-object-topic";

    public void sendTestMessage(String message) {
        kafkaTemplate.send(TOPIC1, message);
    }

    public void sendOrderMessage(OrderDto orderDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String stringOrderDto = objectMapper.writeValueAsString(orderDto);
            kafkaTemplate.send(ORDER_TOPIC, stringOrderDto);
            log.info("OrderDto sent: " + stringOrderDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    public void sendOrderMessageObject(OrderDto orderDto) {
        try {
            orderKafkaTemplate.send(ORDER_OBJECT_TOPIC, orderDto);
            log.info("OrderDto Object sent: " + orderDto.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public void sendOrderMessageObject(OrderDto orderDto) {
//        List<OrderDto> list = new ArrayList<>();
//        list.add(orderDto);
//
//        try {
//            orderListKafkaTemplate.send(ORDER_OBJECT_TOPIC, list);
//            log.info("OrderListDto Object sent: " + list.toString());
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
