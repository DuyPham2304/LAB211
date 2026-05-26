/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Scanner;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class Inputter {
    private Scanner sc;

    public Inputter() {
        this.sc = new Scanner(System.in);
    }
       
    public String getString(String mess){
        System.out.print(mess);
        return sc.nextLine();
    }
    
    public int getInt(String mess){
        int result = 0;
        String temp = getString(mess);
        if(Acceptable.isValid(temp, Acceptable.INTEGER_VALID)){
            result = Integer.parseInt(temp);
        }
        return result;
    }
    
    public double getDouble(String mess){
        double result = 0;
        String temp = getString(mess);
        if(Acceptable.isValid(temp, Acceptable.DOUBLE_VALID)){
            result = Double.parseDouble(temp);
        }
        return result;
    }
    
    public String inputAndLoop(String mess, String pattern){
        String result = "";
        boolean more = true;
        do {
            result = getString(mess);
            more = !Acceptable.isValid(result, pattern);
            if(more) System.out.println("Data is invalid!. Re-enter ...");
        } while(more);
        return result.trim();
    }
    
    public Student enterStudentInfo(boolean isUpdate){
        if(!isUpdate){
            String id = inputAndLoop("Enter id: ", Acceptable.STU_ID_VALID);
            String name = inputAndLoop("Enter name: ", Acceptable.NAME_VALID);
            String phone = inputAndLoop("Enter phone number: ", Acceptable.VIETTEL_VALID);
            String email = inputAndLoop("Enter email: ", Acceptable.EMAIL_VALID);
            String mountainCode = inputAndLoop("Enter mountain code: ", Acceptable.INTEGER_VALID);
            double tuitionFee = Double.parseDouble(inputAndLoop("Enter tuition fee: ", Acceptable.DOUBLE_VALID));
            return new Student(id, name, phone, email, mountainCode, tuitionFee);
        } 
        
        if(isUpdate){
            String name = inputAndLoop("Enter new name: ", Acceptable.NAME_VALID);
            String phone = inputAndLoop("Enter new phone number: ", Acceptable.VIETTEL_VALID);
            String email = inputAndLoop("Enter new email: ", Acceptable.EMAIL_VALID);
            String mountainCode = inputAndLoop("Enter new mountain code: ", Acceptable.INTEGER_VALID);
            double tuitionFee = Double.parseDouble(inputAndLoop("Enter new tuition fee: ", Acceptable.DOUBLE_VALID));
            return new Student(null, name, phone, email, mountainCode, tuitionFee);
        }
        return null;
    }
}
