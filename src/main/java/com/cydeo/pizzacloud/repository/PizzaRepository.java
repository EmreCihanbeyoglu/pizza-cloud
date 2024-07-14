package com.cydeo.pizzacloud.repository;

import com.cydeo.pizzacloud.exception.PizzaNotFoundException;
import com.cydeo.pizzacloud.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PizzaRepository {

    private static final List<Pizza> pizzaList = new ArrayList<>();

    public Pizza createPizza(Pizza pizzaToSave) {
        pizzaList.add(pizzaToSave);
        return pizzaToSave;
    }

    public List<Pizza> readAll() {
        return pizzaList;
    }

    public Pizza getPizzaById(UUID id) {
        return pizzaList.stream().filter(pizza -> pizza.getId().equals(id)).findFirst().orElseThrow(() -> new PizzaNotFoundException(id.toString()));
    }

}
