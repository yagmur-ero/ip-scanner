# IP Scanner

A LAN scanner written in plain Java, built step by step while I learn networking.

## Status
🚧 Work in progress. The subnet calculation part works; scanning is not implemented yet.

## What it does now
Takes an IPv4 address in CIDR notation and calculates the subnet mask,
network address and broadcast address using bitwise operations.

The address is currently set in the code (`192.168.1.130/26`). The program prints
each value in dotted and binary form:

```
IP Address: 192.168.1.130   11000000101010000000000110000010
Subnet Mask: 255.255.255.192   11111111111111111111111111000000
Network: 192.168.1.128   11000000101010000000000110000000
Broadcast: 192.168.1.191   11000000101010000000000110111111
```

## Planned
- Host range and host count
- Device discovery on the local network
- MAC address and vendor lookup
- Port scanning
- A report of risky open ports with recommendations

## How to run
Requires Java 17 or newer.

```bash
javac main.java
```

```bash
java main
```

## Responsible use
Only scan networks that you own or have permission to test.

## Copyright
© 2026 Yağmur Erocağı. All rights reserved.

This code is shared for viewing purposes only. You may not copy, modify,
or distribute it without written permission.
