package com.nsss.pizzamanagementsystembackend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/access")
public class AccessController {

    @GetMapping("/users/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addUsers(){
        return "Admin adds users here";
    }

    @GetMapping("/users/search")
    @PreAuthorize("hasRole('ADMIN')")
    public String searchUsers(){
        return "Admin searches users here";
    }

    @GetMapping("/pizza/types/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public String addPizzaTypes(){
        return "Add pizza type here";
    }

    @GetMapping("/pizza/types/search")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public String searchPizzaTypes(){
        return "Search pizza types here";
    }

    @GetMapping("/pizza/toppings/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public String addPizzaToppings(){
        return "Add pizza toppings here";
    }

    @GetMapping("/pizza/toppings/search")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public String searchPizzaToppings(){
        return "Search pizza toppings here";
    }

    @GetMapping("/orders/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CASHIER')")
    public String addOrders(){
        return "Add orders here";
    }

    @GetMapping("/orders/search")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CASHIER')")
    public String searchOrders(){
        return "Search orders here";
    }
}
