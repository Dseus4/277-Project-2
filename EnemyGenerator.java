import java.util.Scanner;
import java.io.File;

/**
 * Generate enemies in the game from the provided txt file.
 */
class EnemyGenerator{
    /**
     * This method will generate an enemy from the list with its level
     * 
     * @return - Randomly generated Enemy
     */
    public Enemy generateEnemy( int level ) {
        Enemy outEnemy;
        int rand_enemy = (int)( Math.random() * 4 );
        switch( rand_enemy ){
            case 0:
                outEnemy = new Troll();
                break;
            case 1:
                outEnemy = new Orc();
                break;
            case 2:
                outEnemy = new Froglok();
                break;
            case 3:
                outEnemy = new Goblin();
        }
        if( level > 1 ){
            rand_enemy = (int)( Math.random() * 2 );
            
            for( int i = 1; i < level; ++i ){
                switch( rand_enemy ){
                    case 0:
                        outEnemy = new Warrior( outEnemy );
                    case 1:
                        outEnemy = new Warlock( outEnemy );
                }
            }
        }
        return outEnemy;
        
    }
}