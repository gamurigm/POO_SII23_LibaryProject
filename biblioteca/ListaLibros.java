package biblioteca;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaLibros {

    private final List<Libro> listaLibros;

    public ListaLibros() {
        this.listaLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public void mostrarContenido() {
        System.out.println("Contenido de la lista: ");

        for (Libro libro : listaLibros) {
            System.out.print(libro.toString());
        }
    }

    public void eliminarLibro(Libro libro) {
        Iterator<Libro> iterator = listaLibros.iterator();
        while (iterator.hasNext()) {
            Libro libroActual = iterator.next();
            if (libroActual.equals(libro)) {
                iterator.remove();
                System.out.println("Libro eliminado: " + libro.toString());
                return;
            }
        }
        System.out.println("El libro no se encontró en la lista.");
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(listaLibros);
    }

    // Método para crear una lista de libros desde JSON
    public static ListaLibros fromJson(String json) {
        Gson gson = new Gson();
        Libro[] librosArray = gson.fromJson(json, Libro[].class);

        ListaLibros listaLibros = new ListaLibros();
        for (Libro libro : librosArray) {
            listaLibros.agregarLibro(libro);
        }

        return listaLibros;
    }
}
