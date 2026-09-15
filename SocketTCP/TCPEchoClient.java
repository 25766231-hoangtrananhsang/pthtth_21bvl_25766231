
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPEchoclient {
    public static final String serverIP = "127.0.0.1";
    public static final int serverPort = 1024;

    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket(serverIP, serverPort);
            System.out.println("Client da duoc tao");

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            for (int i = '0'; i <= '9'; i++) {
                os.write(i);
                int ch = is.read();
                System.out.println((char) ch);
                Thread.sleep(2000);
            }

        } catch (IOException ie) {
            System.out.println("Error: Can NOT create socket");
            ie.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
