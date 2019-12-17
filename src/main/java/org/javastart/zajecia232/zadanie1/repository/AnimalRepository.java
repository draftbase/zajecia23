package org.javastart.zajecia232.zadanie1.repository;

import org.javastart.zajecia232.zadanie1.model.Animal;
import org.javastart.zajecia232.zadanie1.model.AnimalSpecies;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AnimalRepository {

    private Map<String, Animal> database;

    public AnimalRepository() {
        database = new HashMap<>();

        Animal azor =
            new Animal("Azor", "To jest opis Azora", "https://i.wpimg.pl/O/529x660/d.wpimg.pl/982032601-1148645422/pies.jpg", AnimalSpecies.DOG);
        Animal rudy = new Animal("Rudy", "To jest opis Rudego", "https://www.zooplus.pl/magazyn/wp-content/uploads/2019/08/kot-syjamski-768x510.jpg",
            AnimalSpecies.CAT);
        Animal bicik = new Animal("Bicik", "To jest bicik", "https://i.pinimg.com/originals/de/d1/b9/ded1b98184f854a53826e864255abfdf.jpg",
            AnimalSpecies.OTHERS);

        this.database.put(azor.getName(), azor);
        this.database.put(rudy.getName(), rudy);
        this.database.put(bicik.getName(), bicik);
    }

    public Animal findByName(String name) {
        return this.database.get(name);
    }

    public List<Animal> findAll() {
        Collection<Animal> values = this.database.values();
        return new ArrayList<>(values);
    }

    public List<Animal> findBySpecies(AnimalSpecies species) {
        return this.database.values().stream()
            .distinct()
            .filter(animal -> animal.getSpecies() == species)
            .collect(Collectors.toList());
    }

    public void add(Animal animal) {
        this.database.put(animal.getName(), animal);
    }

    public void update(Animal animal) {
        this.database.put(animal.getName(), animal);
    }
}
