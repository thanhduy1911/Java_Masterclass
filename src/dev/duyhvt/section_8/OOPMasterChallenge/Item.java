package dev.duyhvt.section_8.OOPMasterChallenge;

public class Item {
    private String type;
    protected double price;

    public Item(String type, double price) {
        this.type = type;
        this.price = price;
    }
}

class Drink extends Item {
    private String drinkName;
    private int drinkSize;

    public Drink(String drinkName,String type, double price, int drinkSize) {
        super(type, price);
        this.drinkSize = drinkSize;
        this.drinkName = drinkName;
    }
}

class SideItem extends Item {
    private String sideItemName;

    public SideItem(String sideItemName,String type, double price) {
        super(type, price);
        this.sideItemName = sideItemName;
    }
}

class Burger extends Item {
    private int numExtraTopping;
    private boolean hasExtraTopping;

    public Burger(String type, double price) {
        super(type, price);
    }

    public Burger(String type, double price, boolean hasExtraTopping, int numExtraTopping) {
        super(type, price);
        this.hasExtraTopping = hasExtraTopping;
        this.numExtraTopping = numExtraTopping;
    }

    public void addExtra() {
        if (hasExtraTopping) {
            while (numExtraTopping > 0) {
                price += 5;
                numExtraTopping -= 1;
            }
        }
    }
}

class DeluxeBurger extends Burger {
    public DeluxeBurger(String type, double price, boolean hasExtraTopping) {
        super(type, price, true, 2);
    }
}
