package location;

import assets.Coin;
import assets.MoneyBox;
import people.Person;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Room extends Location {
    private MoneyBox pig;
    private ArrayList<Person> people = new ArrayList<>();
    public Room(String description, MoneyBox pig){
        super(description);
        this.pig = pig;
    }
    Predicate<MoneyBox> checking = new Predicate<MoneyBox>() {
        @Override
        public boolean test(MoneyBox pig) {
            if (pig.checkCondition() == true){
                return true;
            } else{
                return false;
            }
        }
    };

    public void breakPig(Person person) throws Error{
        if (checking.test(pig)){
            throw new Error();
        }
        for (Coin coin: pig.getContent()){
            person.changeMoney(coin.getPrice());
        }
        pig.destroy();
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

}
