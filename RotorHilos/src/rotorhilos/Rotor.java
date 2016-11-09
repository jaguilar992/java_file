//package rotorhilos;
import java.io.*;
public class Rotor extends Thread {

	private int x;
	private int y;
	private float delay;
	private int dir;
	Console c;
	String [] fig = {"|","/","-","\\"};
	String [] fig_back = {"|","\\","-","/"};

	public Rotor(int x, int y,Console c,int dir, float delay){
		this.x=x;
		this.y=y;
		this.c =c;
		this.dir = dir;
		this.delay = delay;
	}

	@Override
	public void run(){
			int n=0;
			if (dir==1){
				   while (true){
				    c.gotoXY(x,y);
				    c.putString(fig[n%4]);
					n++;
					espera(this.delay);
					c.printScreen();				
				}
			}else{
				   while (true){
				    c.gotoXY(x,y);
				    c.putString(fig_back[n%4]);
					n++;
					espera(this.delay);
					c.printScreen();
			}

		   }

	}

	public static void espera(float segundos) {
        try {
            Thread.sleep((new Float (segundos * 1000.0)).longValue());
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}