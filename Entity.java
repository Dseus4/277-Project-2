/**
  * This class is a default class that the enemy entties and Hero entity will refer to during and after the battle to keep track of HP, healing done, and damage taken.
  */

public abstract class Entity {
    private int hp, maxHp;
    private String name;

    /**
      * Construcs Entity with a name and maxHP
      * @param n   - Entity's name
      * @param mHP - The entity's max health points
      */
    public Entity( String n , int mHp ) {
        hp = mHp;
        maxHp = mHp;
        name = n;
    }//end Entity()

    /**
      * Physical attack by this entity against entity e.
      * @param e - The following methods will pass through this entity
      * @return  - String representation of attack against entity e
      */
    public abstract String attack( Entity e );

    /**
      * Gets the entity's name
      * @return name - Entity's name
    */
    public String getName() {
        return name;
    }

    /**
      * Gets the Entity's HP
      * @return hp - Entity HP
    */
    public int getHP() {
        return hp;
    }

    /**
      * Gets the Entity's max HP
      * @return hp - Entity max HP
    */
    public int getMaxHP() {
        return maxHp;
    }

     /**
      * Heals the entity's health for a certain amount.
      * @param h - Amount of health being healed to the entity
      */
    public void heal( int h ) {
        if ( hp + h >= maxHp ){
            hp = maxHp;
        } else {
            hp += h;
        }
    }//end heal()

    /**
    * Damages entity for certain amount.
    * @param d - Aamount of damage being taken
    */
    public void takeDamage( int d ) {
        if ( hp - d <= 0 ) {
            hp = 0;
        } else {
            hp -= d;
        }
    }//end takeDamage()

    /**
    * Generates general info on Entity
    * @return - String representation of entity
    */
    public String toString() {
        return name + "\nHp: " + hp + "/" + maxHp;
    }
}//end Entity