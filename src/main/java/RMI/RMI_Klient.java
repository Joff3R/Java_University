package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Klient {

    public int[] a = {0, 4, 1, 7, 2, 1};
    public int n = 6;

    public static void main(String[] args) throws RemoteException {
        RMI_Klient c = new RMI_Klient();
        c.connectRemote();
    }

    private void connectRemote() {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            moder m = (moder) reg.lookup("hi serwer");
            System.out.println("wynik" + m.mode(a, n));
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }

    }

}
