package com.endava.main;

import com.endava.enums.Countries;
import com.endava.model.Worker;
import com.endava.service.WorkersUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        WorkersUtils workersUtils = new WorkersUtils();
        for (Map.Entry<Countries, Set <Worker>> entry : workersUtils.possibleCountries().entrySet()) {
            System.out.println("");
            System.out.println("В " + entry.getKey() + " могут поехать:");
            for(Worker a: entry.getValue()) {
                System.out.println(a.getFirstname() + " " + a.getLastName());
            }
        }
    }
}