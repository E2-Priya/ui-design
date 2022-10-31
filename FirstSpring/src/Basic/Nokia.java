package Basic;

public class Nokia implements Phone {

	@Override
	public void call() {
		System.out.println("Calling using Nokia phone");

	}

	@Override
	public void message() {
		System.out.println("Messaging using Nokia phone");

	}

	@Override
	public void colour() {
		System.out.println("colour of Nokia phone is grey");

	}

}
