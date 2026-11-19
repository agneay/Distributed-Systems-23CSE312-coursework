import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DsmServer {
    private static final int PORT = 5001;
    private static int counter = 10;
    private static final Object LOCK = new Object();
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket()) {
            server.setReuseAddress(true); server.bind(new InetSocketAddress("0.0.0.0", PORT));
            System.out.println("DSM server: counter=" + counter);
            System.out.println("Listening on 0.0.0.0:" + PORT);
            while (true) {
                Socket socket = server.accept();
                Thread worker = new Thread(() -> handle(socket)); worker.setDaemon(true); worker.start();
            }
        }
    }
    private static void handle(Socket socket) {
        System.out.println("Connected: " + socket.getRemoteSocketAddress());
        try (socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {
            String request;
            while ((request = in.readLine()) != null) {
                String response;
                synchronized (LOCK) {
                    if (request.equals("GET")) response = Integer.toString(counter);
                    else if (request.startsWith("SET ")) {
                        try { counter = Integer.parseInt(request.substring(4).trim()); response = "OK " + counter; }
                        catch (NumberFormatException e) { response = "ERROR Invalid integer"; }
                    } else response = "ERROR Unknown command";
                }
                out.println(response);
            }
        } catch (IOException e) { System.err.println("Client connection error: " + e.getMessage()); }
        System.out.println("Disconnected: " + socket.getRemoteSocketAddress());
    }
}