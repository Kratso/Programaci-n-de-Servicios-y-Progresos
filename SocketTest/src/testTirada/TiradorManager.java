package testTirada;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TiradorManager {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        int j = 104;

        List<String> IPs = Arrays.asList(new String[] { "172.30.104.59", "172.30.104.102", "172.30.104.137",
                "172.30.104.138", "172.30.104.139", "172.30.106.62", "172.30.106.69", "172.30.106.73", "172.30.106.91",
                "172.30.106.96", "172.30.106.132", "172.30.106.159", "172.30.106.161", "172.30.106.162",
                "172.30.106.217", "172.30.107.7", "172.30.107.18", "172.30.107.22", "172.30.107.166" });

        /*
         * String ipBase = "172.30.";
         * 
         * for (; j <= 105; j++) { for (int i = 1; i <= 254; i++) { IPs.add(ipBase + j +
         * "." + i); } }
         */
        IPs.forEach((s) -> {
            System.out.println("========" + s + "=======");
            threads.add(new Thread(new Tirador(s)));
        });

        threads.forEach((t) -> {
            t.start();
        });
    }
}