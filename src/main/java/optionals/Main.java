package optionals;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Captain Jack Sparrow", null);
        Person p2 = new Person("Lieutenant Theodore Groves", "Theodoregroves@britisharmy.com");

        System.out.println(p1.getName()+" -> "+p1.getEmail());
        System.out.println(p2.getName()+" -> "+p2.getEmail());

        p1.setEmail("captainjacksparrow@pirate.com");
        System.out.println(p1.getName()+" -> "+p1.getEmail());

        System.out.println(p1);

    }
}
