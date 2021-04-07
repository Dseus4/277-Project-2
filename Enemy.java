
/**
  * This class will create an enemy that the Hero will fight in the game.
  */
class Enemy extends Entity {
    /**
    * Constructs Enemy with name and max HP.
    * @param n - Name of Enemy
    * @param mHp - Max HP of enemy
    */
    public Enemy(String n, int mHp){
        super(n, mHp);
    }
    /** 
      * Physical attack by Enemy against entity (1 - 2*maxHP).
      * @param e - Entity the enemy is attacking
      * @return - String representation of attack
      */
    public String attack(Entity e){
        int d = (int)( Math.random() * ( ( getMaxHP() * 2 ) - 1 ) ) + 1;
        e.takeDamage(d);
        return getName() + " attacks " + e.getName() + " for " + d + " damage.";
    }
}