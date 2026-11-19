import socket, threading, json

HOST = "0.0.0.0"
PORT = 5001
counter = 10
lock = threading.Lock()

def handle(conn, addr):
    global counter
    print(f"Connected: {addr}")
    with conn:
        while True:
            raw = conn.recv(4096)
            if not raw: break
            try:
                req = json.loads(raw.decode())
                cmd = req.get("command")
                with lock:
                    if cmd == "GET":
                        result = {"counter": counter}
                    elif cmd == "SET":
                        counter = int(req["value"])
                        result = {"counter": counter, "message": "Updated"}
                    else:
                        result = {"error": "Unknown command"}
                conn.sendall(json.dumps(result).encode())
            except Exception as e:
                conn.sendall(json.dumps({"error": str(e)}).encode())
    print(f"Disconnected: {addr}")

def main():
    print(f"DSM server: counter={counter}")
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        s.bind((HOST, PORT)); s.listen()
        print(f"Listening on 0.0.0.0:{PORT}")
        while True:
            conn, addr = s.accept()
            threading.Thread(target=handle, args=(conn, addr), daemon=True).start()

if __name__ == "__main__":
    main()
