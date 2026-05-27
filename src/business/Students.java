/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import tools.Inputter;

/**
 *
 * @author ADMIN
 */
public class Students extends ArrayList<Student> {

    final String HEADER_TABLE = String.format("|----------------------------------------------------------------------------------------------------------------|\n"
            + "| %-10s | %-20s | %-10s | %-25s | %-15s | %-15s |%n"
            + "|----------------------------------------------------------------------------------------------------------------|",
            "ID", "Name", "Phone", "Email", "Mountain Code", "tuition fee");
    final String FOOTER_TABLE = "|----------------------------------------------------------------------------------------------------------------|";

    String pathFile = "studentList.dat";
    Inputter ndl = new Inputter();
    boolean isSaved;

    public Students() {
    }

    public void addStudent(Student e) {
        for (Student i : this){
            if(i.getId().equals(e.getId())){
                System.out.println("This Student already exist in the system!");                
                return;
            }
        }
        this.add(e);
        this.isSaved = false;
    }  

    public void updateStudent(Student e){
        Student updateStu = ndl.enterStudentInfo(true);
        updateStu.setId(e.getId());
        this.set(indexOf(e), updateStu);
        System.out.println("updated succesfully!");
    }
    
    public Student searchById(String id){
        for(Student s : this){
            if(s.getId().equalsIgnoreCase(id)){
                return s;
            }
        }
        System.out.println("This Student hasn't registered yet!");
        return null;
    }
    
    public void searchByName(String name){
        for(Student i : this){
            if(i.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(i);
            }
        }
    }
    
    public void detele(String id){
        String choice;
        for(Student i : this){
            if(i.getId().equalsIgnoreCase(id)){
                displayStudent(i);
                choice = ndl.getString("Are you sure you want to delete this registration? (Y/N): ");
                switch (choice) {
                    case "Y":
                        this.remove(i);
                        System.out.println("The registration has been successfully deleted.");
                        return;
                    case "N":
                        return;
                }
            }
        }
        System.out.println("this Student hasn't registered yet!");
    }
    
    public void showAll() {
        showAll(this);
    }

    public void showAll(List<Student> l) {
        if (l.isEmpty()) {
            System.out.println("There are no students in the system!");
            return;
        }
        System.out.println(HEADER_TABLE);
        for (Student i : l) {
            System.out.printf(i.toString());
        }
        System.out.println(FOOTER_TABLE);
    }
    
    public List<Student> filterByCampusCode(String campusCode){
        Students rl = new Students();
        for(Student i : this){
            if(i.getId().substring(0, 2).equalsIgnoreCase(campusCode)){
                rl.addStudent(i);
            }
        }
        return rl;
    }
    
    public void displayStudent(Student s){
        System.out.println("--------------------------------------------------");
        System.out.println("Student ID: " + s.getId());
        System.out.println("Name      : " + s.getName());
        System.out.println("Phone     : " + s.getPhone());
        System.out.println("Mountain  : " + s.getMountainCode());
        System.out.println("Fee       : " + s.getTutionFee());
        System.out.println("--------------------------------------------------");
    }
    
    public void readFromFile(){
        FileInputStream fis = null;
        try {
            File f = new File(this.pathFile);
            if(!f.exists()){
                System.out.println("registration.dat file not found!");
                return;
            }
            fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while(fis.available()>0){
                Student x = (Student) ois.readObject();
                this.add(x);
            }
            ois.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex){
                Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveToFile() {
        if(this.isSaved){
            return;
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.pathFile))){
            for (Student i : this){
                oos.writeObject(i);
            }
            this.isSaved = true;
        } catch (IOException ex){
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
