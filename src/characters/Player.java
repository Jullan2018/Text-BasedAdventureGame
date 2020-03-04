package characters;
import gameplay.Inventory;
import valuables.Valuable;
import wieldable.FistsOfFury;
import wieldable.Wieldable;
import java.util.ArrayList;
import food.*;

/**
 * This is a description of Player class.
 * This class gives the description of a Player.
 *
 * @author jullanq
 */
public class Player extends Character
{
    private int confidenceValue; //
    private String name;
    private Wieldable weapon;
    private String armour;
    private Inventory inventory;
    private ArrayList<Valuable> consumedValuables;

    /**
     * A get method for armour.
     * @return the player's armour
     */
    public String getArmour() {
        return armour;
    }
    /**
     * A get method for Inventory.
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
    /**
     * A set method for armour.
     * @param armour
     */
    public void setArmour(String armour) {
        this.armour = armour;
    }
    /**
     * A get method for confidence value.
     * @return confidenceValue
     */
    public int getConfidenceValue() {
        return confidenceValue;
    }
    /**
     * A set method for confidence value.
     * @param confidenceValue
     */
    public void setConfidenceValue(int confidenceValue) {
        this.confidenceValue = confidenceValue;
    }
    /**
     * A get method for the player's name.
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * A set method for the player's name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * A get method for the player's weapon.
     * @return weapon
     */
    public Wieldable getWeapon() {
        return weapon;
    }
    /**
     * A set method for the player's weapon.
     * @param weapon
     */
    public void setWeapon(Wieldable weapon) {
        this.weapon = weapon;
    }
    /**
     * The overridden method dealAttackDamage from the Character class returns the damage dealt
     * by the players.
     * @return the damage dealt by the player.
     */
    @Override
    protected int dealAttackDamage()
    {
        int h = weapon.hit();
        int damage = h + h * confidenceValue/100;

        return damage;
    }
    /**
     * The overridden method defendAttack from the Character class simulates an incoming attack
     * from an enemy character.
     * @param enemy
     * @return
     */
    @Override
    public int defendAttack(Character enemy)
    {
        int d = enemy.dealAttackDamage();
        this.healthPoints = healthPoints - d;
        confidenceValue = confidenceValue - (d/2);

        return d;
    }

    //A constructor that gives a description of the player
    public Player(String name, String armour ,int healthPoints, int confidenceValue)
    {
        super(name,healthPoints);
        this.setName(name);
        this.confidenceValue = confidenceValue;
        this.armour = armour;
        this.inventory = new Inventory();
        this.setWeapon(new FistsOfFury("FistsOfFury"));
        this.consumedValuables = new ArrayList<>();

    }
    /**
     * The admire method increases the player's confidence and is not removed from
     * the player's inventory.
     * @param valuable
     */
    public void admire(Valuable valuable)
    {
        int playerConfidence = getConfidenceValue() + valuable.getObjectValue();
        if(!consumedValuables.contains(valuable))
        {
            setConfidenceValue(playerConfidence);
            consumedValuables.add(valuable);
        }

    }
    /**
     * The eat method increases the player's health points. Once eaten, the food is removed from
     * the player's inventory.
     * @param food
     */
    public void eat(Food food)
    {
        int increaseHealth = getHealthPoints() + food.getHealthPoints();
        if(!consumedValuables.contains(food))
        {
            setHealthPoints(increaseHealth);
            consumedValuables.remove(food);
        }

    }

}
