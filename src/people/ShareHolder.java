package people;

import assets.Share;
import assets.Shares;

import java.util.ArrayList;

public class ShareHolder extends Person implements HasDescription {

    private ArrayList<Share> sharePackage = new ArrayList<>();
    private String description;

    public ShareHolder(String name, int money, int age, String description) {
        super(name, money, age);
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    @Override
    public void changeDescription(String newDescription) {
        description = newDescription;
    }

    public void buyShareFromStock(Shares name, int amount) {
        Share buying = new Share(name, amount);
        if (getMoney() >= buying.getPrice()) {
            changeMoney(-buying.getPrice());
            sharePackage.add(buying);
            System.out.println("Было куплено " + amount + " акций " + buying.getName() + " за " + buying.getPrice() + " Господином " + getDescription() + " " + getName());
        } else {
            System.out.println("Сбой покупки! Не достаточно средств");
        }
    }


    public void buyShare(Shares name, int amount, int sale, ShareHolder seller) {
        Share buying = new Share(name, amount);
        if (getMoney() >= buying.getPrice() * (1 - sale / 100)) {
            for (Share s : getShares()) {
                if (s.getName().equals(name)) {
                    changeMoney(-buying.getPrice() * (1 - sale / 100));
                    s.changeAmount(amount);
                    System.out.println("Было куплено " + amount + " акций " + buying.getName() + " за " + buying.getPrice() + " Господином " + getDescription() + " " + getName());
                    seller.sellShare(name, amount, sale, getHolder());
                    return;
                }
            }
            changeMoney(-buying.getPrice() * (1 - sale / 100));
            sharePackage.add(buying);
            seller.sellShare(name, amount, sale, getHolder());
            System.out.println("Было куплено " + amount + " акций " + buying.getName() + " за " + buying.getPrice() + " Господином " + getDescription() + " " + getName());
        }

    }

    public void buyShare(Shares name, int amount, ShareHolder seller) {
        Share buying = new Share(name, amount);
        if (getMoney() >= buying.getPrice()) {
            for (Share s : getShares()) {
                if (s.getName().equals(name)) {
                    changeMoney(-buying.getPrice());
                    s.changeAmount(amount);
                    seller.sellShare(name, amount, getHolder());
                    break;
                }
            }
            changeMoney(-buying.getPrice());
            sharePackage.add(buying);
            seller.sellShare(name, amount, getHolder());
            System.out.println("Было куплено " + amount + " акций " + buying.getName() + " за " + buying.getPrice() + " Господином " + getDescription() + " " + getName());
        }
    }

    public void sellShare(Shares name, int amount, ShareHolder buyer) {
        for (Share s : (ArrayList<Share>) getShares().clone()) {
            if (s.getName().equals(name)) {
                if (s.getAmount() >= amount && buyer.getMoney() > s.getPrice()) {
                    changeMoney(s.getPrice());
                    System.out.println(getName() + " продал свои акции " + name + " " + buyer.description + " " + buyer.getName());
                    if (s.getAmount() == amount) {
                        sharePackage.remove(s);
                    } else s.changeAmount(amount);
                }
                buyer.buyShare(name, amount, getHolder());
            }

        }


    }

    public void sellShare(Shares name, int amount, int sale, ShareHolder buyer) {
        for (Share s : (ArrayList<Share>) getShares().clone()) {
            if (s.getName().equals(name)) {
                if (s.getAmount() >= amount && buyer.getMoney() > s.getPrice() * (1 - sale / 100)) {
                    changeMoney(s.getPrice() * (1 - sale / 100));
                    System.out.println(getName() + " продал свои акции " + name + " " + buyer.description + " " + buyer.getName());
                    if (s.getAmount() == amount) {
                        sharePackage.remove(s);
                    } else s.changeAmount(-amount);
                }
                buyer.buyShare(name, amount, sale, getHolder());
            }
        }

    }

    public void sellShareToStock(Shares name, int amount) {
        Share delete = null;
        for (Share s : sharePackage) {
            if (s.getName().equals(name)) {
                if (s.getAmount() >= amount) {
                    changeMoney(s.getPrice());
                    System.out.println("Было продано " + amount + " акций " + name);
                    if (s.getAmount() == amount) {
                        delete = s;
                    } else s.changeAmount(amount);
                } else System.out.println("Недостаточно акций для продажи");
            }
        }
        if (delete != null) {
            sharePackage.remove(delete);
        }
    }

    public ArrayList<Share> getShares() {
        return sharePackage;
    }

    public ShareHolder getHolder() {
        return this;
    }
}
