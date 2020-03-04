package characters;
/**
 * A description of the Ogre class
 * This class gives the description of the specific monster.
 *
 * @author jullanq
 */
public class Ogre extends Monster
{
    //constructor that return the description of this Monster.
    public Ogre(int probability)
    {
        super("Ogre","Mad ogre",91, probability,0);
    }
}
