package ksiegarnia.workers;

public class Manager extends Employee {

    private String phoneNumber;
    private double hourlySalary;
    private int workingHours;

    public Manager(String name, String surname, SexType sexType, String email, int age, String phoneNumber, double hourlySalary, int workingHours) {
        super(name, surname, sexType, email, age);
        this.phoneNumber = phoneNumber;
        this.hourlySalary = hourlySalary;
        this.workingHours = workingHours;
    }

    @Override
    public double getSalary() {
        return workingHours*hourlySalary;
    }
}
