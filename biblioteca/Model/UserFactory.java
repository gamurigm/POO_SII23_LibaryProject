package biblioteca.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFactory {

    private static final String USERS_JSON_FILE = "users.json";

    public static Usuario createUser(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();

        System.out.print("Telefono: ");
        String telf = scanner.nextLine();

        System.out.print("Correo electronico: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombre, direccion, telf, email, password);
        saveUserToJson(nuevoUsuario);

        return nuevoUsuario;
    }

    public static void saveUserToJson(User user) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    try (FileWriter writer = new FileWriter(USERS_JSON_FILE, true)) {
        // Si el archivo está vacío, escribe el corchete de apertura
        if (Files.size(Paths.get(USERS_JSON_FILE)) == 0) {
            writer.write("[");
        } else {
            // Si no está vacío, añade una coma para separar los objetos
            writer.write(",");
        }

        gson.toJson(user, writer);
        writer.write(System.lineSeparator());  // Utiliza System.lineSeparator() para añadir un salto de línea
        System.out.println("Usuario guardado en " + USERS_JSON_FILE);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static List<Usuario> loadUsersFromJson() {
    List<Usuario> usuarios = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(USERS_JSON_FILE))) {
        Gson gson = new Gson();
        StringBuilder jsonContent = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            jsonContent.append(line);
        }

        //parsea el JSON completo
        JsonArray jsonArray = gson.fromJson(jsonContent.toString(), JsonArray.class);

        for (JsonElement element : jsonArray) {
            Usuario usuario = gson.fromJson(element, Usuario.class);
            usuarios.add(usuario);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return usuarios;
}

    public static Usuario findUserByEmail(List<Usuario> usuarios, String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
}
