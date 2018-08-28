package clase03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMinimo2 implements Runnable {

    public static void main(String[] args) {
        new Thread(new ServidorMinimo2()).start();
    }

    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(5000)) {
            while (true) {
                System.out.println("Esperando conexion de cliente.");

                try (Socket soc = ss.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    ){
                    System.out.println("Se conecto"+ soc.getInetAddress());
                    System.out.println(in.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    } // end method run 

} // end class ServidoMinimo2
