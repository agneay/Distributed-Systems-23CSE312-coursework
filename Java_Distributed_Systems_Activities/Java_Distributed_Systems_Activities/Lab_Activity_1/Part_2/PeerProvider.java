import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class PeerProvider {
    private static final int PORT = 5003;
    private static final Path FOLDER = Paths.get("SharedFiles");
    public static void main(String[] args) throws IOException {
        Files.createDirectories(FOLDER);
        try (ServerSocket server = new ServerSocket()) {
            server.setReuseAddress(true); server.bind(new InetSocketAddress("0.0.0.0", PORT));
            System.out.println("Peer sharing folder: " + FOLDER.toAbsolutePath());
            System.out.println("Listening on port " + PORT);
            while (true) try (Socket socket = server.accept();
                              BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                              PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {
                if ("LIST".equals(in.readLine())) {
                    List<String> names = new ArrayList<>();
                    try (var paths = Files.list(FOLDER)) { paths.filter(Files::isRegularFile).map(p -> p.getFileName().toString()).sorted().forEach(names::add); }
                    out.println(names.size());
                    for (String name : names) out.println(Base64.getEncoder().encodeToString(name.getBytes(StandardCharsets.UTF_8)));
                    System.out.println("Sent " + names.size() + " file(s) to " + socket.getRemoteSocketAddress());
                } else { out.println("ERROR"); }
            }
        }
    }
}