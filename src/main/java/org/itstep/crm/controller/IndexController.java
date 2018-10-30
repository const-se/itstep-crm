package org.itstep.crm.controller;

import org.itstep.crm.entity.Order;
import org.itstep.crm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String index(Model model) {
        Order order = new Order();
        order.setDescription("Новая заявка");
        orderRepository.save(order);

        model.addAttribute("orders", orderRepository.findAll());

        return "index";
    }
}
