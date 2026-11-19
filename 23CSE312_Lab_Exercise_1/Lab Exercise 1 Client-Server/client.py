import socket, threading

PORT = 5002

def receive_loop(sock):
    while True:
        try:
            data = sock.recv(4096)
            if not data: print("\\nServer disconnected."); break
            print("\\nServer:", data.decode().rstrip())
        except OSError: break

def main():
    ip = input("Server IP: ").strip()
    sock = socket.create_connection((ip, PORT))
    print("Connected. Type messages; /quit to exit.")
    threading.Thread(target=receive_loop, args=(sock,), daemon=True).start()
    try:
        while True:
            msg = input("Client> ")
            if msg == "/quit": break
            sock.sendall(msg.encode())
    finally:
        sock.close()

if __name__ == "__main__":
    main()
