import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7000)) {

            System.out.println("Server is listening on port " + 7000);

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                writer.println(new Date());
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
