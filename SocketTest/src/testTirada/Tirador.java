package testTirada;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.io.InputStream;

public class Tirador implements Runnable {

    private String IP;
    private int puerto = 5000;

    public Tirador(String IP) {
        this.IP = IP;
    }

    @Override
    public void run() {
        var i = 0;
        for (;;) {
            try {
                tirarServidor(puerto + i);
            } catch (Exception e) {
                i+=555;
                i %= 750;
                System.out.println(e.getMessage());
            }
        }
    }

    private void tirarServidor(int puerto) throws Exception {
        for (;;) {
            System.out.println("IP:" + IP + ":" + (puerto));
            Socket clientSocket = new Socket();
            InetSocketAddress addr = new InetSocketAddress(IP, puerto);
            clientSocket.connect(addr);
            OutputStream os = clientSocket.getOutputStream();
            os.write("BOOM".getBytes());
            throw new Exception("LULZ" + IP + ":" + puerto);
        }
        
    }

}