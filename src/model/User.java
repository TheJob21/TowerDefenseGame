package model;

public class User {
    private int lives;
    private final int MAX_LIVES;
    private int bank;
    public int moneySpent = 0;
    public User(int lives, int bank){
        this.lives = this.MAX_LIVES = lives;
        this.bank = bank;
    }
    public int getMaxLives() {
        return MAX_LIVES;
    }
    public int getLives() {
        return lives;
    }
    public int getBank() {
        return bank;
    }
    public void removeLives(int damage){
        if(lives - damage < 0)
            lives = 0;
        else
            lives -= damage;
    }
    public void addMoney(int value){
        bank += value;
    }
    public void spendMoney(int value){
        moneySpent += value;
        bank -= value;
    }
}
