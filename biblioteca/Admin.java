package biblioteca;

public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String nombre, String direccion, String telf, String email, String password) {
        super(nombre, direccion, telf, email, password);
    }
}