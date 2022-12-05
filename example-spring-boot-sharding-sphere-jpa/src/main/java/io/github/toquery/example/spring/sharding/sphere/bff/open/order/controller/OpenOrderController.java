package io.github.toquery.example.spring.sharding.sphere.bff.open.order.controller;

import io.github.toquery.example.spring.sharding.sphere.bff.open.order.model.response.OrderUserResponse;
import io.github.toquery.example.spring.sharding.sphere.bff.open.order.service.OpenOrderService;
import io.github.toquery.example.spring.sharding.sphere.bff.open.order.model.response.UserInfoResponse;
import io.github.toquery.example.spring.sharding.sphere.modules.order.Order;
import io.github.toquery.example.spring.sharding.sphere.modules.statistics.StatisticsOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/open/order")
@RequiredArgsConstructor
public class OpenOrderController {

    private final OpenOrderService orderService;

    @GetMapping("/user/{userId}")
    public UserInfoResponse userInfo(@PathVariable Long userId) {
        return orderService.userInfo(userId);
    }


    @GetMapping("/save")
    public UserInfoResponse save() {
        return orderService.save();
    }


    @GetMapping("/list")
    public List<Order> list(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long orderId) {
        return orderService.list(userId, orderId);
    }

    @GetMapping("/list-user")
    public List<OrderUserResponse> listWithUser(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long orderId) {
        return orderService.listWithUser(userId, orderId);
    }


    @GetMapping("/page")
    public Page<Order> page(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        return orderService.page(page, size);
    }

    @GetMapping("/statistics")
    public List<StatisticsOrder> statisticsOrder(@RequestParam(required = false) Long storeId,
                                                 @RequestParam(required = false) Long userId,
                                                 @RequestParam(required = false) Long orderId) {
        return orderService.statisticsOrder(storeId, userId, orderId);
    }

}
