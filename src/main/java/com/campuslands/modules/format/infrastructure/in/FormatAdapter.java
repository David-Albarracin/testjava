package com.campuslands.modules.format.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.format.application.FormatService;
import com.campuslands.modules.format.domain.models.Format;

/**
 * FormatAdapter
 */
public class FormatAdapter {

    private final FormatService service;

    public FormatAdapter(FormatService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de Formatos");
            System.out.println("1. Crear Formato");
            System.out.println("2. Actualizar Formato");
            System.out.println("3. Buscar Formato por ID");
            System.out.println("4. Eliminar Formato");
            System.out.println("5. Listar todos los Formatos");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.createFormat(newFormat(false, scanner, null));
                    break;

                case 2:
                    Format format = getFormat();
                    if (format != null) {
                        service.updateFormat(newFormat(true, scanner, format));
                    }
                    break;

                case 3:
                    System.out.println(getFormat());
                    break;

                case 4:
                    service.deleteFormat(getId());
                    break;

                case 5:
                    List<Format> formats = service.getAllFormat();
                    for (Format item : formats) {
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
        System.out.print("Ingrese el id del Formato: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public Format getFormat() {

        Optional<Format> format = service.getFormatById(getId());
        if (format.isPresent()) {
            return format.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        return null;
    }

    public Format newFormat(Boolean isEdit, Scanner scanner, Format data) {
        Format format = isEdit ? data : new Format();

        if (isEdit) {
            System.out.println(format);
            System.out.print("");
        }

        System.out.print("Ingrese el nombre del Format: ");
        String name = scanner.nextLine();

        format.setDescripcion(name);
        return format;
    }

}