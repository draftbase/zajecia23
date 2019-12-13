package org.javastart.zajecia232.zadanie1.controller;

import org.javastart.zajecia232.zadanie1.model.Animal;
import org.javastart.zajecia232.zadanie1.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnimalController {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalController(final AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<Animal> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);
        return "home";
    }

    @GetMapping("/zwierzak")
    public String getAnimalDetails(@RequestParam("imie") String name, Model model) {
        Animal animal = animalRepository.findByName(name);
        model.addAttribute("animal", animal);
        return "animal";
    }
}
