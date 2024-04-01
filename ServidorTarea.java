import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTarea {

    public static void main(String[] args) {
        
        // Establece el puerto a utilizar
        int puerto = 8080;

        try{

            // Se crea un objeto socket de servidor
            ServerSocket ss = new ServerSocket(puerto);
            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");

            Socket ch = ss.accept();

            PrintWriter out = new PrintWriter(ch.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(ch.getInputStream()));

            out.println("Hola");
            out.println("Mundo");
            out.println("desde el servidor!");

            Scanner scanner = new Scanner(System.in);

            String mensaje;
            while (!(mensaje = scanner.nextLine()).equalsIgnoreCase("Adios")) {
                out.println(mensaje);
            }

            out.println("Adios");

            scanner.close();
            out.close();
            in.close();
            ch.close();
            ss.close();

        } catch(IOException ex) {
            System.out.println(ex);
        }

    }
    
}