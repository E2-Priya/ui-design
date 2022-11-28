package BASIC;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ADDInterface extends Remote {
	public double addc(int x,int y) throws RemoteException;

}
