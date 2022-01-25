package assets;

public class Dog implements HasPrice {
    private String name;
    private int age;
    private int price;
    public Dog(String name, int age, int price){
        this.name = name;
        this.age = age;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void happyBirthday(){
        age++;
    }
    public int getPrice(){
        return price;
    }
    public void changePrice(int change){
        price += change;
    }
}
