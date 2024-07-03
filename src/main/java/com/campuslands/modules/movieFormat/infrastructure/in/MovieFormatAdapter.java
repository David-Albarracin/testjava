package com.campuslands.modules.movieFormat.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.movieFormat.application.MovieFormatService;
import com.campuslands.modules.movieFormat.domain.models.MovieFormat;


/**
 * MovieFormatAdapter
 */
public class MovieFormatAdapter {

    private final MovieFormatService service;

    public MovieFormatAdapter(MovieFormatService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de MovieFormats");
            System.out.println("1. Crear MovieFormat");
            System.out.println("2. Actualizar MovieFormat");
            System.out.println("3. Buscar MovieFormat por ID");
            System.out.println("4. Eliminar MovieFormat");
            System.out.println("5. Listar todos los MovieFormats");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    service.createMovieFormat(newMovieFormat(false, scanner, null));
                    break;

                case 2:
                    MovieFormat movieFormatToUpdate = getMovieFormat();
                    if (movieFormatToUpdate != null) {
                        service.updateMovieFormat(newMovieFormat(true, scanner,movieFormatToUpdate));
                    }
                    break;

                case 3:
                    System.out.println(getMovieFormat());
                    break;

                case 4:
                    service.deleteMovieFormat(getId());
                    break;

                case 5:
                    List<MovieFormat> movieFormats = service.getAllMovieFormat();
                    for (MovieFormat item : movieFormats) {
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
        System.out.print("Ingrese el id del MovieFormat: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public MovieFormat getMovieFormat() {
   
        Optional<MovieFormat> movieFormat = service.getMovieFormatById(getId());
        if (movieFormat.isPresent()) {
            return movieFormat.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        return null;
    }

    public MovieFormat newMovieFormat(Boolean isEdit, Scanner scanner, MovieFormat data) {
        MovieFormat movieFormat = isEdit ? data : new MovieFormat();

        if (isEdit) {
            movieFormat.toString();
            System.out.print("");
        }

        System.out.print("Ingrese el id de la película: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();
    
        System.out.print("Ingrese el id del formato: ");
        int formatId = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Ingrese el id de la película: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        
        movieFormat.setMovieId(movieId);
        movieFormat.setFormatId(formatId);
        movieFormat.setAmount(amount);
        return movieFormat;
    }

}