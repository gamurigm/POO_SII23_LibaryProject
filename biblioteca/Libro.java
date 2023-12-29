package biblioteca;

public class Libro {
    private static int nextId = 1;
    private final int id;
    private String titulo;
    private String autor;
    private String genero;
    private double precio;

    public Libro(String titulo, String autor, String genero, double precio) {
        this.id = nextId++;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.precio = precio;
    }

    public Libro(String titulo, String autor, double precio) {
        this.id = nextId++;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
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

    public void setPrecio(double precio) {
        this.precio = precio;
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
                + "\tgenero: " + genero + ", \n"
                + "\tprecio: " + precio + "\n}\n";
               
               
    }
}
