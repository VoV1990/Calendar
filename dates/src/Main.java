import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Calendar calendar = new Calendar();
        chooseOption(calendar);
    }

    private static void chooseOption(Calendar calendar) throws IOException {
        boolean stop = false;
        int option = 0;
        do{
            System.out.println("Please make a choice:");
            System.out.println("1. View public holidays.");
            System.out.println("2. Add new public holidays.");
            System.out.println("3. Delete public holiday.");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option >= 1 && option <= 3) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        doIt(option, calendar);
    }

    private static void doIt(int option, Calendar calendar) throws IOException {
        switch (option) {
            case 1 -> calendar.getHolidays();
            case 2 -> {
                System.out.println("Please enter date in the correct format (e.g. January 1) then enter " +
                        "description of holiday:");
                String date = reader.readLine();
                String description = reader.readLine();
                calendar.newHolidays(date, description);
                calendar.getHolidays();
            }
            case 3 -> {
                System.out.println("Please enter date in the correct format (e.g. January 1) that you " +
                        "want to delete:");
                String date = reader.readLine();
                calendar.removeHoliday(date);
                calendar.getHolidays();
            }
        }
    }
}
