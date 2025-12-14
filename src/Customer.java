import javax.swing.*;
import java.awt.*;

public class Customer extends User{
    private static int id=50000000;
    public Customer(){
        super();
    }

    public static String idNumber() {
        String currentID="";
        int num=0;
        try {
            currentID = DBConnection.getID("Customer");
            if(currentID.equals(" ")){
                currentID=String.valueOf(id);
            }
            num= Integer.parseInt(currentID);
            num++;
        }catch(Exception e){
            e.getMessage();
        }
        return String.valueOf(num);
    }

    @Override
    public void validateAndSubmit() {
        String idno= String.valueOf(idNumber());
        super.validateAndSubmit();
        try {
            DBConnection.insertForRegister("Customer", idno, super.getFname(), super.getLname(), super.getPassword(), super.getEmail(), super.getTelno(), super.getAddress());
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
