package org.javastart.zajecia232.zadanie1.model;

public class Animal {
    private String name;
    private String description;
    private String imageUrl;
    private AnimalSpecies species;

    public Animal(final String name, final String description, final String imageUrl,
                  final AnimalSpecies species) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.species = species;
    }

    public Animal() {}

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AnimalSpecies getSpecies() {
        return species;
    }

    public void setSpecies(final AnimalSpecies species) {
        this.species = species;
    }
}
