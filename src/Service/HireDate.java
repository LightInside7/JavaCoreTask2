package Service;

import Enums.Countries;
import Model.Worker;

import java.time.LocalDateTime;
import java.util.*;


public class HireDate {

    public static Map<LocalDateTime, Worker> hireAndWorkers = new HashMap<>();


    static {
        hireAndWorkers.put(LocalDateTime.now().plusDays(1), new Worker("Богдан", "Иванов", 20, Arrays.asList(Countries.MOLDOVA.name(), Countries.GRECIA.name(), Countries.ROMANIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(2), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA.name(), Countries.ROMANIA.name(), Countries.POLAND.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(3), new Worker("Иван", "Кузнецов", 24, Arrays.asList(Countries.ROMANIA.name(), Countries.POLAND.name(), Countries.RUSSIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(4), new Worker("Евгений", "Попов", 22, Arrays.asList(Countries.POLAND.name(), Countries.RUSSIA.name(), Countries.ITALIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(5), new Worker("Станислав", "Петров", 25, Arrays.asList(Countries.RUSSIA.name(), Countries.ITALIA.name(), Countries.USA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(6), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA.name(), Countries.ROMANIA.name(), Countries.POLAND.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(7), new Worker("Дмитрий", "Михайлов", 24, Arrays.asList(Countries.USA.name(), Countries.GERMANY.name(), Countries.LATVIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(8), new Worker("Артур", "Морозов", 22, Arrays.asList(Countries.GERMANY.name(), Countries.LATVIA.name(), Countries.LITVA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(9), new Worker("Сергей", "Алексеев", 20, Arrays.asList(Countries.LATVIA.name(), Countries.LITVA.name(), Countries.BOLGARIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(10), new Worker("Антон", "Семенов", 25, Arrays.asList(Countries.LITVA.name(), Countries.BOLGARIA.name(), Countries.MOLDOVA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(11), new Worker("Борис", "Николаев", 27, Arrays.asList(Countries.GERMANY.name(), Countries.GRECIA.name(), Countries.BOLGARIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(12), new Worker("Николай", "Орлов", 25, Arrays.asList(Countries.GERMANY.name(), Countries.USA.name(), Countries.RUSSIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(13), new Worker("Виктор", "Соловьев", 28, Arrays.asList(Countries.POLAND.name(), Countries.GERMANY.name(), Countries.ROMANIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(14), new Worker("Илья", "Смирнов", 21, Arrays.asList(Countries.GRECIA.name(), Countries.ROMANIA.name(), Countries.POLAND.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(15), new Worker("Генадий", "Яковлев", 23, Arrays.asList(Countries.GRECIA.name(), Countries.BOLGARIA.name(), Countries.MOLDOVA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(16), new Worker("Глеб", "Воробьев", 22, Arrays.asList(Countries.MOLDOVA.name(), Countries.GERMANY.name(), Countries.BOLGARIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(17), new Worker("Григорий", "Сорокин", 27, Arrays.asList(Countries.ROMANIA.name(), Countries.RUSSIA.name(), Countries.GERMANY.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(18), new Worker("Константин", "Королев", 24, Arrays.asList(Countries.USA.name(), Countries.RUSSIA.name(), Countries.ROMANIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(19), new Worker("Даниил", "Максимов", 25, Arrays.asList(Countries.LITVA.name(), Countries.GERMANY.name(), Countries.BOLGARIA.name())));
        hireAndWorkers.put(LocalDateTime.now().plusDays(20), new Worker("Денис", "Поляков", 22, Arrays.asList(Countries.ITALIA.name(), Countries.ROMANIA.name(), Countries.POLAND.name())));

    }


    public HashMap Sort(HashMap hireAndWorkers) {
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
    private HashSet<Worker> workersReadyForTrip(LocalDateTime startDate, LocalDateTime endDate) {
        ArrayList<Worker> readyForTripWorkers = new ArrayList<>();
        for (HashMap.Entry<LocalDateTime, Worker> entry : hireAndWorkers.entrySet()) {
            if (startDate.isBefore(entry.getKey()) && endDate.isAfter(entry.getKey())) {
                readyForTripWorkers.add(entry.getValue());
            }
        }
        HashSet<Worker> finalSet = new HashSet<>(readyForTripWorkers);
        return finalSet;
    }

    private HashSet<Worker> canWorkerVisit(String country) {
        HashSet<Worker> tmpList = new HashSet<>();
        for (HashMap.Entry<LocalDateTime, Worker> entry : hireAndWorkers.entrySet()) {
            if (entry.getValue().listOfCountries.contains(country)) {
                tmpList.add(entry.getValue());
            }
        }
        return tmpList;
    }

    public Map<String, HashSet<Worker>>  possibleCountries(){
        Map<String, HashSet<Worker>> testing = new HashMap<>();
        HashSet<Worker> workersList = new HashSet<>();
        Countries[] countrie = Countries.values();
        for(int i = 0; i < countrie.length; i++)
        {

            testing.put(countrie[i].toString(), canWorkerVisit(countrie[i].toString()));
        }
        Map<String, HashSet<Worker>> finalmap = Collections.unmodifiableMap(testing);
        return finalmap;
    }

}
