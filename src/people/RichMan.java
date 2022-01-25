package people;

import assets.Company;
import assets.Share;
import assets.Shares;

import java.util.ArrayList;

public class RichMan extends ShareHolder{
    private ArrayList<Company> companies = new ArrayList<>();

    public RichMan(String name, int money, int age, String description){
        super(name, money, age, description);
    }

    public void getCompany(Shares getting){
        for (Share s: getShares()){
            if (s.getName().equals(getting)){
                if (s.getAmount() > 50){
                    companies.add(getting.toCompany(getting));
                    System.out.println("Компания " + getting + " попала в щупальца " + getDescription() + " " + getName() + " и он стал ее владельцем");
                }
            }
        }
    }
    public ArrayList<Company> getCompanies(){
        return companies;
    }
}
