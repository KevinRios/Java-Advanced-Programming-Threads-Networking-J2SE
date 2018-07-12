package ar.com.kevinrios.javaadv.clase01;

import java.time.LocalDateTime;

public class HiloHora implements Runnable{

    private Control control;

    public HiloHora(Control control) {
        this.control = control;
    }
    
    @Override
    public void run() {
        while(true){
            LocalDateTime ldt = LocalDateTime.now();
            String hora =     (ldt.getHour()<10) ? "0"+ldt.getHour():""+ldt.getHour();
            String minutos =  (ldt.getMinute()<10) ? "0"+ldt.getMinute():""+ldt.getMinute();
            String segundos = (ldt.getSecond()<10) ? "0"+ldt.getSecond():""+ldt.getSecond();
            
            control.setText(hora+":"+minutos+":"+segundos);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    
    }
    
}
