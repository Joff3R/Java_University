package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server extends UnicastRemoteObject implements moder {

    public RMI_Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException {
        try {
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("hi serwer", new RMI_Server());
            System.out.println("serwer is ready");

        } catch (RemoteException e) {
            System.out.println("Exception" + e);
        }
    }

    @Override
    public int mode(int[] a, int n) throws RemoteException {
        int maxValue = 0, maxCount = 0, i, j;

        for (i = 0; i < n; ++i) {
            int count = 0;
            for (j = 0; j < n; ++j) {
                if (a[j] == a[i])
                    ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = a[i];
            }
        }
        return maxValue;
    }
}
