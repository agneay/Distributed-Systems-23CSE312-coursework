"""TCP client for the threaded Python server."""

import socket

HOST = "127.0.0.1"
PORT = 5000


def main() -> None:
    try:
        with socket.create_connection((HOST, PORT)) as sock:
            reader = sock.makefile("r", encoding="utf-8", newline="\\n")
            print(f"Connected to {HOST}:{PORT}")
            print("Type a message and press Enter. Type /quit to disconnect.")

            while True:
                message = input("> ")
                sock.sendall((message + "\\n").encode("utf-8"))

                response = reader.readline()
                if not response:
                    print("Server closed the connection.")
                    break

                print(response.rstrip("\\r\\n"))
                if message == "/quit":
                    break
    except (ConnectionError, OSError) as exc:
        print(f"Could not communicate with server: {exc}")


if __name__ == "__main__":
    main()
