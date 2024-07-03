package com.campuslands.modules.movie.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.movie.application.MovieService;

import com.campuslands.modules.movie.domain.models.Movie;

/**
 * MovieAdapter
 */
public class MovieAdapter {

    private final MovieService service;

    public MovieAdapter(MovieService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Movies");
            System.out.println("1. Crear Movie");
            System.out.println("2. Actualizar Movie");
            System.out.println("3. Buscar Movie por ID");
            System.out.println("4. Eliminar Movie");
            System.out.println("5. Listar todos los Movies");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    service.createMovie(newMovie(false, scanner, null));
                    break;

                case 2:
                    Movie movieToUpdate = getMovie();
                    if (movieToUpdate != null) {
                        service.updateMovie(newMovie(true, scanner, movieToUpdate));
                    }
                    break;

                case 3:
                    System.out.println(getMovie());
                    break;

                case 4:
                    service.deleteMovie(getId());
                    break;

                case 5:
                    List<Movie> movies = service.getAllMovie();
                    for (Movie item : movies) {
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
        System.out.print("Ingrese el id de la Película: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public Movie getMovie() {
   
        Optional<Movie> movie = service.getMovieById(getId());
        if (movie.isPresent()) {
            return movie.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        return null;
    }

    public Movie newMovie(Boolean isEdit, Scanner scanner, Movie existingMovie) {
        Movie movie = isEdit ? existingMovie : new Movie();

        if (isEdit) {
            movie.toString();
            System.out.print("");
        }

        System.out.println("Ingrese el código de la Movie: ");
        String code = scanner.nextLine();

        System.out.print("Ingrese el nombre del Movie: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese la duración en min de la Movie: ");
        String duration = scanner.nextLine();

        System.out.println("Ingrese la sinopsis de la Movie: ");
        String sinopsis = scanner.nextLine();

        movie.setCode(code);
        movie.setName(name);
        movie.setDuration(duration);
        movie.setSinopsis(sinopsis);
        return movie;
    }

}