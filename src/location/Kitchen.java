package location;

import people.DefaultPerson;
import people.Person;

import java.awt.*;
import java.util.ArrayList;

public class Kitchen extends Location{
    private ArrayList<Person> people = new ArrayList<>();
    private boolean knife = true;
    private boolean coffee = false;
    private boolean flag = false;
    public Kitchen(String name){
        super(name);
    }
    public void haveDinner() throws Error{
        if (coffee == false){
            throw new Error("Кофя нет");
        } else {
            coffee = false;
            System.out.println("Семья обедает");
        }
    }

    public void makeCoffee(DefaultPerson maker) throws Error{
        for (String s : (ArrayList<String>) maker.inventory.checkPockets().clone()){
            if (s == "Coffee"){
                coffee = true;
                maker.inventory.removeItem("Coffee");
                flag = true;
            }
        }
        if (flag == false){
            throw new Error("Нет кофя");
        }
    }
    public ArrayList<Person> checkWhoInside(){
        return people;
    }
    public void addPerson(Person person){
        people.add(person);
    }
    public void removePerson(Person person){
        people.remove(person);
    }
    public void getKnife(Person person) throws Error{
        if (knife = false){
            throw new Error("Нет ножа");
        }
        knife = false;
        person.inventory.addItem("Нож");
    }
}
