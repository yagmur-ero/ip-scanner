# IP Scanner

A LAN scanner written in plain Java, built step by step while I learn networking.

## Status
🚧 Work in progress. Subnet calculation and a basic ping scan work.

## What it does now
- Takes an IPv4 address in CIDR notation as an argument and calculates the
  subnet mask, network address, broadcast address, host range and host count
  using bitwise operations. `/31` and `/32` networks are handled as well.
- Rejects invalid input with an explanatory message.
- Pings every host in the network one by one and lists the ones that respond.
  Networks with more than 1024 hosts are not scanned.

For each value the program prints both the dotted form and the binary form,
followed by the list of hosts that responded and the number that did not.

Some devices, such as Windows computers with the firewall on, do not answer
ping, so a host that does not respond is not necessarily free.

## Planned
- Faster scanning with threads
- MAC address and vendor lookup
- Port scanning
- A report of risky open ports with recommendations

## How to run
Requires Java 17 or newer. Run it on Windows directly rather than in WSL,
because WSL sits behind its own virtual network and cannot see the LAN.

```bash
javac main.java
```

```bash
java main <ip-address>/<prefix>
```

Use your own IP address and the prefix that matches your subnet mask
(for example `/24` for `255.255.255.0`).

## Responsible use
Only scan networks that you own or have permission to test.

## Copyright
© 2026 Yağmur Erocağı. All rights reserved.

This code is shared for viewing purposes only. You may not copy, modify,
or distribute it without written permission.
