/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;
import model.Mountain;

/**
 *
 * @author ADMIN
 */
public class Mountains extends ArrayList<Mountain>{

    private String pathFile;
    
    public Mountains() {
    }
    
    public Mountain get(String mountainCode){
        for(Mountain i : this){
            if(i.getMountainCode().equalsIgnoreCase(mountainCode)){
                return i;
            }
        }
        return null;
    }
}
