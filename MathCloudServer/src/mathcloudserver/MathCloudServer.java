/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathcloudserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class MathCloudServer {
    private final static int PORT = 8000;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Servidor: Inicio.");
            System.out.println("Servidor: Esperando clientes...");
            
            Socket client;
            while (true) {                
                client=server.accept();
                System.out.println("Cliente: Conectado...");
                BufferedReader server_input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream server_output = new PrintStream(client.getOutputStream());
                
                String request = server_input.readLine();
                System.out.println(request);
                
                String result = process(request);
                server_output.flush();
                server_output.println(result);
                client.close();
            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static String process(String request){
        return "NULL";
    }
}
