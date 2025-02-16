package com.cydeo.pizzacloud.controller;


import com.cydeo.pizzacloud.model.PizzaOrder;
import com.cydeo.pizzacloud.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final PizzaRepository pizzaRepository;

    public OrderController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/current")
    public String orderForm(@RequestParam("pizzaId") UUID pizzaId, Model model) {

        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setPizza(pizzaRepository.getPizzaById(pizzaId));
        model.addAttribute("pizzaOrder", pizzaOrder);

        return "/orderForm";
    }

    @PostMapping("/{pizzaId}")
    public String processOrder(@PathVariable("pizzaId") UUID pizzaId, @ModelAttribute("pizzaOder") PizzaOrder pizzaOrder) {

        // Save the order
        pizzaOrder.setPizza(pizzaRepository.getPizzaById(pizzaId));
        return "redirect:/home";
    }

}
