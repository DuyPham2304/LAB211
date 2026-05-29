/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tools;

/**
 *
 * @author ADMIN
 */
public interface Acceptable {
    public final String STU_ID_VALID = "^[CcDdHhSsQq][Ee]\\d{6}$";
    public final String NAME_VALID = "^.{2,20}$";
    public final String DOUBLE_VALID = "^\\d+(\\.\\d+)?$";
    public final String INTEGER_VALID = "^\\d+$";
    public final String VIETTEL_VALID = "^(032|033|034|035|036|037|038|039|096|097|098|086)\\d{7}$";
    public final String VNPT_VALID = "";
    public final String EMAIL_VALID = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,}$";
    public final String MOUNT_CODE = "^[Mm][Tt]\\d{2}$";
    
    public static boolean isValid(String data, String pattern){
        return data.matches(pattern);
    }
}
