package ksiegarnia.workers;

public class CreateEmployee {

    public static void main(String[] args) {
        Employee manager = new Manager("Janke", "Kowalski", SexType.MALE,"janekKowalski@o2.pl",35,"665-857-987",35,30);
        Employee dealer = new Dealer("Maria", "Przybyła", SexType.FEMALE,"maiaPrzybyła@o2.pl",35,3530);
        Employee trainee = new Trainee("Krzyś", "Oleś", SexType.MALE,"krzyśOleś@o2.pl",35,30,10);

        System.out.println(manager.getSalary());
        System.out.println(dealer.getSalary());
        System.out.println(trainee.getSalary());
    }
}
