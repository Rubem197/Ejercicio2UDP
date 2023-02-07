import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(42500);
            byte[] buffer = new byte[64];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            String mensajeRecibido = "";
            while (!mensajeRecibido.contains("FIN")) {
                socket.receive(packet);
                mensajeRecibido =  new String(packet.getData());
                String[] mensajeDividido =mensajeRecibido.split(":");
                insertarEnFichero(mensajeDividido[1].trim());
            }


        }catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertarEnFichero(String mensaje){
        try {
            String filePath = "C:\\Users\\ruben\\Desktop\\demo.txt";
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mensaje);
            bw.newLine();
            bw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}