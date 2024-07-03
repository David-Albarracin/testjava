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
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.createActor(newActor(false, scanner, null));
                    break;

                case 2:
                    Actor actorToUpdate = getActor();
                    if (actorToUpdate != null) {
                        service.updateActor(newActor(true, scanner, actorToUpdate));
                    }
                    break;

                case 3:
                    System.out.println(getActor());
                    break;

                case 4:
                    service.deleteActor(getId());
                    break;

                case 5:
                    List<Actor> actors = service.getAllActor();
                    for (Actor item : actors) {
                        System.out.println(item);
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    public int getId(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del actor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public Actor getActor() {
        Optional<Actor> actor = service.getActorById(getId());
        if (actor.isPresent()) {
            return actor.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        return null;
    }

    public Actor newActor(Boolean isEdit, Scanner scanner, Actor data) {
        Actor actor = isEdit ? data : new Actor();

        if (isEdit) {
            System.out.println(actor);
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

        
        actor.setName(name);
        actor.setAge(age);
        actor.setCountryId(countryId);
        actor.setGenreId(genreId);
        return actor;
    }

}