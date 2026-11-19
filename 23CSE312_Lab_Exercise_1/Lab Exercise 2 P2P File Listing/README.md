# Exercise 2 — Peer-to-Peer File Listing

## Run
1. Place real test files in the `SharedFiles` folder on Computer A.
2. On Computer A, run `python peer.py` (TCP port 5003).
3. On Computer B, run `python requester.py` and enter Computer A's IPv4 address.
4. The requester displays the actual files found in the shared folder. Add/remove files and request again to verify it is dynamic.

## Concepts
P2P-style resource request, TCP, dynamic filesystem listing.

## Network
Use the same LAN; allow port 5003 through firewall on private networks.
