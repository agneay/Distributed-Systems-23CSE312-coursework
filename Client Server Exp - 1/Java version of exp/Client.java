import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/** Interactive TCP client for Server.java. */
public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(HOST, PORT);
                BufferedReader serverInput = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(),
                                StandardCharsets.UTF_8));
                PrintWriter serverOutput = new PrintWriter(
                        socket.getOutputStream(),
                        true,
                        StandardCharsets.UTF_8);
                BufferedReader console = new BufferedReader(
                        new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            System.out.println("Connected to " + HOST + ":" + PORT);
            System.out.println("Type a message and press Enter. Type /quit to disconnect.");

            String message;
            while (true) {
                System.out.print("> ");
                message = console.readLine();

                if (message == null) {
                    break;
                }

                serverOutput.println(message);
                String response = serverInput.readLine();

                if (response == null) {
                    System.out.println("Server closed the connection.");
                    break;
                }

                System.out.println(response);
                if (message.equals("/quit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Could not communicate with server: " + e.getMessage());
        }
    }
}
