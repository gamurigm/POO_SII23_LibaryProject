
package biblioteca;

public class GestorBiblioteca {

    public static void main(String[] args) {
        
        ListaLibros listaLibros = new ListaLibros();
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Ficción", 19.99);
        Libro libro2 = new Libro("1984", "George Orwell", "Distopía", 15.99);

        listaLibros.agregarLibro(libro1);
        listaLibros.agregarLibro(libro2);

        System.out.println("Contenido de la lista antes de la conversión:");
        listaLibros.mostrarContenido();

        String jsonLista = listaLibros.toJson();
        System.out.println("\nLista de libros en formato JSON:\n" + jsonLista);

        ListaLibros nuevaListaLibros = ListaLibros.fromJson(jsonLista);

        System.out.println("\nContenido de la lista después de la conversión:");
        nuevaListaLibros.mostrarContenido();
    }
}
        
        
        
