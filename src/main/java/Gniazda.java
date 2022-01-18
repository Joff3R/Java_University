import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gniazda {

    /*
    1. Napisz program, wykorzystujący obsługę gniazd, który łączy się z portalami;
      www.wp.pl, www.ug.gda.pl, www. Onet.pl, www.interia.pl , na porcie 80
       i wyświetla adres ip strony internetowej, numer portu i portu lokalnego.
    */

    public static void displayNetworkInformation() {
        ArrayList<Socket> socketList = new ArrayList<>();

        try {
            socketList.add(new Socket("wp.pl", 80));
            socketList.add(new Socket("ug.edu.pl", 80));
            socketList.add(new Socket("onet.pl", 80));
            socketList.add(new Socket("interia.pl", 80));
        } catch (IOException e) {
            e.printStackTrace();
        }

        socketList.forEach(System.out::println);
    }

    /*
    2. Napisz program  wypisujący adres ip  i nazwę komputera lokalnego. Wykorzystaj obiekt INetAdress.
    */

    public static void displayLocalNetworkInformation () {
        InetAddress inetAddress = null;

        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        assert inetAddress != null;
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }

    /*
  3. Napisz program, który wyświetli adres IP przypisany do urządzenia sieciowego
  o nazwie przekazanej w postaci argumentu w wierszu poleceń.
   */
    public static void displayIpAddressOfGivenHost() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide domain name:");
        String host = scanner.nextLine();

        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(host);

        } catch (UnknownHostException e) {
            System.out.println("Unable to obtain an IP address for the host " + host);
            System.exit(0);
        }

        String ipAddress = inetAddress.getHostAddress();
        System.out.println("IP address of " + host + " is: " + ipAddress);
    }

    public static void main(String[] args) {
        displayIpAddressOfGivenHost();
        displayNetworkInformation();
        displayLocalNetworkInformation();
    }


}
