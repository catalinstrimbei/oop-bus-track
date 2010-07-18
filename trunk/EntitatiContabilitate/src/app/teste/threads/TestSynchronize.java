package app.teste.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestSynchronize implements Runnable{

	List<String> obiectPartajabil = new ArrayList<String>();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new TestSynchronize());
		t1.setName("T1");
		Thread t2 = new Thread(new TestSynchronize());
		t2.setName("T2");
		
		t1.start();
		t2.start();
	}

	
	
	void accessObiectPartajabil(){
		synchronized(obiectPartajabil){
			
			System.out.println("Into processing sync block: " +
					Thread.currentThread().getName() + " detine blocaj pe " + obiectPartajabil + " ? "
					+ Thread.currentThread().holdsLock(obiectPartajabil));
			
			obiectPartajabil.add("Element adaugat din " + Thread.currentThread().getName() + " la " + (new Date()));
			try {
				Thread.currentThread().sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



	@Override
	public void run() {
		
		System.out.println("Before access: " +
				Thread.currentThread().getName() + " detine blocaj pe " + obiectPartajabil + " ? "
				+ Thread.currentThread().holdsLock(obiectPartajabil));
		
		accessObiectPartajabil();
		
		System.out.println("After access: " +
				Thread.currentThread().getName() + " detine blocaj pe " + obiectPartajabil + " ? "
				+ Thread.currentThread().holdsLock(obiectPartajabil));		
	}
}