package com.campuslands;

import java.util.Scanner;


import com.campuslands.modules.actor.infrastructure.out.ActorOutModule;
import com.campuslands.modules.country.infrastructure.out.CountryOutModule;
import com.campuslands.modules.format.infrastructure.out.FormatOutModule;
import com.campuslands.modules.genre.infrastructure.out.GenreOutModule;
import com.campuslands.modules.movie.infrastructure.out.MovieOutModule;
import com.campuslands.modules.movieProtagonist.infrastructure.out.MovieProtagonistOutModule;
import com.campuslands.modules.typeActor.infrastructure.out.TypeActorOutModule;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("Películas Campuslands");
            System.out.println("1. Gestionar Actores");
            System.out.println("2. Gestionar Películas");
            System.out.println("3. Gestionar Formatos");
            System.out.println("4. Gestionar Géneros");
            System.out.println("5. Gestionar Países");
            System.out.println("6. Gestionar Tipos de Actores");
            System.out.println("7. Asignar Actor a Película");
            System.out.println("8. Consultar Información de Película");
            System.out.println("9. Listar Actores Por Películas");
            System.out.println("10. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ActorOutModule actorOutModule = new ActorOutModule();
                    actorOutModule.module().start();
                    break;

                case 2:
                    MovieOutModule movieOutModule = new MovieOutModule();
                    movieOutModule.module().start();
                    break;

                case 3:
                    FormatOutModule formatOutModule = new FormatOutModule();
                    formatOutModule.module().start();
                    break;

                case 4:
                    GenreOutModule genreOutModule = new GenreOutModule();
                    genreOutModule.module().start();
                    break;

                case 5:
                    CountryOutModule countryOutModule = new CountryOutModule();
                    countryOutModule.module().start();
                    break;

                case 6:
                    TypeActorOutModule typeActorOutModule = new TypeActorOutModule();
                    typeActorOutModule.module().start();
                    break;
                case 7:
                    MovieProtagonistOutModule movieProtagonistOutModule = new MovieProtagonistOutModule();
                    movieProtagonistOutModule.module().start();
                    break;
                case 8:
                    MovieOutModule movieOutModuleInfo = new MovieOutModule();
                    movieOutModuleInfo.infoMovie();
                    break;
                case 9:
                    MovieOutModule movieOutModuleActors = new MovieOutModule();
                    movieOutModuleActors.infoMovieActors();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}