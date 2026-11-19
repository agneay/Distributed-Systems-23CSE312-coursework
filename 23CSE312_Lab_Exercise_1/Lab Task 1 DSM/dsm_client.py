import socket, json

SERVER_IP = input("DSM server IP: ").strip()
PORT = 5001

def request(sock, obj):
    sock.sendall(json.dumps(obj).encode())
    return json.loads(sock.recv(4096).decode())

with socket.create_connection((SERVER_IP, PORT)) as s:
    current = request(s, {"command": "GET"})["counter"]
    print("Current shared counter:", current)
    updated = current + 1
    result = request(s, {"command": "SET", "value": updated})
    print("Updated shared counter:", result["counter"])
    print("Incremented and written back.")
