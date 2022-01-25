import assets.Coin;
import assets.Dog;
import assets.Goods;
import assets.MoneyBox;
import exceptions.NotEnoughMoneyException;
import location.Barge;
import location.Kitchen;
import location.Roof;
import location.Room;
import people.DefaultPerson;
import people.Mother;

import java.util.ArrayList;

public class ProgramStart {
    public static void main(String[] args) {
        DefaultPerson carlson = new DefaultPerson("Карслон", 0,20, "С вентилятором");
        DefaultPerson malish = new DefaultPerson("Малыш", 0, 14, "Заботящийся");
        Mother malMom = new Mother("Мама Малыша", 10, 35, "Богатая");
        DefaultPerson father = new DefaultPerson("Отец малыша", 100, 40,"Крутой");
        DefaultPerson bethan = new DefaultPerson("Бетан", 100, 39, "Родной");
        DefaultPerson bosse = new DefaultPerson("Боссе", 140, 37, "Родной");
        Dog sharik = new Dog("Шарик", 1, 20);

        Coin coin1 = new Coin(10, "Затертая");
        Coin coin2 = new Coin(15, "Затертая");
        Coin coin3 = new Coin(1, "Новая");
        ArrayList<Coin> moneti = new ArrayList<>();
        moneti.add(coin1);
        moneti.add(coin2);
        moneti.add(coin3);
        MoneyBox copilka = new MoneyBox("Свинка", moneti);

        Roof roof = new Roof("Высокая");
        Room room = new Room("Уютная", copilka);
        Kitchen kitchen = new Kitchen("Украшенная");
        Barge barge = new Barge("Баржа", "Продвинутая");
        Barge.Shop shop = new Barge.Shop("Эдгар", "У Эдгара");

        shop.addProduct(Goods.BISCUIT);
        shop.addProduct(Goods.ALCOHOL);
        shop.addProduct(Goods.CHOCOLATE);
        shop.addProduct(Goods.COFFEE);
        shop.addProduct(Goods.NUTS);
        shop.addProduct(Goods.LOLLIPOPS);
        shop.sellProduct(Goods.COFFEE, malMom);
        System.out.println(malMom.inventory.checkPockets());
        kitchen.addPerson(malMom);
        kitchen.addPerson(father);
        kitchen.addPerson(bethan);
        kitchen.addPerson(bosse);


        malish.goTo(kitchen);
        malish.getKnife(kitchen);
        System.out.println(malish.inventory.checkPockets());
        malish.goTo(room);
        malish.breakPig(room, malish);
        System.out.println(malish.getMoney());
        malish.goTo(barge);
        shop.sellProduct(Goods.BISCUIT, malish);
        shop.sellProduct(Goods.CHOCOLATE, malish);
        shop.sellProduct(Goods.LOLLIPOPS, malish);
        shop.sellProduct(Goods.NUTS, malish);
        System.out.println(malish.getMoney());
        System.out.println(malish.inventory.checkPockets());
        try {
            malish.buyDog(sharik);
        } catch (NotEnoughMoneyException e){
            System.out.println(e.getMessage());
        }
        shop.getClosed();
        malMom.makeCoffee(kitchen);
        kitchen.haveDinner();
        malish.giveSmth(carlson, Goods.BISCUIT.toengString());
        carlson.eat(Goods.BISCUIT);
        Mother malishAged = malish.becomeMother(carlson);
        malishAged.goTo(roof);
        carlson.goTo(roof);
        roof.chill();





    }
}
