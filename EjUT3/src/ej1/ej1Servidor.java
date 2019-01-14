package ej1;

import java.io.PrintWriter;


import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.InetSocketAddress;

public class ej1Servidor{

    public static void main(String[] args){
        try {
            System.out.println ("Creaci\u00F0n del socket servidor");
            ServerSocket serverSocket = new ServerSocket();
            System.out.println ("Realizaci\u00F0n del bind");
            InetSocketAddress iSA = new InetSocketAddress("localhost",5555);
            serverSocket.bind(iSA);
            System.out.println ("Espera a que llegue una petici\u00F0n de socket");
            Socket socket = serverSocket.accept();
            System.out.println ("Se ha establecido la conexión");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(os);
            String linea = br.readLine();
            while (linea!=null){
                System.out.println("Recibido: *" + linea + "*");
                pw.printf(linea);
                linea = br.readLine();
            }
            
            System.out.println("Cerrando el socket de comunicación");
            socket.close();
            System.out.println("Cerrando el socket servidor");
            serverSocket.close();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

}