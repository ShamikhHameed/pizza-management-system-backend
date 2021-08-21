package com.nsss.pizzamanagementsystembackend.controller;

import com.nsss.pizzamanagementsystembackend.model.Topping;
import com.nsss.pizzamanagementsystembackend.reponse.MessageResponse;
import com.nsss.pizzamanagementsystembackend.repository.ToppingRepository;
import com.nsss.pizzamanagementsystembackend.request.ToppingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/access")
public class ToppingController {
    @Autowired
    ToppingRepository toppingRepository;

    @GetMapping("/toppings")
    public ResponseEntity<List<Topping>> getAllToppings(@RequestParam(required = false) String toppingName) {
        try {
            List<Topping> toppings = new ArrayList<Topping>();

            if (toppingName == null)
                toppingRepository.findAll().forEach(toppings::add);
            else
                toppingRepository.findAllByName(toppingName).forEach(toppings::add);

            if (toppings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(toppings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/toppings")
    public ResponseEntity<?> addTopping(@Valid @RequestBody ToppingRequest toppingRequest) {
        Topping topping = new Topping(
                toppingRequest.getName(),
                toppingRequest.getSmallPrice(),
                calculateMediumToppingPrice(toppingRequest.getSmallPrice()),
                calculateLargeToppingPrice(toppingRequest.getSmallPrice()),
                toppingRequest.isVegan()
        );

        toppingRepository.save(topping);

        return ResponseEntity.ok(new MessageResponse("Topping added successfully"));
    }

    @DeleteMapping("/toppings/{id}")
    public ResponseEntity<HttpStatus> deleteTopping(@PathVariable("id") String id) {
        try {
            toppingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/toppings/{id}")
    public ResponseEntity<Topping> updateTopping(@PathVariable("id") String id, @Valid @RequestBody ToppingRequest toppingRequest) {
        Optional<Topping> toppingData = toppingRepository.findById(id);

        if(toppingData.isPresent()) {
            Topping _topping = toppingData.get();
            _topping.setName(toppingRequest.getName());
            _topping.setSmallPrice(toppingRequest.getSmallPrice());
            _topping.setMediumPrice(calculateMediumToppingPrice(toppingRequest.getSmallPrice()));
            _topping.setLargePrice(calculateLargeToppingPrice(toppingRequest.getSmallPrice()));
            _topping.setVegan(toppingRequest.isVegan());

            return new ResponseEntity<>(toppingRepository.save(_topping), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private double calculateMediumToppingPrice(double smallPrice) {
        //price of a medium topping is 1.85 times the price of a small
        return Math.round((smallPrice*1.85)/10.0)*10;
    }

    private double calculateLargeToppingPrice(double smallPrice) {
        //price of a medium topping is 3.25 times the price of a small
        return Math.round((smallPrice*3.25)/10.0)*10;
    }
}
