package Java; /**
 * Created by icebotari on 9/29/2017.
 */
import Model.Worker;
import Service.HireDate;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HireDate test = new HireDate();
        Map<String, HashSet<Worker>> test3 = test.Sort(new HashMap<>(test.possibleCountries()));
        for(Map.Entry<String, HashSet<Worker>> entry : test3.entrySet()) {
            System.out.println("В " + entry.getKey() + " могут поехать:");
            for(Worker a : entry.getValue())
            {
                System.out.println(a.firstname + " " + a.lastName);
            }
            System.out.println("");
        }
    }
}