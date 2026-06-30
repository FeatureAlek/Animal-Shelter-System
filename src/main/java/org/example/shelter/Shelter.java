package org.example.shelter;

import org.example.model.AdoptionRecord;
import org.example.model.AdoptionStatus;
import org.example.model.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Shelter <T extends Animal>{
    private final List<T> animals = new ArrayList<>();
    private final List<AdoptionRecord> adoptionHistory = new ArrayList<>();

    public void addAnimal(T animal){
        animals.add(animal);
    }

    public List<T> getAllAnimals(){
        return new ArrayList<>(animals);
    }

    public List<T> findBySpecies(String species){
        List <T> result = new ArrayList<>();

        for(T x : animals){
            if(x.getSpecies().equals(species)){
                result.add(x);
            }
        }
        return result;
    }

    public List<T> findAvailableAnimals(){
        List <T> result = new ArrayList<>();

        for(T x : animals){
            if(x.getAdoptionStatus() == AdoptionStatus.AVAILABLE){
                result.add(x);
            }
        }
        return result;
    }

    public void markAsAdopted(String id, String adopterName) {
        for (T x : animals) {
            if (x.getId().toString().equals(id)) {
                x.markAsAdopted();
                adoptionHistory.add(new AdoptionRecord(x, LocalDate.now(), adopterName));
            }
        }
    }

    public List <T> sortAnimalsByAge(){
        List <T> result = new ArrayList<>(animals);
        result.sort(Comparator.comparing(T::getAge));
        return result;
    }

    public List <T> sortAnimalsByName(){
        List <T> result = new ArrayList<>(animals);
        result.sort(Comparator.comparing(T::getName));
        return result;
    }

    public List<AdoptionRecord> getAdoptionHistory() {
        return new ArrayList<>(adoptionHistory);
    }
}
