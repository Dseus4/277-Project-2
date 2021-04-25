
/**
 * This class will create an enemy that the Hero will fight in the game.
 */
abstract class Enemy extends Entity {
    /**
     * Constructs Enemy with name and max HP.
     * 
     * @param n   - Name of Enemy
     * @param mHp - Max HP of enemy
     */
    public Enemy( String n, int mHp ){
        super( n, mHp );
    }
}