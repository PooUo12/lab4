package people;

import assets.Dog;
import assets.Goods;
import exceptions.NotEnoughMoneyException;
import location.Barge;
import location.Kitchen;
import location.Location;
import location.Room;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Person {
    private String name;
    private int money;
    private int age;
    public Inventory inventory = new Inventory();
    private ArrayList<Dog> dogs = new ArrayList<>();
    private Location location;

    public Person(String name, int money, int age){
        this.age = age;
        this.money = money;
        this.name = name;
    }

    public class Inventory{
        private ArrayList<String> inventory = new ArrayList<>();
        public void addItem(String s){
            inventory.add(s);
        }
        public void removeItem(String s){
            inventory.remove(s);
        }
        public ArrayList<String> checkPockets(){
            return inventory;
        }
    }

    public int getAge(){
        return age;
    }

    public void happyBirthday(){
        age++;
    }

    public String getName(){
        return name;
    }

    public int getMoney(){
        return money;
    }

    public void changeMoney(int x){
        money += x;
    }

    public void setName(String newName){
        name = newName;
    }

    public String toString(){
        return "Человек" + name;
    }

    public int hashCode() {
        return Objects.hash(name, money, age, Math.random());
    }
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Person that = (Person) ob;
        return Objects.equals(name + this.hashCode(), that.name + that.hashCode());
    }
    public void eat(Goods d){
        inventory.removeItem(d.toengString());
        System.out.println(name + "Покушал");
        }

    public void buyDog(Dog dog) throws NotEnoughMoneyException {
        if (money >= dog.getPrice()){
            dogs.add(dog);
        }
        else{
            sigh();
            throw new NotEnoughMoneyException("Недостаточно средств для покупки собаки");
        }
    }

    public ArrayList<Dog> getDogs(){
        return dogs;
    }

    public void goTo(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }

    public void sigh(){
        System.out.println("Тяжело вздохнул");
        age++;
    }

    public void getKnife(Kitchen kitchen) throws Error{
        kitchen.getKnife(this);
    }

    public void breakPig(Room room, Person person) throws Error{
        for (String s: person.inventory.checkPockets()){
            if (s == "Нож") {
                room.breakPig(this);
            }
        }
    }

    public void buyProduct(Goods goods) throws NotEnoughMoneyException{
        if (money >= goods.getPrice()){
            inventory.addItem(goods.toengString());
            changeMoney(-goods.getPrice());
        } else {
            throw new NotEnoughMoneyException("Недостаточно средств");
        }

    }

    public void giveSmth(Person person, String item){
        inventory.removeItem(item);
        person.inventory.addItem(item);
    }



}
