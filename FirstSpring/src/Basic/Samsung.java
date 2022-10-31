package Basic;

public class Samsung implements Phone {

	@Override
	public void call() {
		System.out.println("Calling using Samsung phone");

	}

	@Override
	public void message() {
		System.out.println("Messaging using Samsung phone");

	}

	@Override
	public void colour() {
		System.out.println("colour of Samsung phone is black");

	}

}
