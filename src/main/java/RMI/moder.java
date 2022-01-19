package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface moder extends Remote {
    int mode(int a[],int n)  throws RemoteException;
}
