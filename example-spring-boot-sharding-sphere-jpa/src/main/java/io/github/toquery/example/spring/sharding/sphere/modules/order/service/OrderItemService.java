package io.github.toquery.example.spring.sharding.sphere.modules.order.service;

import io.github.toquery.example.spring.sharding.sphere.core.modules.order.Order;
import io.github.toquery.example.spring.sharding.sphere.core.modules.order.OrderItem;
import io.github.toquery.example.spring.sharding.sphere.modules.order.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;


    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }


    public List<OrderItem> save(Long userId, List<Order> orders) {
        return orderItemRepository.saveAll(orders.stream().map(order -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setUserId(userId);
            orderItem.setOrderId(order.getId());
            return orderItem;
        }).toList());

    }

    public OrderItem update(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> list() {
        return orderItemRepository.findAll();
    }

    public List<OrderItem> findByUserId(Long userId) {
        return orderItemRepository.findByUserId(userId);
    }

    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }


}
