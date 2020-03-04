package openable;
import pickups.Pickup;
/**
 * This is a description of the Openable abstract class.
 * This class involves all the chest that are openable in the game.
 *
 * @author jullanq
 */
public abstract class Openable extends Pickup
{
    private boolean locked;
    private Pickup content;

    /**
     * A get method for locked
     * @return locked
     */
    public boolean isLocked() {
        return locked;
    }
    /**
     * A set method for locked
     * @param locked
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    /**
     * A get method for content
     * @return content
     */
    public Pickup getContent() {
        return content;
    }
    /**
     * A set method for content
     * @param content
     */
    public void setContent(Pickup content) {
        this.content = content;
    }

    /*A constructor that initializes the descriptions and content*/
    public Openable(String description, Pickup content)
    {
        super(description);
        setContent(content);
        this.locked = true;
    }

    public Openable(Pickup content, String description) {
        super(description);
        this.content = content;
    }

    /**
     * An abstract method
     * @param opener
     */
    public abstract void unlockWith(Opener opener);
}
