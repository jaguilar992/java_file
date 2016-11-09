/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets_primerejercicio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Sockets_PrimerEjercicio {
    private final static int PORT = 80;
    private final static String SERVER = "www.google.com";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket socket;
        try{
            socket = new Socket(SERVER, PORT); 
            System.out.println("Conectado a: "+socket.getRemoteSocketAddress());
            BufferedReader socket_input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream socket_output = new PrintStream(socket.getOutputStream());
            
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Cliente > Escriba comando: ");
            String request = sc.next();
            socket_output.print(request);
            socket_output.print("\r\n\r\n");
            socket_output.flush();
            
            do {                
                System.out.println(socket_input.readLine());
            } while (socket_input.readLine()!=null);
            
        }catch(Exception e){
            System.err.println(e);
        }
        
        
    }
    
}
