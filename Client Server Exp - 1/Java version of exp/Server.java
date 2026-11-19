import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Thread-per-client TCP server.
 * Each connected client is handled independently by a ClientHandler thread.
 */
public class Server {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("[STARTED] Listening on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(
                        new ClientHandler(clientSocket),
                        "client-" + clientSocket.getPort());
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("[SERVER ERROR] " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String client = socket.getRemoteSocketAddress().toString();
            System.out.println("[CONNECTED] " + client);

            try (
                    Socket clientSocket = socket;
                    BufferedReader input = new BufferedReader(
                            new InputStreamReader(
                                    clientSocket.getInputStream(),
                                    StandardCharsets.UTF_8));
                    PrintWriter output = new PrintWriter(
                            clientSocket.getOutputStream(),
                            true,
                            StandardCharsets.UTF_8)) {
                String message;
                while ((message = input.readLine()) != null) {
                    if (message.equals("/quit")) {
                        output.println("Goodbye!");
                        break;
                    }

                    output.println("Server received: " + message);
                }
            } catch (IOException e) {
                System.err.println("[CLIENT ERROR] " + client + ": " + e.getMessage());
            } finally {
                System.out.println("[DISCONNECTED] " + client);
            }
        }
    }
}
