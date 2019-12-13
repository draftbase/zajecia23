package org.javastart.zajecia232.zadanie1.repository;

import org.javastart.zajecia232.zadanie1.model.Animal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AnimalRepository {

    private Map<String, Animal> database;

    public AnimalRepository() {
        database = new HashMap<>();

        Animal azor = new Animal("Azor", "To jest opis Azora", "https://i.wpimg.pl/O/529x660/d.wpimg.pl/982032601-1148645422/pies.jpg");
        Animal rudy = new Animal("Rudy", "To jest opis Rudego", "https://www.zooplus.pl/magazyn/wp-content/uploads/2019/08/kot-syjamski-768x510.jpg");

        this.database.put(azor.getName(), azor);
        this.database.put(rudy.getName(), rudy);
    }

    public Animal findByName(String name) {
        return this.database.get(name);
    }

    public List<Animal> findAll() {
        Collection<Animal> values = this.database.values();
        return new ArrayList<>(values);
    }
}
