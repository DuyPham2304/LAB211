/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mountain;

/**
 *
 * @author ADMIN
 */
public class Mountains extends ArrayList<Mountain> {

    private String pathFile = "MountainList.csv";

    public Mountains() {
    }

    public Mountain get(String mountainCode) {
        for (Mountain i : this) {
            if (i.getMountainCode().equalsIgnoreCase(mountainCode)) {
                return i;
            }
        }
        return null;
    }

    public boolean isValidMountainCode(String mountainCode) {
        for (Mountain i : this) {
            if (i.getMountainCode().equalsIgnoreCase(mountainCode)) {
                return true;
            }
        }
        return false;
    }

    public Mountain dataToObject(String text) {
        String[] data = text.split(",");
        return new Mountain(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
    }

    public void readFromFile() {
        FileReader fr = null;
        try {
            File f = new File(pathFile);

            if (!f.exists()) {
                System.out.println("MountainList.csv file not found !");
                return;
            }

            fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String temp = "";

            while ((temp = br.readLine()) != null) {
                Mountain i = dataToObject(temp);
                if (i != null) {
                    this.add(i);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
