package people;

import location.Kitchen;

import java.util.ArrayList;

public class Mother extends DefaultPerson {
    private ArrayList<Person> children = new ArrayList<>();
    public Mother(String name, int money, int age, String description) {
        super(name, money, age, description);
    }
    public void addChildren(Person son){
        children.add(son);
    }
    public ArrayList<Person> seeChildren(){
        return children;
    }

    public void makeCoffee(Kitchen kitchen){
        kitchen.makeCoffee(this);
    }
}
