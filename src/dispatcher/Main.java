/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispatcher;

import business.Mountains;
import business.Statistics;
import business.Students;
import model.Mountain;
import tools.Acceptable;
import tools.Inputter;






/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Inputter ndl = new Inputter();
        Students rl = new Students();
        Mountains mt = new Mountains();
        Statistics st;
        rl.readFromFile();
        mt.readFromFile();
        do{
            System.out.println("1. New Registration\n" +
                               "2. Update Registration Information\n" +
                               "3. Display Registered List\n" +
                               "4. Delete Registration Information\n" +
                               "5. Search Participants by Name\n" +
                               "6. Filter Data by Campus\n" +
                               "7. Statistics of Registration Numbers by Location\n" +
                               "8. Save Data to File\n" +
                               "9. Exit the Program");
            choice = ndl.getInt("choice: ");
            
            switch (choice) {
                case 1:
                    rl.addStudent(ndl.enterStudentInfo(false));
                    break;
                case 2:
                    rl.updateStudent(rl.searchById(ndl.inputAndLoop("enter Student ID: ", Acceptable.STU_ID_VALID)));                   
                    break;
                case 3:
                    rl.showAll();
                    break;
                case 4:
                    rl.detele(ndl.inputAndLoop("Enter student id to delete: ", Acceptable.STU_ID_VALID));
                    break;
                case 5: 
                    rl.searchByName(ndl.inputAndLoop("Search by name: ", Acceptable.NAME_VALID));
                    break;
                case 6:
                    rl.showAll(rl.filterByCampusCode(ndl.getString("Enter CampusCode to search: ")));
                    break;
                case 7:
                    st = new Statistics(rl);
                    st.show();
                    break;
                case 9:
                    rl.saveToFile();
                    return;
            }
        }while(choice >= 1 && choice <= 9);
    }
}
