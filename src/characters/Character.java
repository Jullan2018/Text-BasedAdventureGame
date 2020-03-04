package characters;
import entities.Entity;
/**
 * This a description of Character class.
 * An abstract class that stores the health points and the description of
 * each character in the game which includes player & monster
 *
 * @author jullanq
 */
public abstract class Character extends Entity
{
    protected int healthPoints;

    /**
     * A get method for healthPoints
     * @return healthPoints if condition is true otherwise returns nothing
     */
    public int getHealthPoints()
    {
        if(this.healthPoints > 0) {
            return healthPoints;
        }
        else
        {
            return 0;
        }
    }
    /**
     * A set method for healthPoints
     * @param healthPoints
     */
    public void setHealthPoints(int healthPoints)
    {
        this.healthPoints = healthPoints;
    }

    //A constructor that takes in the description and health point
    public Character(String descriptions, int healthPoints)
    {
        super(descriptions);
        this.healthPoints = healthPoints;
    }

    /**
     * An abstract class which is overridden in Monster class.
     */
    protected abstract int dealAttackDamage();
    /**
     * An abstract class which is overridden in Monster class.
     */
    public abstract int defendAttack(Character enemy);

}
