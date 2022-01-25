package assets;

public enum Goods {
    LOLLIPOPS("Леденцы","Lolipops", 5),
    CHOCOLATE("Шоколадка", "Chocolate", 4),
    NUTS("Засахаренные орешки", "Nuts", 7),
    BISCUIT("Печенье", "Biscuit", 10),
    COFFEE("Кофе","Coffee", 8),
    ALCOHOL("Алкоголь","Alcohol",20);

    private final String name;
    private final String engName;
    private final int price;

    Goods(String name, String engName, int price){
        this.name = name;
        this.engName = engName;
        this.price = price;
    }

    public String toString(){
        return name;
    }

    public String toengString(){
        return engName;
    }

    public int getPrice(){
        return price;
    }

}
