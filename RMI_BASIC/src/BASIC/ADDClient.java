package BASIC;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ADDClient {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		System.out.println("inside client");

		ADDInterface addClient = (ADDInterface) Naming.lookup("rmi://localhost:7777/add");

		double n = addClient.addc(2, 2);
		System.out.println(n);
	}

}
