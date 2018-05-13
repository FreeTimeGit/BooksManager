package ksiegarnia.workers;

public class Trainee extends Employee {

    private int workingHours;
    private double hourlySalary;

    public Trainee(String name, String surname, SexType sexType, String email, int age, int workingHours, double hourlySalary) {
        super(name, surname, sexType, email, age);
        this.workingHours = workingHours;
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double getSalary() {
        return workingHours*hourlySalary;
    }
}
