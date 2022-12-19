import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeManagment {
    String untildate="2020-01-01";//can take any date in current format
    SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
    Calendar cal = Calendar.getInstance();
    public TimeManagment() {
        try {
            cal.setTime( dateFormat.parse(untildate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public void nextDay() {
        cal.add( Calendar.DATE, 1 );
    }
    public int getGameDay() {
       return cal.get(Calendar.DAY_OF_MONTH);
    }
    public int getGameMonth() {
        return cal.get(Calendar.MONTH)+1;
    }
    public int getGameYear() {
        return cal.get(Calendar.YEAR);
    }
}
