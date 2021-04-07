import java.util.Scanner;
import java.io.File;

/**
  * Generate enemies in the game from the provided txt file.
  */
class EnemyGenerator{
    java.util.ArrayList<Enemy> enemyList = new java.util.ArrayList<Enemy>();

    /**
      * Constructs list of enemies via "Enemies.txt"
      */
    public EnemyGenerator() {
        String next;
    	File file = new File( "Enemies.txt" );
        try {
		    Scanner r = new Scanner( file );

            while( r.hasNextLine() ) {
                next = r.nextLine();
                String[] earr = next.split( "," );
                enemyList.add( new Enemy( earr[0] , Integer.parseInt( earr[1] ) ) );
            }
            r.close();
        } catch (java.io.FileNotFoundException e){
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        }

    }

      /**
      * This method will generate an enemy from the list with its level
      * @return - Randomly generated Enemy
      */

    public Enemy generateEnemy() {
        int mNum = (int)( Math.random() * enemyList.size() );
        boolean isMagic = ( ( (int)( Math.random() * 2 ) ) == 1 );
        if( isMagic ) {
            return new MagicalEnemy( enemyList.get( mNum ).getName() + " Warlock" , enemyList.get( mNum ).getHP() );
        } else {
            return new Enemy( enemyList.get( mNum ).getName(), enemyList.get( mNum ).getMaxHP() );
        }
    }
}