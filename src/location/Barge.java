package location;

import assets.Goods;
import assets.Shares;
import exceptions.ClosedShopException;
import exceptions.NotEnoughMoneyException;
import exceptions.ProductNotFoundException;
import people.Person;
import people.RichMan;


import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Barge extends Location{
    private String description;
    public Barge(String name, String description){
        super(name);
        this.description = description;
    }

    public static class Shop{
        private boolean closed;
        private List<Goods> products = new ArrayList<>();
        private String cassier;
        private String name;
        public Shop(String cassier, String name){
            this.cassier = cassier;
            this.name = name;
        }
        public void addProduct(Goods product) {
            try {
                products.add(product);

            } catch (ProductNotFoundException e) {
                e.getMessage();
            }
            }
        public void removeProduct(Goods product){
            products.remove(product);
        }

        public String getCassier(){
            return cassier;
        }

        public void changeCassier(String cassier){
            this.cassier = cassier;
        }

        public void getClosed(){
            closed = true;
            System.out.println("Магазин закрывается");
        }

        public void getOpened(){
            closed = false;
        }

        public void sellProduct(Goods goods, Person buyer){
            class SellingOperation{
                public void sellProduct() throws ClosedShopException{
                    if (closed == true){
                        throw new ClosedShopException("Магазин закрыт");
                    }
                    if (goods == Goods.ALCOHOL){
                        sellAlcohol();
                    }
                     try {
                         buyer.buyProduct(goods);
                         removeProduct(goods);
                     } catch (NotEnoughMoneyException e){
                         System.out.println(e.getMessage());
                     }

                }
                public void sellAlcohol(){
                    if (buyer.getAge() >= 18 || (int) (Math.random()* 100) == 1){
                        try {
                            buyer.buyProduct(goods);
                            removeProduct(goods);
                        } catch (NotEnoughMoneyException e){
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Слишком маленький");
                    }
                }
            }
            SellingOperation operation = new SellingOperation();
            operation.sellProduct();

        }

    }

    public void describe(){
        System.out.println(description);
    }

}
