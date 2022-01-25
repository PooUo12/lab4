package assets;

public class Coin {
    private int price;
    private String description;
    public Coin(int price, String description){
        this.description = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
