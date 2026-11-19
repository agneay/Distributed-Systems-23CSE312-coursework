# Lab Task 1 — Distributed Shared Memory (DSM) demo

**Purpose:** Simulate a shared integer hosted by one system and accessed remotely over TCP.

## Run
1. On host computer, run `python dsm_server.py` (TCP port 5001).
2. Find host IPv4 address (`ipconfig` on Windows).
3. On another computer, run `python dsm_client.py`, enter host IP.
4. Client reads counter, increments, writes back. Server maintains the shared state.

## Sample
Initial counter is 10. Client reads 10 and writes 11. A subsequent GET reads 11.

## Notes
This is a centralized DSM abstraction demo, not a full page-based DSM system. The server is the authoritative shared store. Use the same LAN and allow port 5001 through the firewall on a private network.
