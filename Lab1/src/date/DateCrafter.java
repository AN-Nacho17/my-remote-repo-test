/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 */
public class DateCrafter {

    private final String pattern; 
    private final SimpleDateFormat sdf; 
    private Calendar calendar;
    private String currentDate;

    public DateCrafter() {
        pattern = "dd-MM-yyyy - mm:ss:S";
        sdf = new SimpleDateFormat(pattern);
    }
    
    public String craft() {
        calendar = GregorianCalendar.getInstance();
        currentDate = sdf.format(calendar.getTime());
        return currentDate;
    }
    
    public String getDate() {
        return currentDate; 
    }
    
    

}
