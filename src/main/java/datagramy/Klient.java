package datagramy;

import java.net.*;

public class Klient {

    public static int sPort = 777;
    public static int kPort = 888;
    public static int bufferSize = 1024;
    public static DatagramSocket gniazdo;
    public static byte[] buffer = new byte[bufferSize];

    public static void main(String[] args) throws Exception {
        gniazdo = new DatagramSocket(sPort);
        Klie();

    }

    private static void Klie() throws Exception {
        System.out.println("KLIENT");
        System.out.println("Host: " + InetAddress.getLocalHost());
        System.out.println("WIADOMOŚĆ:");

        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            gniazdo.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }
}
