package assets;

import java.util.Objects;

public class Share implements HasPrice {
    private int price = (int) (5 * Math.random() + 7);
    private int amount;
    private Shares name;

    public Share(Shares name, int amount){
        this.name = name;
        this.amount = amount;
    }

    public int getPrice(){
        return price*amount;
    }

    public void changePrice(int change){
        if (change >= 0) price *= (1+ change/100);
        else price *= (1- change/100);
    }

    public Shares getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public String toString(){
        return name.toString();
    }

    public void changeAmount(int change){
        amount += change;
    }

    public int hashCode(){
        return Objects.hash(name, price, amount);
    }

    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Share that = (Share) ob;
        return Objects.equals(toString() + this.hashCode(), that.toString() + that.hashCode());
    }
}

