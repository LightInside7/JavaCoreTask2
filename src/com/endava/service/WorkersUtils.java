package com.endava.service;

import com.endava.enums.Countries;
import com.endava.model.Worker;

import java.time.LocalDateTime;
import java.util.*;

public class WorkersUtils {

    private static Map<LocalDateTime, Worker> hireAndWorkers = new HashMap<>();

    static {
        hireAndWorkers.put(LocalDateTime.now().plusDays(1), new Worker("Богдан", "Иванов", 20, Arrays.asList(Countries.MOLDOVA.getCountry(), Countries.GRECIA.getCountry(), Countries.ROMANIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(2), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA.getCountry(), Countries.ROMANIA.getCountry(), Countries.POLAND.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(3), new Worker("Иван", "Кузнецов", 24, Arrays.asList(Countries.ROMANIA.getCountry(), Countries.POLAND.getCountry(), Countries.RUSSIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(4), new Worker("Евгений", "Попов", 22, Arrays.asList(Countries.POLAND.getCountry(), Countries.RUSSIA.getCountry(), Countries.ITALIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(5), new Worker("Станислав", "Петров", 25, Arrays.asList(Countries.RUSSIA.getCountry(), Countries.ITALIA.getCountry(), Countries.USA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(6), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA.getCountry(), Countries.ROMANIA.getCountry(), Countries.POLAND.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(7), new Worker("Дмитрий", "Михайлов", 24, Arrays.asList(Countries.USA.getCountry(), Countries.GERMANY.getCountry(), Countries.LATVIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(8), new Worker("Артур", "Морозов", 22, Arrays.asList(Countries.GERMANY.getCountry(), Countries.LATVIA.getCountry(), Countries.LITVA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(9), new Worker("Сергей", "Алексеев", 20, Arrays.asList(Countries.LATVIA.getCountry(), Countries.LITVA.getCountry(), Countries.BOLGARIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(10), new Worker("Антон", "Семенов", 25, Arrays.asList(Countries.LITVA.getCountry(), Countries.BOLGARIA.getCountry(), Countries.MOLDOVA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(11), new Worker("Борис", "Николаев", 27, Arrays.asList(Countries.GERMANY.getCountry(), Countries.GRECIA.getCountry(), Countries.BOLGARIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(12), new Worker("Николай", "Орлов", 25, Arrays.asList(Countries.GERMANY.getCountry(), Countries.USA.getCountry(), Countries.RUSSIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(13), new Worker("Виктор", "Соловьев", 28, Arrays.asList(Countries.POLAND.getCountry(), Countries.GERMANY.getCountry(), Countries.ROMANIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(14), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA.getCountry(), Countries.ROMANIA.getCountry(), Countries.POLAND.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(15), new Worker("Генадий", "Яковлев", 23, Arrays.asList(Countries.GRECIA.getCountry(), Countries.BOLGARIA.getCountry(), Countries.MOLDOVA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(16), new Worker("Глеб", "Воробьев", 22, Arrays.asList(Countries.MOLDOVA.getCountry(), Countries.GERMANY.getCountry(), Countries.BOLGARIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(17), new Worker("Григорий", "Сорокин", 27, Arrays.asList(Countries.ROMANIA.getCountry(), Countries.RUSSIA.getCountry(), Countries.GERMANY.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(18), new Worker("Константин", "Королев", 24, Arrays.asList(Countries.USA.getCountry(), Countries.RUSSIA.getCountry(), Countries.ROMANIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(19), new Worker("Даниил", "Максимов", 25, Arrays.asList(Countries.LITVA.getCountry(), Countries.GERMANY.getCountry(), Countries.BOLGARIA.getCountry())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(20), new Worker("Денис", "Поляков", 22, Arrays.asList(Countries.ITALIA.getCountry(), Countries.ROMANIA.getCountry(), Countries.POLAND.getCountry())));
    }

    public Map sortMap (Map hireAndWorkers) {
        List list = new ArrayList(hireAndWorkers.entrySet());
        Collections.sort(list, (o1, o2) -> ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey()));
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    //№3
    private Set<Worker> workersReadyForTrip(LocalDateTime startDate, LocalDateTime endDate) {
        ArrayList<Worker> readyForTripWorkers = new ArrayList<>();
        for (Map.Entry<LocalDateTime, Worker> entry : hireAndWorkers.entrySet()) {
            if (startDate.isBefore(entry.getKey()) && endDate.isAfter(entry.getKey())) {
                readyForTripWorkers.add(entry.getValue());
            }
        }
        Set<Worker> finalSet = new HashSet<>(readyForTripWorkers);
        return finalSet;
    }

    private Set<Worker> canWorkerVisit(String country) {
        HashSet<Worker> ableToVisit = new HashSet<>();
        for (Map.Entry<LocalDateTime, Worker> entry : hireAndWorkers.entrySet()) {
            if (entry.getValue().getListOfCountries().contains(country)) {
                ableToVisit.add(entry.getValue());
            }
        }
        return ableToVisit;
    }

    public Map<String, Set<Worker>> possibleCountries(){
        Map<String, Set<Worker>> testing = new HashMap<>();
        Countries[] countrie = Countries.values();
        for(int i = 0; i < countrie.length; i++) {
            testing.put(countrie[i].toString(), (HashSet)canWorkerVisit(countrie[i].toString()));
        }
        Map<String, Set<Worker>> finalmap = Collections.unmodifiableMap(testing);
        return finalmap;
    }
}
