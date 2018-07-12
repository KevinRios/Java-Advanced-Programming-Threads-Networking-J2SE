package ar.com.kevinrios.javaadv.clase01;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Control {
    private JTextField  swTxt=null;
    private JLabel      swLbl=null;
    private TextField   fxTxt=null;
    private Label       fxLbl=null;
    public Control(JTextField swTxt)    { this.swTxt = swTxt; }
    public Control(JLabel swLbl)        { this.swLbl = swLbl; }
    public Control(TextField fxTxt)     { this.fxTxt = fxTxt; }
    public Control(Label fxLbl)         { this.fxLbl = fxLbl; }
    public void setText(String text){
        if(swTxt!=null) swTxt.setText(text);
        if(swLbl!=null) swLbl.setText(text);
        if(fxTxt!=null) fxTxt.setText(text);
        if(fxLbl!=null) fxLbl.setText(text);
    }
    public String getText(){
        if(swTxt!=null) return swTxt.getText();
        if(swLbl!=null) return swLbl.getText();
        if(fxTxt!=null) return fxTxt.getText();
        if(fxLbl!=null) return fxLbl.getText();
        return null;
    }
}
