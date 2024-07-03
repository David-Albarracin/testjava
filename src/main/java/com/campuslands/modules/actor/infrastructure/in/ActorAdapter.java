package com.campuslands.modules.actor.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.actor.application.ActorService;
import com.campuslands.modules.actor.domain.models.Actor;

/**
 * ActorAdapter
 */
public class ActorAdapter {

    private final ActorService service;

    public ActorAdapter(ActorService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Actores");
            System.out.println("1. Crear Actor");
            System.out.println("2. Actualizar Actor");
            System.out.println("3. Buscar Actor por ID");
            System.out.println("4. Eliminar Actor");
            System.out.println("5. Listar todos los Actores");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    service.createActor(newActor(false, scanner));
                    break;

                case 2:

                    service.updateActor(newActor(true, scanner));
                    break;

                case 3:
                    getActor().toString();
                    break;

                case 4:

                    break;

                case 5:
                    List<Actor> actors = service.getAllActor();
                    for (Actor item : actors) {
                        item.toString();
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    public Actor getActor() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del actor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<Actor> actor = service.getActorById(id);
        if (actor.isPresent()) {
            return actor.get();
        }
        return null;
    }

    public Actor newActor(Boolean isEdit, Scanner scanner) {
        Actor actor;

        if (isEdit) {
            actor = getActor();
            actor.toString();
            System.out.print("");
        }

        System.out.print("Ingrese el nombre del actor: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese la edad del actor: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el id de la ciudad: ");
        int countryId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el id del genero: ");
        int genreId = scanner.nextInt();
        scanner.nextLine();

        
        actor = new Actor(name, age, countryId, genreId);
        return actor;
    }

}