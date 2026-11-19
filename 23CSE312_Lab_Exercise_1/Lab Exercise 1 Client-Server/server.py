import socket, threading

HOST = "0.0.0.0"
PORT = 5002

def receive_loop(conn):
    while True:
        try:
            data = conn.recv(4096)
            if not data: print("\\nClient disconnected."); break
            print("\\nClient:", data.decode().rstrip())
        except OSError: break

def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        s.bind((HOST, PORT)); s.listen(1)
        print(f"Server listening on port {PORT}")
        conn, addr = s.accept()
        print("Connected:", addr)
        with conn:
            threading.Thread(target=receive_loop, args=(conn,), daemon=True).start()
            print("Type messages; /quit to exit.")
            while True:
                msg = input("Server> ")
                if msg == "/quit": break
                conn.sendall(msg.encode())
    print("Server closed.")

if __name__ == "__main__":
    main()
