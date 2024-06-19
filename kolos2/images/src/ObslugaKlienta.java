import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;




    public  class ObslugaKlienta implements Runnable {

        private Socket clientSocket;

        public ObslugaKlienta(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Utwórz strumień wyjściowy do wysyłania odpowiedzi klientowi
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Wyślij odpowiedź HTTP klientowi
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain");
                out.println();
                out.println("Hello World!");

                // Zamknij połączenie
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

