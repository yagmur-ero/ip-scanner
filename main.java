
public class main{
    public static void main(String[]args){
        if(args.length == 0){
            System.out.println("Theres is no ip addresses i can check! Text something and try again");
            return;
        }
        String ip = args[0] ;
        String[] prefix = ip.split("/");
        String[] parts = prefix[0].split("\\.");

        int prefixLength = Integer.parseInt(prefix[1]);  

        int [] nums=  new int[parts.length];

        for(int i = 0; i< parts.length; i++){
            nums[i] = Integer.parseInt(parts[i]);
        }
        int bit = (nums[0] << 24) | (nums[1] << 16) | (nums[2] << 8) | (nums[3]);
        int mask = (-1) << (32 - prefixLength);

        int network = bit & mask;
        int broadcast = network | ~mask;

        int firstHost = network + 1;
        int lastHost = broadcast - 1;
        int hostCount = (1 << (32 - prefixLength)) - 2;

        System.out.println("IP Address: " + toDotted(bit) + "   " + Integer.toBinaryString(bit));
        System.out.println("Subnet Mask: " + toDotted(mask) + "   " + Integer.toBinaryString(mask));
        System.out.println("Network: " + toDotted(network) + "   " + Integer.toBinaryString(network));
        System.out.println("Broadcast: "+ toDotted(broadcast) + "   " + Integer.toBinaryString(broadcast));
        System.out.println("First host IP: " + toDotted(firstHost));
        System.out.println("Last host IP: " + toDotted(lastHost));
        System.out.println("Host capacity: " + hostCount);

    }
    static String toDotted (int x){
        int first = (x >>> 24) & 0xFF;
        int second = (x >>> 16) & 0xFF;
        int third = (x >>> 8) & 0xFF;
        int fourth = x & 0xFF;

        return (first + "." + second + "." + third + "." + fourth);  

    }
} 

