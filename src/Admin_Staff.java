import javax.swing.*;
import java.awt.*;

public class Admin_Staff extends User{
    private static int id=10000000;
    public Admin_Staff(){
        super();
    }

    public static String idNumber() {
        String currentID="";
        int num=0;
        try {
            currentID = DBConnection.getID("Admin_staff");
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
            DBConnection.insertForRegister("Admin_Staff", idno, super.getFname(), super.getLname(), super.getPassword(), super.getEmail(), super.getTelno(), super.getAddress());
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
