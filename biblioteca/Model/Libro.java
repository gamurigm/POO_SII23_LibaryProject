package biblioteca.Model;

public class Libro {
    private static int nextId = 1;
    private final int id;
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, String genero) {
        this.id = nextId++;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponible = true;
    }

    public Libro(String titulo, String autor) {
        this.id = nextId++;
        this.titulo = titulo;
        this.autor = autor;

    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
 

    @Override
    public String toString() {
        return 
               
               """
               \tLibro
               {
               \tid: """ + id + ", \n"
                + "\ttitulo: " + titulo + ", \n"
                + "\tautor: " + autor + ", \n"
                + "\tgenero: " + genero + ", \n}\n";

        
    }
}
