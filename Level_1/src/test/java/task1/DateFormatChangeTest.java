package task1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatChangeTest {

    @Test
    void formatLocalDate() {
        LocalDate localDate =  LocalDate.of(2020, 12, 12);
        String expected = "20201212";
        String actual = DateFormatChange.formatLocalDate(localDate);
        assertEquals(expected, actual,"Date format does not match the pattern!");
    }

    @Test
    void patternChecking() {
        List<String> patterns = Arrays.asList(
                "[0-9]{2}/[0-9]{2}/[0-9]{4}",
                "[0-9]{4}/[0-9]{2}/[0-9]{2}",
                "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        String str = "2022/24/08";
        boolean expected = true;
        boolean actual = DateFormatChange.patternChecking(patterns,str);
        assertEquals(expected, actual,"The input data does not match the expected patterns!");
    }

    @Test
    void isNumericForCaseNull() {
        String str = "";
        boolean expected = false;
        boolean actual = DateFormatChange.isNumeric(str);
        assertEquals(expected, actual,"String might be empty or equal null!");
    }

    @Test
    void isNumeric() {
        String str = "2020-11-11";
        boolean expected = true;
        boolean actual = DateFormatChange.isNumeric(str.substring(0,4));
        assertEquals(expected, actual,"The first four elements of the string are numbers!");
    }

    @Test
    void invertDateForCaseNull() {
        List<String> patterns = Arrays.asList(
                "[0-9]{2}/[0-9]{2}/[0-9]{4}",
                "[0-9]{4}/[0-9]{2}/[0-9]{2}",
                "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        String str = "2022.11.11";
        LocalDate expected = null;
        LocalDate actual = DateFormatChange.invertDate(patterns, str);
        assertEquals(expected, actual,"Entered wrong date format!");
    }

    @Test
    void invertDateCase1() {
        List<String> patterns = Arrays.asList(
                "[0-9]{2}/[0-9]{2}/[0-9]{4}",
                "[0-9]{4}/[0-9]{2}/[0-9]{2}",
                "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        String str = "11-11-2012";
        LocalDate expected = LocalDate.of(2012,11,11);
        LocalDate actual = DateFormatChange.invertDate(patterns, str);
        assertEquals(expected, actual,"The entered date matches the patterns!");
    }

    @Test
    void invertDateCase2() {
        List<String> patterns = Arrays.asList(
                "[0-9]{2}/[0-9]{2}/[0-9]{4}",
                "[0-9]{4}/[0-9]{2}/[0-9]{2}",
                "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        String str = "2012/11/11";
        LocalDate expected = LocalDate.of(2012,11,11);
        LocalDate actual = DateFormatChange.invertDate(patterns, str);
        assertEquals(expected, actual,"The entered date matches the patterns!");
    }

    @Test
    void invertDateCase3() {
        List<String> patterns = Arrays.asList(
                "[0-9]{2}/[0-9]{2}/[0-9]{4}",
                "[0-9]{4}/[0-9]{2}/[0-9]{2}",
                "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        String str = "11/11/2012";
        LocalDate expected = LocalDate.of(2012,11,11);
        LocalDate actual = DateFormatChange.invertDate(patterns, str);
        assertEquals(expected, actual,"The entered date matches the patterns!");
    }

}