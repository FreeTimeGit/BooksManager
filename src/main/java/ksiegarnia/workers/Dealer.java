package ksiegarnia.workers;

public class Dealer extends Employee {

    private double salary;

    public Dealer(String name, String surname, SexType sexType, String email, int age, double salary) {
        super(name, surname, sexType, email, age);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
