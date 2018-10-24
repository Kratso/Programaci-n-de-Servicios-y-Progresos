/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciout1;

/**
 *
 * @author alumno
 */
public class Sumador {
	public static void main(String[] args){
		try{
			if(args.length != 2)
				throw new IllegalArgumentException();
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			System.out.println(sumador(n1,n2));
		}catch(NumberFormatException nfe){
			System.out.println("Argumentos inválidos");
		} catch(IllegalArgumentException iae){
			System.out.println("Argumentos inválidos");
		}
	}
	
	private static int sumador(int n1, int n2){
		int temp;
		if(n2 < n1){
			temp = n1;
			n1 = n2;
			n2 = temp;
		}
		temp = 0;
		for(int i = n1; i <= n2; i++)
			temp += i;
		return temp;
	}
}
