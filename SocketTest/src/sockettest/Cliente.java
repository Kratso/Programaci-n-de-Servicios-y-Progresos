package sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");
            Socket clientSocket = new Socket();
            System.out.println("Estableciendo conexi\u00F0n");
            InetSocketAddress addr = new InetSocketAddress("172.30.105.59",5555);
            clientSocket.connect(addr);
            
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            
            System.out.println("Enviando mensajes");
            
            int i = 0;
            String mensaje0 = "PRIMER MENSAJE";
            for(;;){
                i++;
                os.write(("Hola Mateo " + i + "\n").getBytes());

            }
            //os.write("ls".getBytes());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
