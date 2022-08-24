package task2;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondTask{

        public static String getFirstUniqueStringInList(List<String> list) {
            String str = "";
            Boolean isUnique = false;
            Map<String, Long> countMap = list.stream()
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            for (String s : list) {
                if (countMap.get(s) == 1) {
                    isUnique = true;
                    str = "The first unique name is " + "\"" + s + "\"";
                    break;
                }
            }
            if (!isUnique) {
                str = "There are no unique names";
            }
            return str;
        }

}

