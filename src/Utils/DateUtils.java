package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chanh Pham
 */
public class DateUtils {
    public String getDateNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        return String.valueOf(formatter.format(date));  
    }
    
    public String formatDate(Date date) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = DateFor.format(date);
        return stringDate;
    }
}