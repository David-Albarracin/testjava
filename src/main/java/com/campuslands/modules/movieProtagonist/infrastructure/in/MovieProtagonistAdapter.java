package com.campuslands.modules.movieProtagonist.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.movieProtagonist.application.MovieProtagonistService;
import com.campuslands.modules.movieProtagonist.domain.models.MovieProtagonist;


/**
 * MovieProtagonistAdapter
 */
public class MovieProtagonistAdapter {

    private final MovieProtagonistService service;

    public MovieProtagonistAdapter(MovieProtagonistService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Actores peliculas");
            System.out.println("1. Asignar actor a película");
            System.out.println("2. Actualizar Actores peliculas");
            System.out.println("3. Buscar Actores peliculas por ID");
            System.out.println("4. Eliminar Actores peliculas");
            System.out.println("5. Listar todos los Actores peliculas");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.createMovieProtagonist(newMovieProtagonist(false, scanner, null));
                    break;

                case 2:
                    MovieProtagonist movieProtagonist = getMovieProtagonist();
                    if (movieProtagonist != null) {
                        service.updateMovieProtagonist(newMovieProtagonist(true, scanner, movieProtagonist));
                    }
                    break;

                case 3:
                    System.out.println(getMovieProtagonist());
                    break;

                case 4:
                    service.deleteMovieProtagonist(getId());
                    break;

                case 5:
                    List<MovieProtagonist> movieProtagonists = service.getAllMovieProtagonist();
                    for (MovieProtagonist item : movieProtagonists) {
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
        System.out.print("Ingrese el id del MovieProtagonist: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public MovieProtagonist getMovieProtagonist() {
       
        Optional<MovieProtagonist> MovieProtagonist = service.getMovieProtagonistById(getId());
        if (MovieProtagonist.isPresent()) {
            return MovieProtagonist.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        return null;
    }

    public MovieProtagonist newMovieProtagonist(Boolean isEdit, Scanner scanner, MovieProtagonist data) {
        MovieProtagonist movieProtagonist = isEdit ? data : new MovieProtagonist();

        if (isEdit) {
            System.out.println(movieProtagonist);
            System.out.print("");
        }

        System.out.print("Ingrese la movie id: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la actor id: ");
        int actorId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el actor type id: ");
        int actorType = scanner.nextInt();
        scanner.nextLine();

        
        movieProtagonist.setMovieId(movieId);
        movieProtagonist.setActorId(actorId);
        movieProtagonist.setActorTypeId(actorType);
        return movieProtagonist;
    }

}