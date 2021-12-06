package com.example.ibranyilevente_masodfoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Button btnSzamol;

    @FXML
    private TextArea taA, taB, taC;

    @FXML
    private Label lblXFirst, lblXSecond;

    public void kiszamol(ActionEvent actionEvent) {
        lblXFirst.setText("");
        lblXSecond.setText("");
        String a,b,c;
        double aInt, bInt, cInt;
        a = taA.getText();
        aInt = parseMethod(a);
        b = taB.getText();
        bInt = parseMethod(b);
        c = taC.getText();
        cInt = parseMethod(c);
        double diszk = diszkriminans(aInt, bInt, cInt);

        if (aInt != -1 && bInt != -1 && cInt != -1 && diszk != -1){
            double resz = Math.sqrt(diszk);
            double nevezo = 2 * aInt;
            double minusz = ((-1*bInt) - resz)/nevezo;
            double plussz = ((-1*bInt) + resz)/nevezo;

            if (minusz == plussz){
                lblXSecond.setText("");
                String eredmeny = String.format("x1 = x2 = %f", minusz);
                lblXFirst.setText(eredmeny);
            }else{
                String eredmenyFirst = String.format("x1 = %f", minusz);
                lblXFirst.setText(eredmenyFirst);
                String eredmenySecond = String.format("x2 = %f", plussz);
                lblXSecond.setText(eredmenySecond);
            }
        }
    }

    private double parseMethod(String bemeno){
        double intKi = 0;
        if (bemeno.equals("")){
            System.out.println("üres");
        }
        else{
            try {
                intKi = Double.parseDouble(bemeno);
            }catch (Exception ex){
                intKi = -1;
                lblXFirst.setText("Mindenhova csak számokat írhatsz!");
            }
        }
        return intKi;
    }

    private double diszkriminans(double a, double b, double c){
        double diszk = Math.pow(b,2) + (-4 * a * c);
        System.out.println(diszk);
        if (diszk < 0){
            lblXFirst.setText("Nem oldható meg a valós számok halmazán");
            diszk = -1;
        }
        return diszk;
    }

    //(-b+-gyokalatt(bˇ2 - 4ac))/2*a
}