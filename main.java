
import java.io.IOException;
import java.net.InetAddress;

public class main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Theres is no ip addresses i can check! Text something and try again");
            return;
        }
        String ip = args[0];
        String[] prefix = ip.split("/");
        if (!(prefix.length == 2)) {
            System.out.println("Please write the ip address with the prefix like this => 192.168.1.130/26");
            return;
        }
        String[] parts = prefix[0].split("\\.");
        if (!(parts.length == 4)) {
            System.out.println("There should be 3 dots on your ip address to separate 4 different parts.");
            return;
        }
        int prefixLength;

        try {
            prefixLength = Integer.parseInt(prefix[1]);
        } catch (NumberFormatException e) {
            System.out.println("The prefix must be a number!");
            return;

        }
        if (prefixLength < 0 || prefixLength > 32) {
            System.out.println("The prefix number should be between 0 and 32.");
            return;
        }

        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            try {
                nums[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                System.out.println("That is not a number");
                return;
            }
            if (nums[i] > 255 || nums[i] < 0) {
                System.out.println("The numbers you put for ip must be in between 0 and 255");
                return;
            }
        }
        int bit = (nums[0] << 24) | (nums[1] << 16) | (nums[2] << 8) | (nums[3]);
        int mask;
        if (prefixLength == 0) {
            mask = 0;
        } else {
            mask = (-1) << (32 - prefixLength);
        }

        int network = bit & mask;
        int broadcast = network | ~mask;

        int firstHost;
        int lastHost;
        long hostCount;
        if (prefixLength >= 31) {
            firstHost = network;
            lastHost = broadcast;
            hostCount = 1L << (32 - prefixLength);
        } else {
            firstHost = network + 1;
            lastHost = broadcast - 1;
            hostCount = (1L << (32 - prefixLength)) - 2;
        }

        System.out.println("IP Address: " + toDotted(bit) + "   " + Integer.toBinaryString(bit));
        System.out.println("Subnet Mask: " + toDotted(mask) + "   " + Integer.toBinaryString(mask));
        System.out.println("Network: " + toDotted(network) + "   " + Integer.toBinaryString(network));
        System.out.println("Broadcast: " + toDotted(broadcast) + "   " + Integer.toBinaryString(broadcast));
        System.out.println("First host IP: " + toDotted(firstHost));
        System.out.println("Last host IP: " + toDotted(lastHost));
        System.out.println("Host capacity: " + hostCount);

        String target = toDotted(firstHost);
        try {
            InetAddress address = InetAddress.getByName(target);
            boolean reachable = address.isReachable(1000);

            if (reachable) {
                System.out.println(target + " is reachable");
            } else {
                System.out.println(target + " didn't respond");
            }
        } catch (IOException e) {
            System.out.println("Couldn't check " + target);
        }

    }

    static String toDotted(int x) {
        int first = (x >>> 24) & 0xFF;
        int second = (x >>> 16) & 0xFF;
        int third = (x >>> 8) & 0xFF;
        int fourth = x & 0xFF;

        return (first + "." + second + "." + third + "." + fourth);

    }
}
