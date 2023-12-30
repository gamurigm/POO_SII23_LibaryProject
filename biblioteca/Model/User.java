package biblioteca.Model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class User {

    protected String id;
    protected String nombre;
    protected String direccion;
    protected String telf;
    protected String email;
    protected String password;
    private String creado;

    public User() {
        this.id = UUID.randomUUID().toString();
        this.creado = LocalDateTime.now().toString();
    }

    public User(String nombre, String direccion, String telf, String email, String password) {

        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.direccion = direccion;
        this.telf = telf;
        this.email = email;
        this.password = password;
        this.creado = LocalDateTime.now().toString();
    }
    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelf() {
        return telf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String fechaCreacion() {
        return creado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telf='" + telf + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
