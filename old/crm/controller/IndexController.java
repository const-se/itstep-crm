package org.itstep.crm.controller;

import org.itstep.crm.entity.Brand;
import org.itstep.crm.entity.Car;
import org.itstep.crm.entity.Order;
import org.itstep.crm.repository.BrandRepository;
import org.itstep.crm.repository.CarRepository;
import org.itstep.crm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Brand> brands = brandRepository.findAll();
        model.addAttribute("brands", brands);

        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);

        return "public/index";
    }

    @GetMapping("/brand/{brand}")
    public String brand(@ModelAttribute("brand") Brand brand, Model model) {
        model.addAttribute("brand", brand);

        Iterable<Car> cars = carRepository.findAllByBrand(brand);
        model.addAttribute("cars", cars);

        return "public/brand";
    }

    @GetMapping("/order")
    public String order(Model model) {
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);

        return "public/order";
    }

    @PostMapping("/save-order")
    public String saveOrder(@ModelAttribute Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            String errorText = "";

            for (ObjectError error : result.getAllErrors()) {
                errorText += error.toString() + "<br/>";
            }

            model.addAttribute("error", errorText);

            return "public/error";
        }

        orderRepository.save(order);

        return "redirect:/";
    }
}
