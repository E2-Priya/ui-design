package BASIC;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ADDClass extends UnicastRemoteObject implements ADDInterface {

	protected ADDClass() throws RemoteException {
		super();
	}

	@Override
	public double addc(int x, int y) throws RemoteException {

		return x + y;
	}

	public static void main(String args[]) throws RemoteException, MalformedURLException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(7777);
		registry.bind("add", new ADDClass());
		System.out.println("this is server");
	}

}
