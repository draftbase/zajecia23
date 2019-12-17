package org.javastart.zajecia232.zadanie1.controller;

import org.javastart.zajecia232.zadanie1.model.Animal;
import org.javastart.zajecia232.zadanie1.model.AnimalSpecies;
import org.javastart.zajecia232.zadanie1.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.util.Objects.nonNull;

@Controller
public class AnimalController {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalController(final AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String homePage(Model model, @RequestParam(required = false, name = "gatunek") AnimalSpecies species) {
        List<Animal> animals = animalRepository.findAll();

        if (nonNull(species)) {
            animals = animalRepository.findBySpecies(species);
        }

        model.addAttribute("animals", animals);
        return "home";
    }

    @GetMapping("/zwierzak")
    public String getAnimalDetails(@RequestParam("imie") String name, Model model) {
        Animal animal = animalRepository.findByName(name);
        model.addAttribute("animal", animal);
        return "animal";
    }

    @GetMapping("/add")
    public String addAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("mode", "add");
        return "addOrEdit";
    }

    @PostMapping("/add")
    public String addAnimalToDatabase(Animal animal) {
        animalRepository.add(animal);
        return "redirect:/zwierzak?imie=" + animal.getName();
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam(value = "imie") String name, Model model) {
        Animal animal = animalRepository.findByName(name);
        model.addAttribute("animal", animal);
        model.addAttribute("mode", "edit");
        return "addOrEdit";
    }

    @PostMapping("/edit")
    public String editAnimal(Animal animal) {
        Animal animalFromDatabase = animalRepository.findByName(animal.getName());
        animalFromDatabase.setDescription(animal.getDescription());
        animalFromDatabase.setImageUrl(animal.getImageUrl());
        animalFromDatabase.setName(animal.getName());
        animalFromDatabase.setSpecies(animal.getSpecies());

        //Nie trzeba - bo obiekt wyżej jest referencją
        animalRepository.update(animal);
        return "redirect:/zwierzak?imie=" + animal.getName();
    }
}
