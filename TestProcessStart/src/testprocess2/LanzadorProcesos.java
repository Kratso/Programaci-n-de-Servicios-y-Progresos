/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprocess2;

public class LanzadorProcesos {
 public void ejecutar(String ruta){
 ProcessBuilder pb;
 try {
 pb = new ProcessBuilder(ruta);
 pb.start();
 } catch (Exception e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }
 /**
 * @param args
 */
 public static void main(String[] args) {
 LanzadorProcesos lp=new LanzadorProcesos();
 lp.ejecutar("thunar");
 System.out.println("Finalizado");
 }
}