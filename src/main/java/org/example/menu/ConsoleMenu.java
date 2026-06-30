package org.example.menu;

import org.example.model.*;
import org.example.shelter.Shelter;
import org.example.util.AnimalUtils;

import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start() {

        int input;
        do {
            printMenu();
            System.out.print("Input:");

            input = scanner.nextInt();
            scanner.nextLine();


            switch (input) {
                case 1:
                    System.out.print("Enter species (Dog/Cat/Bird/Rabbit): ");
                    String type = scanner.nextLine();
                    if (type.isEmpty()) {
                        System.out.println("Unknown value");
                        break;
                    }

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Unknown value");
                        break;
                    }

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    if (age < 0) {
                        System.out.println("Age cannot be negative!");
                        break;
                    }

                    switch (type) {
                        case "Dog" -> shelter.addAnimal(new Dog(new AnimalId(), name, age));
                        case "Cat" -> shelter.addAnimal(new Cat(new AnimalId(), name, age));
                        case "Bird" -> shelter.addAnimal(new Bird(new AnimalId(), name, age));
                        case "Rabbit" -> shelter.addAnimal(new Rabbit(new AnimalId(), name, age));
                        default -> System.out.println("Unknown species");
                    }
                    break;
                case 2:
                    for (Animal a : shelter.getAllAnimals()) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.print("Type in species:");
                    String species = scanner.nextLine();
                    if (species.isEmpty()) {
                        System.out.println("Unknown value");
                        break;
                    }
                    for (Animal a : shelter.findBySpecies(species)) {
                        System.out.println(a);
                    }
                    break;
                case 4:
                    for (Animal a : shelter.findAvailableAnimals()) {
                        System.out.println(a);
                    }
                    break;
                case 5:
                    System.out.print("Type in Animal ID:");
                    String id = scanner.nextLine();
                    if (id.isEmpty()) {
                        System.out.println("Unknown value");
                        break;
                    }
                    System.out.print("Type in Adopters name:");
                    String aName = scanner.nextLine();
                    if (aName.isEmpty()) {
                        System.out.println("Unknown value");
                        break;
                    }
                    shelter.markAsAdopted(id, aName);
                    break;
                case 6:
                    for (Animal a : shelter.sortAnimalsByAge()) {
                        System.out.println(a);
                    }
                    break;
                case 7:
                    for (Animal a : shelter.sortAnimalsByName()) {
                        System.out.println(a);
                    }
                    break;
                case 8:
                    System.out.println("Average age: " + AnimalUtils.averageAge(shelter.getAllAnimals()));
                    System.out.println("Oldest animal: " + AnimalUtils.oldestAnimal(shelter.getAllAnimals()));
                    System.out.println("Count by species: " + AnimalUtils.countBySpecies(shelter.getAllAnimals()));
                    break;
                case 9:
                    if (shelter.getAdoptionHistory().isEmpty()) {
                        System.out.println("No adoptions yet");
                    } else {
                        for (AdoptionRecord record : shelter.getAdoptionHistory()) {
                            System.out.println(record);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Unknown value");
                    break;
            }

        }
        while (input != 0);

    }

    private void printMenu() {
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                6. Sort animals by age
                7. Sort animals by name
                8. Show statistics
                9. Show adoption record
                0. Exit
                """);
    }
}
