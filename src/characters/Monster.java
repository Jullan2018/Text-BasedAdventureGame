package characters;
/**
 * A description of the Monster class
 * This class gives the description of the each monster.
 *
 * @author jullanq
 */
public abstract class Monster extends Character
{
    private int monsterAppear;
    private int damage;
    private int r;
    private int d;
    private String monsterName;

    /**
     * A get method for r(r is a randomly selected value between 1 and 10).
     * @return a random number between 1 and 10.
     */
    public int getR() {
        r = this.randomNumber(1,10); //r is randomly selected value between 1 and 10.
        return r;
    }
    /**
     * A get method for the monster name.
     * @return the name of the monster.
     */
    public String getMonsterName() {
        return monsterName;
    }
    /**
     * A set method for the monster name.
     * @param monsterName
     */
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    /**
     * A get method for d(the damage from the enemy).
     * @return damage from the enemy.
     */
    public int getD() {
        return d;
    }
    /**
     * A set for d(the damage from the enemy).
     * @param d
     */
    public void setD(int d) {
        this.d = d;
    }
    /**
     * A get method for monsterAppear.
     * @return the probability of the monster appearing.
     */
    public int getMonsterAppear() {
        return monsterAppear;
    }
    /**
     * A set method for monsterAppear.
     * @param monsterAppear
     */
    public void setMonsterAppear(int monsterAppear) {
        this.monsterAppear = monsterAppear;
    }
    /**
     * a get method for damage.
     * @return damage
     */
    public int getAmountOfDamage()
    {
        return this.dealAttackDamage();
    }
    /**
     * A set method for damage.
     * @param amountOfDamage
     */
    public void setAmountOfDamage(int amountOfDamage) {
        this.damage = amountOfDamage;
    }

    //A constructor that gives the description of a Monster.
    public Monster(String name,String description, int healthPoints, int monsterAppear, int amountOfDamage)
    {
        super(description,healthPoints);
        this.monsterName = name;
        this.monsterAppear = monsterAppear;
        this.damage = amountOfDamage;

    }
    /**
     * This method return the amount of damage dealt by the player's
     * attack.
     * @return the damage dealt from the enemy
     */
    @Override
    protected int dealAttackDamage()
    {
        return this.damage + getR();
    }
    /**
     * This method returns the amount of damage dealt by the enemy's
     * attack.
     * @param enemy
     * @return
     */
    @Override
    public int defendAttack(Character enemy)
    {
        this.d = enemy.dealAttackDamage();
        return d;
    }
    /**
     * This method return a boolean that determines if a monster appears
     * or not.
     * @return false if health point is greater than 0 otherw
     */
    public boolean appear()
    {
        if(this.healthPoints > 0) //this ensures the health point is a non-negative value.
        {
            if (this.healthPoints == 0) //this ensure a monster doesn't appear if it health point is 0.
            {
                return false;
            }
            else
            {
                int x = this.randomNumber(0,101);

                return x <= this.monsterAppear;

            }
        }
        else
        {
            return false;
        }
    }

}


