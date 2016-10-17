package com.julian;

class Contador{
	public static volatile int cuenta=0;
}

class Sumador extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			Contador.cuenta++;
		}
	}
}
class Restador extends Thread{
	public void run(){
		for(int i=0;i<500;i++){
			Contador.cuenta--;
		}
	}
}

public class HilosTestCondicionCarrera {

	public static void main(String[] args) throws InterruptedException {
		
		Sumador s = new Sumador();
		Restador r = new Restador();
		s.start();
		r.start();
		s.join();
		r.join();
		System.out.println("Constador vale finalmente: "+Contador.cuenta);
	}

}
