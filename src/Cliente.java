import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();
            String mensaje = "";
            int cont = 0;
            while (cont <= 10000) {
                mensaje = "Mensaje: " + cont;
                byte[] buffer = mensaje.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 42500);
                socket.send(packet);
                cont++;
            }
            mensaje = "FIN";
            byte[] buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 42500);
            socket.send(packet);


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}