import socket, os, json

HOST = "0.0.0.0"
PORT = 5003
FOLDER = os.path.join(os.path.dirname(__file__), "SharedFiles")

def main():
    os.makedirs(FOLDER, exist_ok=True)
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        s.bind((HOST, PORT)); s.listen()
        print(f"Peer sharing folder: {FOLDER}")
        print(f"Listening on port {PORT}")
        while True:
            conn, addr = s.accept()
            with conn:
                request = conn.recv(1024).decode().strip()
                if request == "LIST":
                    files = sorted(f for f in os.listdir(FOLDER)
                                   if os.path.isfile(os.path.join(FOLDER, f)))
                    conn.sendall(json.dumps(files).encode())
                    print(f"Sent {len(files)} file(s) to {addr}")
                else:
                    conn.sendall(json.dumps({"error": "Send LIST"}).encode())

if __name__ == "__main__":
    main()
