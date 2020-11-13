import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Создать класс Календарь с внутренним классом, с помощью объектов которого
//можно хранить информацию о выходных и праздничных днях.

public class Calendar {
    PublicHolidays holidays = new PublicHolidays();

    public void newHolidays(String date, String description) {
        if(validateDate(date)) holidays.addHoliday(date, description);
        else System.out.println("Invalid format of date");
    }

    public void getHolidays() {
        holidays.printHolidays();
    }

    public void removeHoliday(String date) {
        if(validateDate(date)) holidays.deleteHoliday(date);
        else System.out.println("Invalid format of date");
    }

    private boolean validateDate(String date) {
        Pattern pattern = Pattern.compile("\\w+\\s{1}\\d{1,2}");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    static class PublicHolidays {
        private static Map<String, String> holidays_and_weekends = new TreeMap<>(String::compareTo);
        static {
            holidays_and_weekends.put("January 1", "New Year");
            holidays_and_weekends.put("January 7", "Christmas");
            holidays_and_weekends.put("March 8", "Women's day");
            holidays_and_weekends.put("April 25-April 28", "Radunitsa");
            holidays_and_weekends.put("May 1", "Labor day");
            holidays_and_weekends.put("May 9", "Victory Day");
            holidays_and_weekends.put("July 3", "Independence Day Of The Republic Of Belarus");
            holidays_and_weekends.put("November 7", "October revolution day");
            holidays_and_weekends.put("December 25", "Christmas");
        }

        private void addHoliday(String date, String description) {
            holidays_and_weekends.put(date, description);
        }

        private void printHolidays() {
            System.out.println("Public holidays and weekends:");
            for (Map.Entry<String,String> entry: holidays_and_weekends.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        private void deleteHoliday(String date) {
            holidays_and_weekends.keySet().removeIf(key -> key.equals(date));
        }

        private Map<String, String> getHolidays_and_weekends() {
            return holidays_and_weekends;
        }
    }
}
