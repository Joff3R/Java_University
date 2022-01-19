import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class GniazdaSerwerowe {

    //println(socket) -> wyświetlenie danych gniazdka klienckiego

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader brinp = null; //reading from file
        DataOutputStream out = null; //writing to file
        try {
            serverSocket = new ServerSocket(6666); //tworzenie socketa serwerowego
            System.out.println("Parametry gniazda: " + serverSocket);

        } catch (IOException e) {
            System.out.println("Błąd przy tworzeniu gniazda serwerowego.");
            System.exit(-1);
        }
        System.out.println("Inicjalizacja gniazda zakończona...");
        try {
            System.out.println("Trwa oczekiwanie na połączenie...");
            socket = serverSocket.accept(); //akceptowanie socketa klienta

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Nadeszło połączenie...");
        try {
            System.out.println("Inicjalizacja strumieni...");
            brinp = new BufferedReader(new InputStreamReader(socket.getInputStream())); //reading input data from client socket and opening reader on them
            out = new DataOutputStream(socket.getOutputStream()); //reading output data from client socket and opening writer on them
        } catch (IOException e) {
            System.out.println("Błąd przy tworzeniu strumieni.");
            System.exit(-1);
        }
        System.out.println("Zakończona inicjalizacja strumieni...");
        while (true) {
            System.out.println("Rozpoczęcie pętli głównej...");
            try {
                String line = brinp.readLine(); //read line of input data
                System.out.println("Odczytano linię: " + line);
                if(line == null || "quit".equals(line)) {
                    try {
                        socket.close(); //client socket close
                        serverSocket.close(); //server socket close
                    } catch (IOException e) {
                        System.out.println("Błąd przy zamykaniu gniazd.");
                    }
                    System.out.println("Zakończenie pracy...");
                    System.exit(0);
                }
                out.writeBytes(line + "\n\r");
                System.out.println("Wysłano linię: " + line);
            } catch (IOException e) {
                System.out.println("Błąd wejścia-wyjścia.");
                System.exit(-1);
            }
        }
    }
}
