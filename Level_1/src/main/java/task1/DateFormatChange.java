package task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateFormatChange {

    public final static DateTimeFormatter DAY_MONTH_YEAR = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String formatLocalDate(LocalDate localDate) {
        return localDate.format(DAY_MONTH_YEAR);

    }

    public static boolean patternChecking(List<String> patterns, String strDate) {
        return patterns.stream().anyMatch(strDate::matches);
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ignored) {
        }
        return false;
    }

    public static LocalDate invertDate(List<String> patterns, String strDate){
        if (!DateFormatChange.patternChecking(patterns,strDate)) {
            return null;
        }
        LocalDate date;
        if (strDate.contains("-")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            date = LocalDate.parse(strDate, dtf);
        } else {
            if (isNumeric(strDate.substring(0, 4))) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                date = LocalDate.parse(strDate, dtf);
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(strDate, dtf);
            }
        }
        return date;
    }

}
