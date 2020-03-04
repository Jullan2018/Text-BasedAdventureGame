/**
 *
 * This is a description of Entity abstract class.
 * This gives a description and an unique identifier of all the entities
 * in the game.
 *
 * @author jullanq
 */
package entities;
import java.util.Random;


public abstract class Entity
{
    private String description;
    private String id;

    /**
     * A get method for description
     * @return description instance variables
     */
    public String getDescription() {
        return description;
    }

    /**
     * A set method for description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * A get method of id
     * @return id
     */
    public String getId() {
        return id;
    }

    /*a default constructor*/
    public Entity()
    {
        this.description = "";
        this.id = "";
    }

    /*a constructor that takes in description and sets the unique identifier*/
    public Entity(String description)
    {
        this.description = description;
        this.id = this.getClass().getSimpleName();
    }

    /**
     *
     * @param x
     * @param y
     * @return a random integer between param x and param y
     */
    protected int randomNumber(int x, int y)
    {
        return new Random().nextInt(y-x) + x;
    }


    /**
     * A method that determines the entity's id equality to a given string,ignoring cases
     *
     * @param givenString
     * @return true if the idenitifer is equal to the givenString. Otherwise return false.
     */
    public boolean compareID(String givenString)
    {
        if(this.id.equalsIgnoreCase(givenString))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * A toString method
     *
     * @return the identifier
     */
    public String toString()
    {
        return ""+getId()+"";
    }

}
