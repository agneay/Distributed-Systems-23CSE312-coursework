import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ChatServer {
    private static final int PORT = 5002;
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket()) {
            server.setReuseAddress(true);
            server.bind(new InetSocketAddress("0.0.0.0", PORT));
            System.out.println("Server listening on port " + PORT);
            try (Socket client = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8), true)) {
                System.out.println("Connected: " + client.getRemoteSocketAddress());
                Thread receiver = new Thread(() -> {
                    try { String line; while ((line = in.readLine()) != null) System.out.println("\nClient: " + line); }
                    catch (IOException e) { System.out.println("\nClient disconnected."); }
                });
                receiver.setDaemon(true); receiver.start();
                System.out.println("Type messages; /quit to exit.");
                try (BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
                    String message;
                    while ((message = keyboard.readLine()) != null && !message.equals("/quit")) out.println(message);
                }
            }
        }
        System.out.println("Server closed.");
    }
}