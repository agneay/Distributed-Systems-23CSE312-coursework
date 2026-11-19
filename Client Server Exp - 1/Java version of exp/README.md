# Java TCP Client–Server

A multi-client TCP application using Java's `ServerSocket`, `Socket` and
threads. The server starts a dedicated handler thread for every client
connection, allowing several clients to exchange messages concurrently.

## Files

| File | Purpose |
|---|---|
| `Server.java` | Listens for connections and starts a handler thread per client |
| `Client.java` | Connects to the server and exchanges messages interactively |

## Requirements

- JDK 11 or later
- No external libraries

## Compile

Open a terminal in this directory:

```bash
javac Server.java Client.java
```

## Run

Start the server in one terminal:

```bash
java Server
```

Open one or more additional terminals and run:

```bash
java Client
```

Each client can send messages independently. The server replies with
`Server received: <message>`.

Type `/quit` in a client to disconnect that client. Stop the server with
`Ctrl+C`.

## Configuration

The default server port is `5000`. The client connects to `127.0.0.1`.
To allow other computers on a trusted local network to connect, keep the
server bound to all interfaces (the `ServerSocket` constructor does this
by default) and change `HOST` in `Client.java` to the server computer's
LAN IP address. Ensure the firewall permits TCP port `5000`.

## How it works

1. `ServerSocket` listens for incoming TCP connections.
2. `accept()` returns a new `Socket` for each client.
3. A new `ClientHandler` thread manages each socket.
4. The client and server exchange UTF-8, newline-delimited text.
5. A client can disconnect by sending `/quit` or closing its connection.

## Notes

This is an educational example, not a production-ready service. It does
not include authentication, TLS encryption, rate limiting, or message-size
limits. Do not expose it directly to the public internet.
