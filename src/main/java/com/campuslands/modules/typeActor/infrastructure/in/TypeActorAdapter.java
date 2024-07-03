package com.campuslands.modules.typeActor.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.typeActor.application.TypeActorService;
import com.campuslands.modules.typeActor.domain.models.TypeActor;



/**
 * TypeActorAdapter
 */
public class TypeActorAdapter {

    private final TypeActorService service;

    public TypeActorAdapter(TypeActorService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Gestión de TypeActores");
            System.out.println("1. Crear TypeActor");
            System.out.println("2. Actualizar TypeActor");
            System.out.println("3. Buscar TypeActor por ID");
            System.out.println("4. Eliminar TypeActor");
            System.out.println("5. Listar todos los TypeActores");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.createTypeActor(newTypeActor(false, scanner, null));
                    break;

                case 2:
                    TypeActor typeActor = getTypeActor();
                    if (typeActor != null) {
                        service.updateTypeActor(newTypeActor(true, scanner, typeActor));
                    }
                    break;

                case 3:
                    System.out.println(getTypeActor());
                    break;

                case 4:
                    service.deleteTypeActor(getId());
                    break;

                case 5:
                    List<TypeActor> typeActors = service.getAllTypeActor();
                    for (TypeActor item : typeActors) {
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
        System.out.print("Ingrese el id del TypeActor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public TypeActor getTypeActor() {
     
        Optional<TypeActor> typeActor = service.getTypeActorById(getId());
        if (typeActor.isPresent()) {
            return typeActor.get();
        }
        System.out.println("");
        System.out.println("Invalid ID. Id not found!");
        System.out.println("");
        return null;
    }

    public TypeActor newTypeActor(Boolean isEdit, Scanner scanner, TypeActor data) {
        TypeActor typeActor = isEdit ? data : new TypeActor();

        if (isEdit) {
            System.out.println(typeActor);
            System.out.print("");
        }

        System.out.print("Ingrese el nombre del tipo de actor: ");
        String name = scanner.nextLine();

     

        
        typeActor.setDescription(name);
        return typeActor;
    }

}