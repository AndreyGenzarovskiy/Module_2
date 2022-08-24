package task2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecondTaskTest {

    @Test
    void getFirstUniqueStringTrueCase() {
        List<String> list = Arrays.asList("Kiev", "Kharkov", "Odessa", "Kharkov", "Kiev");
        String expected = "The first unique name is \"Odessa\"";
        String actual = SecondTask.getFirstUniqueStringInList(list);
        assertEquals(expected, actual, "");
    }

    @Test
    void getFirstUniqueStringFalseCase() {
        List<String> list = Arrays.asList("Kiev", "Kharkov", "Odessa", "Odessa", "Kharkov", "Kiev");
        String expected = "There are no unique names";
        String actual = SecondTask.getFirstUniqueStringInList(list);
        assertEquals(expected, actual);
    }

}