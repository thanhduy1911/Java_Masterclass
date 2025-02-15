package dev.duyhvt.section_8.Encapsulation;

public class EnhancedPlayer {
    private String fullName;
    private String weapon;
    private int healthPercentage;

    public EnhancedPlayer(String fullName) {
        this(fullName, "Sword", 100);
    }

    public EnhancedPlayer(String fullName, String weapon, int health) {
        this.fullName = fullName;
        this.weapon = weapon;
        this.healthPercentage = (health <= 0) ? 1 : (health > 100) ? 100 : health;
    }

    public void loseHealth(int damage) {
        healthPercentage -= damage;
        if (healthPercentage <= 0) System.out.println("Player knocked out of game");
    }

    public int healthRemaining() {
        return healthPercentage;
    }

    public void restoreHealth(int extraHealth) {
        healthPercentage += extraHealth;
        if (healthPercentage > 100) {
            System.out.println("Player restored to 100");
            healthPercentage = 100;
        }
    }
}
