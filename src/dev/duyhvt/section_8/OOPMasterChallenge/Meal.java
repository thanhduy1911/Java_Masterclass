package dev.duyhvt.section_8.OOPMasterChallenge;

public class Meal extends Item {
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public Meal(String type, double price) {
        super(type, price);
    }

    public Meal(String type, double price, Burger burger, Drink drink, SideItem sideItem) {
        super(type, price);
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }


}
