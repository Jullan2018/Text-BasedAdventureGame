package pickups;
import entities.Entity;

/**
 * This is a description of a Pickup abstract class
 * This describes the description of the pickup items within the game
 *
 * @author jullanq
 */
public abstract class Pickup extends Entity
{
    /*A constructor to initialize the description*/
    public Pickup(String descriptions)
    {
        /*access the constructor of the super class*/
       super(descriptions);
    }
}
