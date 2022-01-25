package assets;

import java.util.ArrayList;

public class MoneyBox {
    private String purpose;
    private ArrayList<Coin> content = new ArrayList<>();
    private boolean broken = false;
    public MoneyBox(String purpose, ArrayList<Coin> content){
        this.purpose = purpose;
        this.content = content;
    }
    public String getPurpose(){
        return purpose;
    }

    public void changePurpose(String newName){
        purpose = newName;
    }

    public ArrayList<Coin> getContent(){
        return content;
    }

    public boolean checkCondition(){
        return broken;
    }

    public void destroy(){
        broken = true;
    }
}
