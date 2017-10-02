package Model; /**
 * Created by icebotari on 9/29/2017.
 */
import java.util.ArrayList;
import java.util.List;

public class Worker {
    public String firstname;
    public String lastName;
    public int age;
    public List<String> listOfCountries = new ArrayList<>();


    public boolean readyForTrip;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + age; result = prime * result +
                ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (firstname != other.firstname)
            return false;
        if (lastName != other.lastName)
            return false;
        return true;

    }
    public Worker(String firstname, String lastName, int age, List<String> array){
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
        this.listOfCountries.addAll(array);

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<String> getListOfCountries() {
        return listOfCountries;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setListOfCountries(List<String> listOfCountries) {
        this.listOfCountries = listOfCountries;
    }
}