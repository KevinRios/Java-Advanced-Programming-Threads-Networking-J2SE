package clase03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteMinimo {

    public static void main(String[] args) throws Exception{

         Socket soc = new Socket("localhost", 4000);
        //Socket soc = new Socket("10.11.1.90", 4000);
        /*
        InputStream in = soc.getInputStream();
        int car;
        while ((car = in.read())!= -1 ){            
            System.out.println((char)car);
        }
        */
        
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        System.out.println(in.readLine());
        System.out.println();
        
        in.close();
        soc.close();
        
        
        
    }
    
}
