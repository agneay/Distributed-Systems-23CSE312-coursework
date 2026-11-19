import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DsmClient {
    private static final int PORT = 5001;
    public static void main(String[] args) throws IOException {
        String host = args.length > 0 ? args[0] : prompt("DSM server IP: ");
        try (Socket socket = new Socket(host, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {
            out.println("GET");
            int current = Integer.parseInt(requireLine(in));
            System.out.println("Current shared counter: " + current);
            int updated = current + 1;
            out.println("SET " + updated);
            String result = requireLine(in);
            if (!result.startsWith("OK ")) throw new IOException("Server rejected update: " + result);
            System.out.println("Updated shared counter: " + result.substring(3));
            System.out.println("Incremented and written back.");
        }
    }
    private static String requireLine(BufferedReader in) throws IOException {
        String line = in.readLine(); if (line == null) throw new EOFException("Server closed the connection"); return line;
    }
    private static String prompt(String label) throws IOException { System.out.print(label); return new BufferedReader(new InputStreamReader(System.in)).readLine(); }
}