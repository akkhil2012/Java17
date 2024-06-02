public class SampleObject {

    public static void main(String atgs[]){
        String first = "first";
        String second = "first";
        String third = second;

        System.out.println("1: " + first.equals(second));
        System.out.println(" 2: " + (first==second));
        System.out.println(" 3: " + (third==second));
        System.out.println("4: " + third.equals(second));

        // Object Reference
        User user1 = new User("akkhil",40);
        User user2 = new User("akkhil",41);
        User user3 = user2;

        // false, true without overriding equals
        System.out.println("User ref comparison:1  : " + user1.equals(user2));
        System.out.println("User ref comparison:2 : " + (user3==user2));

        // without overring hashcode
        System.out.println("user1 hashcode comparison: " + user1.hashCode());
        System.out.println("user2 hashcode comparison: " + user2.hashCode());

        System.out.println("class Vs instance of comparison: "
                + (user1.getClass().equals(PowerUser.class)) +" is instance of " + (user1 instanceof User) + " of powerUser " + (user1 instanceof PowerUser));

    }
}


class PowerUser{

}

class User extends  PowerUser{

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return this.age*2;
    }

}
