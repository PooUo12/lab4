package people;


public class DefaultPerson extends Person implements HasDescription{
    private String description;
    public DefaultPerson(String name, int money, int age, String description){
        super(name, money, age);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Mother becomeMother(Person person){
        Mother mother = new Mother(getName(), getMoney(), getAge(), getDescription());
        mother.addChildren(person);
        System.out.println(getName() + "стал матерью" + person);
        return mother;
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
    }
}
