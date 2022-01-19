package datagramy;

import java.net.*;

public class Serwer {

    public static int sPort = 777;
    public static int kPort = 888;
    public static int bufferSize = 1024;
    public static DatagramSocket gniazdo;
    public static byte[] buffer = new byte[bufferSize];

    public static void main(String[] args) throws Exception {
        gniazdo = new DatagramSocket(sPort);
        Serw();

    }

    private static void Serw() throws Exception {

        System.out.println("SERWER");
        System.out.println("Host: " + InetAddress.getLocalHost());
        System.out.println("WIADOMOŚĆ:");
        int pos = 0;
        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("SERWER STOP");
                    return;

                case '\r':
                    break;

                case '\n':
                    gniazdo.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), kPort));
                    pos = 0;
                    break;

                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }
}
