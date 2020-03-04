package characters;
/**
 * A description of the Zombie class
 * This class gives the description of the specific monster.
 *
 * @author jullanq
 */
public class Zombie extends Monster
{
    //constructor that return the description of this Monster.
    public Zombie(int probability)
    {
        super("Zombie","Slow moving zombie",80, probability,0);
    }
}
