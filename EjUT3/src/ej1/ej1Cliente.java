package ej1;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.ServerSocket;

public class ej1Cliente{

    public static void main(String[] args){
        System.out.println("Creando socket cliente");
        Socket clientSocket = new Socket();
        System.out.println("Estableciendo conexi\u00F0n");
        InetSocketAddress addr = new InetSocketAddress("172.30.105.59",5555);
        clientSocket.connect(addr);
        
        InputStream is = clientSocket.getInputStream();
        OutputStream os = clientSocket.getOutputStream();

        BufferedReader keyboard = new BufferedReader(System.in);
        BufferedReader server = new BufferedReader(is);
        String in;
        do{
            System.out.println("Introduzca la cadena a enviar: ");
            in = keyboard.readLine();
            if(!in.equals("fin")){
                os.write(in.getBytes());
                System.out.printf("\nECO:: " + server.readLine() + "\n");
            }
        }while(!in.equals("fin"));
    }
}