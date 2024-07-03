package com.campuslands.modules.genre.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.genre.application.GenreService;
import com.campuslands.modules.genre.domain.models.Genre;

/**
 * GenreAdapter
 */
public class GenreAdapter {

    private final GenreService service;

    public GenreAdapter(GenreService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Géneros");
            System.out.println("1. Crear Géneros");
            System.out.println("2. Actualizar Géneros");
            System.out.println("3. Buscar Géneros por ID");
            System.out.println("4. Eliminar Géneros");
            System.out.println("5. Listar todos los Géneros");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    service.createGenre(newGenre(false, scanner, null));
                    break;

                case 2:
                    Genre genre = getGenre();
                    if (genre != null) {
                        service.updateGenre(newGenre(true, scanner, genre));
                    }
                    break;

                case 3:
                    System.out.println(getGenre());
                    break;

                case 4:
                    service.deleteGenre(getId());
                    break;

                case 5:
                    List<Genre> genres = service.getAllGenre();
                    for (Genre item : genres) {
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
        System.out.print("Ingrese el id del Genre: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public Genre getGenre() {

        Optional<Genre> genre = service.getGenreById(getId());
        if (genre.isPresent()) {
            return genre.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        start();
        return null;
    }

    public Genre newGenre(Boolean isEdit, Scanner scanner, Genre data) {
        Genre genre = isEdit ? data : new Genre();

        if (isEdit) {
            System.out.println(genre);
            System.out.print("");
        }

        System.out.print("Ingrese el nombre del Genre: ");
        String name = scanner.nextLine();

     

        
        genre.setDescripcion(name);
        return genre;
    }

}