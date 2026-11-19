import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FileRequester {
    private static final int PORT = 5003;
    public static void main(String[] args) throws IOException {
        String host = args.length > 0 ? args[0] : prompt("Peer IP: ");
        try (Socket socket = new Socket(host, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {
            out.println("LIST");
            String countLine = in.readLine();
            if (countLine == null || countLine.equals("ERROR")) throw new IOException("Peer returned an invalid response");
            int count = Integer.parseInt(countLine);
            System.out.println("\nFiles available:");
            if (count == 0) System.out.println("(folder is empty)");
            for (int i = 1; i <= count; i++) {
                String encoded = in.readLine();
                if (encoded == null) throw new EOFException("Incomplete file list");
                String name = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
                System.out.println(i + ". " + name);
            }
            System.out.println("\n" + count + " file(s) listed.");
        }
    }
    private static String prompt(String label) throws IOException { System.out.print(label); return new BufferedReader(new InputStreamReader(System.in)).readLine(); }
}