package biblioteca.Model;

import java.util.Scanner;

public class UserMenu {

    private final ListaLibros listaLibros;

    public UserMenu(ListaLibros listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menu de Usuario ---");
            System.out.println("1. Buscar Libros");
            System.out.println("2. Reservar Libro");
            System.out.println("3. Pedir Libro Prestado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> buscarLibros();
                case 2 -> reservarLibro();
                case 3 -> pedirLibroPrestado();
                case 4 -> System.out.println("Saliendo del Menu de Usuario.");
                default -> System.out.println("Opción no valida. Intente de nuevo.");
            }

        } while (opcion != 4);
    }

    private void buscarLibros() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Buscar Libros ---");
        System.out.println("1. Buscar por Titulo");
        System.out.println("2. Buscar por Autor");
        System.out.println("3. Buscar por Genero");
        System.out.println("4. Volver al Menu Principal");
        System.out.print("Seleccione una opcion: ");

        int opcionBusqueda = scanner.nextInt();
        scanner.nextLine();

        switch (opcionBusqueda) {
            case 1 -> buscarPorTitulo();
            case 2 -> buscarPorAutor();
            case 3 -> buscarPorGenero();
            case 4 -> System.out.println("Volviendo al Menu Principal.");
            default -> System.out.println("Opción no valida. Intente de nuevo.");
        }
    }

    private void buscarPorTitulo() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el título del libro: ");
    String titulo = scanner.nextLine();

    Libro resultado = listaLibros.buscarPorTitulo(titulo);
    
    if (resultado != null) {
    
        System.out.println("Libro encontrado:\n" + resultado.toString());
    } else {
        System.out.println("El libro no se encontro en la lista.");
        }
    }

    private void buscarPorAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del autor: ");
        String autor = scanner.nextLine();

        ListaLibros resultados = listaLibros.buscarPorAutor(autor);
        resultados.mostrarContenido();
    }

    private void buscarPorGenero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el genero del libro: ");
        String genero = scanner.nextLine();

        ListaLibros resultados = listaLibros.buscarPorGenero(genero);
        resultados.mostrarContenido();
    }

    private void reservarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el titulo del libro que desea reservar: ");
        String titulo = scanner.nextLine();

        Libro libroReservar = listaLibros.buscarPorTitulo(titulo);

        if (libroReservar != null) {
            // Implementa lógica de reserva aquí
            System.out.println("Libro '" + libroReservar.getTitulo() + "' reservado exitosamente.");
        } else {
            System.out.println("El libro no se encontro en la lista.");
        }
    }

    private void pedirLibroPrestado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el titulo del libro que desea pedir prestado: ");
        String titulo = scanner.nextLine();

        Libro libroPrestar = listaLibros.buscarPorTitulo(titulo);

        if (libroPrestar != null) {
            System.out.println("Libro '" + libroPrestar.getTitulo() + "' prestado exitosamente.");
        } else {
            System.out.println("El libro no se encontro en la lista.");
        }
    }
}