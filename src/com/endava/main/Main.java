package com.endava.main;

import com.endava.model.Worker;
import com.endava.service.WorkersUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        WorkersUtils workersUtils = new WorkersUtils();
        Map<String, HashSet<Worker>> test3 = workersUtils.sortMap(new HashMap<>(workersUtils.possibleCountries()));
        for(Map.Entry<String, HashSet<Worker>> entry : test3.entrySet()) {
            System.out.println("В " + entry.getKey() + " могут поехать:");
            for(Worker a : entry.getValue())
            {
                System.out.println(a.getFirstname() + " " + a.getLastName());
            }
            System.out.println("");
        }
    }
}