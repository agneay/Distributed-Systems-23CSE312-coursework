"""Threaded TCP echo server: handles multiple clients concurrently."""

import socket
import threading

HOST = "127.0.0.1"
PORT = 5000
BUFFER_SIZE = 1024


def handle_client(conn: socket.socket, address) -> None:
    """Handle one client until it disconnects or sends /quit."""
    print(f"[CONNECTED] {address}")
    try:
        with conn:
            reader = conn.makefile("r", encoding="utf-8", newline="\\n")
            for line in reader:
                message = line.rstrip("\\r\\n")
                if message == "/quit":
                    conn.sendall(b"Goodbye!\\n")
                    break

                response = f"Server received: {message}\\n"
                conn.sendall(response.encode("utf-8"))
    except (ConnectionError, OSError) as exc:
        print(f"[ERROR] {address}: {exc}")
    finally:
        print(f"[DISCONNECTED] {address}")


def main() -> None:
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server.bind((HOST, PORT))
        server.listen()
        print(f"[STARTED] Listening on {HOST}:{PORT}")

        try:
            while True:
                conn, address = server.accept()
                thread = threading.Thread(
                    target=handle_client,
                    args=(conn, address),
                    daemon=True,
                )
                thread.start()
        except KeyboardInterrupt:
            print("\\n[STOPPING] Server shutting down.")


if __name__ == "__main__":
    main()
