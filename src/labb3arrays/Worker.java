package labb3arrays;

public class Worker {

    private String firstName;
    private String lastName;
    private String dateOfBitrh;
    private double salary;
   private int workerID = 0;
   
    private static int counter = 1;
    public Worker(String firstName, String lastName, String age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBitrh = age;
        this.salary = salary;
        this.workerID = counter;
        counter++;
    }

    public int getID() {
        return workerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return dateOfBitrh;
    }

    public void setAge(String age) {
        this.dateOfBitrh = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "   " + dateOfBitrh + "  " + salary + " sek/month  Worker ID: " + workerID;
    }

}
