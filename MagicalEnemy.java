/**
 * Randomly generated more difficult enemy with ability to cast magical spells
 */
class MagicalEnemy extends Enemy implements Magical{
    /**
     * Constructs MagicalEnemy entity with name and maxHP.
     * 
     * @param n   - Name of the Enemy
     * @param mHp - Max Hp of the enemy
     */
    public MagicalEnemy( String n , int mHp ) {
        super( n , mHp );
    }

    /**
     * Randomly chooses a spell to be cast against entity e(1-3).
     * 
     * @param e - Entity being attacked
     * @return - String representation of the magical attack being cast.
     */
    public String attack( Entity e ) {
        int attackNum = (int)( Math.random() * 3 ) + 1 ;
        switch( attackNum ) {
            case 1: 
                return magicMissle( e );
            case 2:
                return fireball( e );
            case 3:
                return thunderclap( e );
        }
        return magicMissle( e );
    }

    /**
     * Enemy's cast of Magic missle attack against entity e(1-6).
     * 
     * @param e - The Hero entity being attacked
     * @return - String representation of Magic Missles cast against entity e
     */
    public String magicMissle( Entity e ) {
        int d = (int)(Math.random() * 3 );
        e.takeDamage( d );
        return getName() + " shoots " + e.getName() + " with Magic Missles for " + d + " damage.";
    }

    /**
     * Enemy's cast of Fireball attack against entity e(2-5).
     * 
     * @param e - The Hero entity being attacked
     * @return - String representation of Fireball cast against entity e
     */
    public String fireball( Entity e ) {
        int d = (int)(Math.random() * 4 );
        e.takeDamage( d );
        return getName() + " hits " + e.getName() + " with Fireball for " + d + " damage.";
    }

    /**
     * Enemy's cast of Thunderclap attack against entity e(3-4).
     * 
     * @param e - The Hero entity being attacked
     * @return - String representation of Thunderclap cast against entity e
     */
    public String thunderclap( Entity e ) {
        int d = (int)(Math.random() * 3 ) + 1;
        e.takeDamage( d );
        return getName() + " zaps " + e.getName() + " with Thunderclap for " + d + " damage.";
    }
}