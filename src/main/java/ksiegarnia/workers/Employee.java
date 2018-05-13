package ksiegarnia.workers;

public abstract class Employee {

    private String name;
    private String surname;
    private SexType sexType;
    private String email;
    private int age;

    public Employee(String name, String surname, SexType sexType, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.sexType = sexType;
        this.email = email;
        this.age = age;
    }

    public abstract double getSalary();
}
