import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KlientHTTP {

    public static void main(String[] args) throws IOException {
        // Utwórz gniazdo klienta i połącz się z serwerem na porcie 8080
        Socket clientSocket = new Socket("localhost", 8080);

        // Utwórz strumień wejściowy do odczytywania odpowiedzi serwera
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Odczytaj odpowiedź serwera
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        // Zamknij połączenie
        clientSocket.close();
    }
}
