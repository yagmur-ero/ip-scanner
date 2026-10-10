
public class main{
    public static void main(String[]args){
        String ip = "192.168.1.130/26"  ;
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

        System.out.println("IP Address: " + toDotted(bit) + "   " + Integer.toBinaryString(bit));
        System.out.println("Subnet Mask: " + toDotted(mask) + "   " + Integer.toBinaryString(mask));
        System.out.println("Network: " + toDotted(network) + "   " + Integer.toBinaryString(network));
        System.out.println("Broadcast: "+ toDotted(broadcast) + "   " + Integer.toBinaryString(broadcast));

    }
    static String toDotted (int x){
        int first = (x >>> 24) & 0xFF;
        int second = (x >>> 16) & 0xFF;
        int third = (x >>> 8) & 0xFF;
        int fourth = x & 0xFF;

        return (first + "." + second + "." + third + "." + fourth);  

    }
} 

