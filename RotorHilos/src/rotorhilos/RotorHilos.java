//package rotorhilos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package rotorhilos;

/**
 *
 * @author Antonio
 */
public class RotorHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
        Console c = new Console();
        c.clearScreen();
        Rotor r1 = new Rotor(0,0,c,1,0.8f);
        Rotor r2 = new Rotor(20,1,c,-1,0.8f);
        Rotor r5 = new Rotor(12,2,c,1,0.9f);
        Rotor r3 = new Rotor(25,3,c,-1,0.7f);
        Rotor r4 = new Rotor(32,4,c,1,1.5f);

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
//	while(true){
//		c.printScreen();
//		Rotor.espera(0.5f);
//	}
        // r3.start();
}
}