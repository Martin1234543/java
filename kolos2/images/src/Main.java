import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {


        public static void main(String[] args) throws IOException {
            // Utwórz gniazdo serwera i nasłuchuj połączeń na porcie 8080
            ServerSocket serverSocket = new ServerSocket(8080);

            // Oczekuj połączenia klienta
            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Utwórz nowy wątek, aby obsłużyć żądanie klienta
                Thread thread = new Thread(new ObslugaKlienta(clientSocket));
                thread.start();
            }
        }



}