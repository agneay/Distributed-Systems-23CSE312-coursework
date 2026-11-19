import socket, json

PORT = 5003
def main():
    ip = input("Peer IP: ").strip()
    with socket.create_connection((ip, PORT)) as s:
        s.sendall(b"LIST")
        data = s.recv(65536)
    files = json.loads(data.decode())
    print("\\nFiles available:")
    if not files:
        print("(folder is empty)")
    else:
        for i, name in enumerate(files, 1):
            print(f"{i}. {name}")
        print(f"\\n{len(files)} file(s) listed.")

if __name__ == "__main__":
    main()
