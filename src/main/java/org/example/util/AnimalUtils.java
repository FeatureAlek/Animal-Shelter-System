package org.example.util;

import org.example.model.Animal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalUtils {

    public static <T extends Animal> double averageAge(List<T> animals) {
        if (animals.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (T animal : animals) {
            sum += animal.getAge();
        }
        return (double) sum / animals.size();
    }

    public static <T extends Animal> T oldestAnimal(List<T> animals) {
        if (animals.isEmpty()) {
            return null;
        }
        T oldest = animals.get(0);
        for (T animal : animals) {
            if (animal.getAge() > oldest.getAge()) {
                oldest = animal;
            }
        }
        return oldest;
    }

    public static <T extends Animal> Map<String, Long> countBySpecies(List<T> animals) {
        Map<String, Long> counts = new HashMap<>();
        for (T animal : animals) {
            String species = animal.getSpecies();
            counts.put(species, counts.getOrDefault(species, 0L) + 1);
        }
        return counts;
    }
}