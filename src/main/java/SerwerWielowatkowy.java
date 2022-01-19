//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//
//public class SerwerWielowatkowy {
//
//    public static void main(String[] args) {
//
//
//        ServerSocket serverSocket = null;
//        Socket socket = null;
//        BufferedReader brinp = null;
//        DataOutputStream out = null;
//        // OutputStream out;
//        // InputStream brinp;
//        try{
//            serverSocket = new ServerSocket(6667);
//        }
//        catch(IOException e){
//            System.out.println(  "Błąd przy tworzeniu gniazda serwerowego.");
//            System.exit(-1);
//        }
//        System.out.println("Inicjalizacja gniazda zakończona...");
//        System.out.println("Parametry gniazda: " + serverSocket);
//        try{
//            System.out.println("Trwa oczekiwanie na połączenie...");
//            socket = serverSocket.accept();
//        }
//        catch(IOException e){
//            System.out.println(e);
//            System.exit(-1);
//        }
//        System.out.println("Nadeszło połączenie...");
//        System.out.println("Parametry połączenia: " + socket);
//        try{
//            System.out.println("Inicjalizacja strumieni...");
//            brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out = new DataOutputStream(socket.getOutputStream());
//            // out = socket.getOutputStream();
//            // brinp= socket.getInputStream();
//        }
//        catch(IOException e){
//            System.out.println("Błąd przy tworzeniu strumieni.");
//
//            System.exit(-1);
//        }    System.out.println("Zakończona inicjalizacja strumieni...");
//
//        System.out.println("Rozpoczęcie pętli głównej...");
//        while(true){
//            try{
//                String line = brinp.readLine();
//
//                // int line = brinp.read();
//                System.out.println("Odczytano linię: " + line);
//                if(line == null || "quit".equals(line)){
//                    try{            socket.close();
//                        serverSocket.close();
//                    }
//                    catch(IOException e){
//                        System.out.println( "Błąd przy zamykaniu gniazda serwerowego.");
//                    }
//                    System.out.println("Zakończenie pracy...");
//                    System.exit(0);
//                }
//                String wynik[]=line.split(" ");
//
//                int a = Integer.parseInt(wynik[0]);
//                int b = Integer.parseInt(wynik[1]);
//                int c = a+b;
//                String line1 = Integer.toString(c);
//                out.writeBytes(line1 + "\n");
//                // out.write(line1 + "\n\r");
//                System.out.println("Wysłano linię: " + line1);
//
//            }
//            catch(IOException e){
//                System.out.println("Błąd wejścia-wyjścia.");
//                System.exit(-1);
//            }
//        }
//    }
//
//}
/////////////////////////////////////////////////////////////////////////////
//
//public class EchoServer {
//
//
//    public static void main(String[] args) {
//        // TODO code application logic here
//        ServerSocket serverSocket = null;
//        Socket socket = null;
//        try{
//            serverSocket = new ServerSocket(6666);
//        }
//        catch(IOException e){
//            System.out.println(   "Błąd przy tworzeniu gniazda serwerowego " + e);
//            System.exit(-1);
//        }
//        System.out.println("Inicjalizacja gniazda zakończona...");
//        System.out.println("Parametry gniazda: " + serverSocket);
//        while(true){
//            try{
//                socket = serverSocket.accept();
//            }      catch(IOException e){
//                System.out.println("Błąd wejścia-wyjścia: " + e);
//            }
//            System.out.println("Nadeszło połączenie...");
//            System.out.println("Parametry połączenia: " + socket);
//            new Thread(new EchoServerThread(socket)).start();
//        }
//    }
//
//    //////////////////////////////////////////////////////
//
//
//    /////////////////////////////////////////////////////////
//    public class EchoServerThread implements Runnable
//    {
//        protected Socket socket;
//
//        public EchoServerThread(Socket clientSocket)  {
//            this.socket = clientSocket;
//        }
//
//        public void run()  {
//            //deklaracje zmiennych
//            BufferedReader brinp = null;
//            DataOutputStream out = null;
//            String threadName = Thread.currentThread().getName();
//            //inicjalizacja strumieni
//            try{
//                brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                out = new DataOutputStream(socket.getOutputStream());
//            }
//            catch(IOException e){
//                System.out.println(threadName + "| Błąd przy tworzeniu strumieni " + e);
//                return;
//            }
//            String line = null;
//            //pętla główna
//            while(true){
//                try{
//                    line = brinp.readLine();
//                    System.out.println(threadName + "| Odczytano linię: " + line);
//                    //badanie warunku zakończenia pracy
//                    if((line == null) || "quit".equals(line)){
//                        System.out.println(threadName + "| Zakończenie pracy z klientem: " + socket);
//
//                        socket.close();
//                        return;
//                    }
//                    else{
////odesłanie danych do klienta
//                        out.writeBytes(line + "\n\r");
//                        System.out.println(threadName + "| Wysłano linię: " + line);
//                    }
//                }
//                catch(IOException e){
//                    System.out.println(threadName + "| Błąd wejścia-wyjścia." + e);
//                    return;
//                }
//            }
//        }
//
//    }
