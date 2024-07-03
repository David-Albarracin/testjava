package com.campuslands.modules.country.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.campuslands.modules.country.application.CountryService;
import com.campuslands.modules.country.domain.models.Country;

/**
 * CountryAdapter
 */
public class CountryAdapter {

    private final CountryService service;

    public CountryAdapter(CountryService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de País");
            System.out.println("1. Crear País");
            System.out.println("2. Actualizar País");
            System.out.println("3. Buscar País por ID");
            System.out.println("4. Eliminar País");
            System.out.println("5. Listar todos los País");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.createCountry(newCountry(false, scanner, null));
                    break;

                case 2:
                    Country country = getCountry();
                    if (country != null) {
                        service.updateCountry(newCountry(true, scanner, country));
                    }
                    break;

                case 3:
                    System.out.println(getCountry());
                    break;

                case 4:
                    service.deleteCountry(getId());
                    break;

                case 5:
                    List<Country> countries = service.getAllCountry();
                    for (Country item : countries) {
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
        System.out.print("Ingrese el id del Country: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public Country getCountry() {
        Optional<Country> country = service.getCountryById(getId());
        if (country.isPresent()) {
            return country.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        start();
        return null;
    }

    public Country newCountry(Boolean isEdit, Scanner scanner,  Country data) {
        Country country = isEdit ? data : new Country();

        if (isEdit) {
            System.out.println(country);
            System.out.print("");
        }

        System.out.print("Ingrese el nombre del Country: ");
        String name = scanner.nextLine();

        country.setDescripcion(name);
        return country;
    }

}