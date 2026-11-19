# Python TCP Client–Server

A simple TCP client–server application built with Python's standard `socket`
and `threading` modules. The server creates a separate thread for every
connected client, so multiple clients can communicate with it concurrently.

## Files

| File | Purpose |
|---|---|
| `server.py` | Accepts clients and handles each connection in its own thread |
| `client.py` | Connects to the server, sends messages and prints responses |

## Requirements

- Python 3.8 or later
- No third-party packages

## Run

Open a terminal in this directory and start the server:

```bash
python server.py
```

Open one or more additional terminals and start clients:

```bash
python client.py
```

Each client can send messages independently. The server replies with
`Server received: <message>`.

Type `/quit` in a client to disconnect that client. Stop the server with
`Ctrl+C`.

## Configuration

The defaults are:

```python
HOST = "127.0.0.1"
PORT = 5000
```

`127.0.0.1` allows connections from the same computer only. To accept
connections from other computers on a trusted local network, change the
server host to `0.0.0.0` and set the client's `HOST` to the server
computer's LAN IP address. Ensure the firewall permits TCP port `5000`.

## How it works

1. The server creates a TCP socket, binds it to the host and port, and listens.
2. Each call to `accept()` returns a client connection.
3. A daemon thread runs `handle_client()` for that connection.
4. Messages are UTF-8 text terminated by a newline (`\\n`).
5. The server responds on the same connection until the client disconnects
   or sends `/quit`.

## Notes

This is an educational example, not a production-ready service. It does not
include authentication, encryption (TLS), rate limiting, or message-size
limits. Do not expose it directly to the public internet.
