# IP Scanner

A LAN scanner written in plain Java, built step by step while I learn networking.

## Status
🚧 Work in progress. The subnet calculation part works; scanning is not implemented yet.

## What it does now
Takes an IPv4 address in CIDR notation as an argument and calculates the subnet
mask, network address, broadcast address, host range and host count using
bitwise operations. Invalid input is rejected with an explanatory message.

It then pings the first host of the network (usually the router) and reports
whether it responded.

Example output for `192.168.1.130/26`:

```
IP Address: 192.168.1.130   11000000101010000000000110000010
Subnet Mask: 255.255.255.192   11111111111111111111111111000000
Network: 192.168.1.128   11000000101010000000000110000000
Broadcast: 192.168.1.191   11000000101010000000000110111111
First host IP: 192.168.1.129
Last host IP: 192.168.1.190
Host capacity: 62
```

## Planned
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
java main 192.168.1.130/26
```

## Responsible use
Only scan networks that you own or have permission to test.

## Copyright
© 2026 Yağmur Erocağı. All rights reserved.

This code is shared for viewing purposes only. You may not copy, modify,
or distribute it without written permission.
