Java equivalents for the supplied activity sheets

Requirements: JDK 11 or later. Each activity is independent and uses only the Java standard library.

Lab_Activity_1/Part_1 - Bidirectional TCP chat
1. Open two terminals in Part_1.
2. In terminal 1: javac ChatServer.java && java ChatServer
3. In terminal 2: javac ChatClient.java && java ChatClient <server-ip>
4. Type messages on either side. Enter /quit to end that side.

Lab_Activity_1/Part_2 - Peer-to-peer file listing
1. Put shareable files in Part_2/SharedFiles (provider creates it automatically).
2. In one terminal in Part_2: javac PeerProvider.java && java PeerProvider
3. In another terminal: javac FileRequester.java && java FileRequester <provider-ip>

Task_1/Part_1 - Distributed shared counter
1. In one terminal in Part_1: javac DsmServer.java && java DsmServer
2. In another terminal: javac DsmClient.java && java DsmClient <server-ip>
3. The server starts at 10. Each client run reads the shared value and increments it atomically.

Use localhost or 127.0.0.1 when both programs run on the same computer. For two computers,
use the server/provider computer's reachable IP address and allow the port through its firewall.
Ports: chat 5002, file listing 5003, DSM 5001.

TCP messages use UTF-8 lines. The DSM protocol uses GET / SET <integer> request lines;
the server serializes requests with a lock so concurrent increments are safe.
