package clase03;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMinimo {

    public static void main(String[] args) throws Exception {
        
        String mensaje = "Servidor de kevin!" ;
        //String mensaje = System.getProperties().toString();
        /*
        mensaje =  "HTTP/1.1 200 OK\n"
                +  "Content-Type: text/html\n"
                +  "Content-Lenght: " +mensaje.length()+"\n\n"
                + mensaje;
        */
        ServerSocket ss = new ServerSocket(4000,500);
        
        while(true){
            // se queda esperando a que alguien se coencte
            System.out.println("Esperando conexion de cliente");
            Socket soc = ss.accept();
            // getInetAddress me dice quien se conecto 
            System.out.println("Se conecto"+soc.getInetAddress());
            // envio byte a byte el msj al cliente
            OutputStream out = soc.getOutputStream();
           
            out.write(mensaje.getBytes());
            out.close();
            soc.close();
            System.out.println("Se cerro la conexion");
        }
        
    }

    
}
