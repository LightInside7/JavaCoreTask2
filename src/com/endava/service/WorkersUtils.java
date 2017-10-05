package com.endava.service;

import com.endava.enums.Countries;
import com.endava.model.Worker;

import java.time.LocalDateTime;
import java.util.*;

public class WorkersUtils {

    public static Map<LocalDateTime, Worker> hireAndWorkers = new HashMap<>();

    static {
        hireAndWorkers.put(LocalDateTime.now().plusDays(1), new Worker("Богдан", "Иванов", 20, Arrays.asList(Countries.MOLDOVA, Countries.GRECIA, Countries.ROMANIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(2), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA, Countries.ROMANIA, Countries.POLAND)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(3), new Worker("Иван", "Кузнецов", 24, Arrays.asList(Countries.ROMANIA, Countries.POLAND, Countries.RUSSIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(4), new Worker("Евгений", "Попов", 22, Arrays.asList(Countries.POLAND, Countries.RUSSIA, Countries.ITALIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(5), new Worker("Станислав", "Петров", 25, Arrays.asList(Countries.RUSSIA, Countries.ITALIA, Countries.USA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(6), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA, Countries.ROMANIA, Countries.POLAND)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(7), new Worker("Дмитрий", "Михайлов", 24, Arrays.asList(Countries.USA, Countries.GERMANY, Countries.LATVIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(8), new Worker("Артур", "Морозов", 22, Arrays.asList(Countries.GERMANY, Countries.LATVIA, Countries.LITVA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(9), new Worker("Сергей", "Алексеев", 20, Arrays.asList(Countries.LATVIA, Countries.LITVA, Countries.BOLGARIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(10), new Worker("Антон", "Семенов", 25, Arrays.asList(Countries.LITVA, Countries.BOLGARIA, Countries.MOLDOVA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(11), new Worker("Борис", "Николаев", 27, Arrays.asList(Countries.GERMANY, Countries.GRECIA, Countries.BOLGARIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(12), new Worker("Николай", "Орлов", 25, Arrays.asList(Countries.GERMANY, Countries.USA, Countries.RUSSIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(13), new Worker("Виктор", "Соловьев", 28, Arrays.asList(Countries.POLAND, Countries.GERMANY, Countries.ROMANIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(14), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA, Countries.ROMANIA, Countries.POLAND)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(15), new Worker("Генадий", "Яковлев", 23, Arrays.asList(Countries.GRECIA, Countries.BOLGARIA, Countries.MOLDOVA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(16), new Worker("Глеб", "Воробьев", 22, Arrays.asList(Countries.MOLDOVA, Countries.GERMANY, Countries.BOLGARIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(17), new Worker("Григорий", "Сорокин", 27, Arrays.asList(Countries.ROMANIA, Countries.RUSSIA, Countries.GERMANY)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(18), new Worker("Константин", "Королев", 24, Arrays.asList(Countries.USA, Countries.RUSSIA, Countries.ROMANIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(19), new Worker("Даниил", "Максимов", 25, Arrays.asList(Countries.LITVA, Countries.GERMANY, Countries.BOLGARIA)));
        hireAndWorkers.put(LocalDateTime.now().plusDays(20), new Worker("Денис", "Поляков", 22, Arrays.asList(Countries.ITALIA, Countries.ROMANIA, Countries.POLAND)));
    }
    private Map<LocalDateTime, Worker> sortMap(Map<LocalDateTime, Worker> hireAndWorkers){
        Map<LocalDateTime, Worker> treeMap = new TreeMap<LocalDateTime, Worker> (hireAndWorkers);
        return treeMap;
    }

    private Set<Worker> workersReadyForTrip(LocalDateTime startDate, LocalDateTime endDate) {
        List<Worker> readyForTripWorkers = new ArrayList<>();
        for (Map.Entry<LocalDateTime, Worker> entry : hireAndWorkers.entrySet()) {
            if (startDate.isBefore(entry.getKey()) && endDate.isAfter(entry.getKey())) {
                readyForTripWorkers.add(entry.getValue());
            }
        }
        Set<Worker> finalSet = new HashSet<>(readyForTripWorkers);
        return finalSet;
    }

    private Set<Worker> canWorkerVisit(Countries country) {
        Set<Worker> ableToVisit = new HashSet<>();
        for (Map.Entry<LocalDateTime, Worker> entry : sortMap(hireAndWorkers).entrySet()) {
            if (entry.getValue().getListOfCountries().contains(country)){
                ableToVisit.add(entry.getValue());
            }
        }
        return ableToVisit;
    }

    public Map<Countries, Set<Worker>> possibleCountries() {
        Map<Countries, Set<Worker>> testing = new HashMap<>();
        for(Countries country : Countries.values()){
            testing.put(country, (HashSet) canWorkerVisit(country));
        }
        Map<Countries, Set<Worker>> finalmap = Collections.unmodifiableMap(testing);
        return finalmap;
    }
}
