package zoo;

public class Animal implements Runnable{

	String sound;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public Animal(String sound) {
		super();
		this.sound = sound;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println(sound);			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

}
