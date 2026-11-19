import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ChatClient {
    private static final int PORT = 5002;
    public static void main(String[] args) throws IOException {
        String host = args.length > 0 ? args[0] : prompt("Server IP: ");
        try (Socket socket = new Socket(host, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connected. Type messages; /quit to exit.");
            Thread receiver = new Thread(() -> {
                try { String line; while ((line = in.readLine()) != null) System.out.println("\nServer: " + line); }
                catch (IOException ignored) { }
            }); receiver.setDaemon(true); receiver.start();
            String message;
            while ((message = keyboard.readLine()) != null && !message.equals("/quit")) out.println(message);
        }
    }
    private static String prompt(String label) throws IOException { System.out.print(label); return new BufferedReader(new InputStreamReader(System.in)).readLine(); }
}