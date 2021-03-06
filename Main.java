import java.util.Scanner;
import java.awt.Point;
class Main {
    /**
     * This method lets the user know they encountered a monster room and gives
     * options to either initiate fight method or run away to a random direction.
     * 
     * @param h - User controlled Hero object
     * @param e - Enemy object the user confronts
     * @return - Whether or not the player survived the encounter
     */
    static boolean monsterRoom( Hero h , Enemy e ) {
        Scanner in = new Scanner( System.in );
        Map map = Map.getInstance();
        
        int userIn;
    
        System.out.println( "You've encountered a " + e.getName() );

        boolean inRoom = true;
        while( inRoom ) {
            System.out.println( e.toString() );
            System.out.println( "1. Fight\n2. Run away" );

            userIn = 0;
            if( in.hasNextInt() ) {
                userIn = in.nextInt();
            }
            else {
                in.nextLine();
            }

            switch( userIn ) {
                case 1:
                    if( fight( h , e ) == false ) {
                        return false;
                    }
        
                    break;
                case 2:
                    //move player random direction, if is wall, move valid direction
                    char testDir = 'x';
                    while( testDir == 'x' ){
                        switch( (int)( Math.random() * 4 ) ) {
                            case 0:
                                testDir = h.goNorth();
                                break;
                            case 1:
                                testDir = h.goSouth();
                                break;
                            case 2:
                                testDir = h.goEast();
                                break;
                            case 3:
                                testDir = h.goWest();
                                break;
                        }
                    }
                    return true;
            }

            if( e.getHP() == 0 ) {
                System.out.println( "You defeated the " + e.getName() + "!" );
                map.removeCharAtLoc( h.getLoc() );
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method starts the fight sequence with the Hero and the monster where the
     * user can choose two different types of attacks to combat the monster
     * 
     * @param h - the Hero object that can use physical attacks or magic attacks
     *          against the mosnter
     * @param e - the enemy object that attacks the Hero
     * @return userIn - will return the outcome of the fight between the Hero and
     *         the monster
     */
    static boolean fight( Hero h , Enemy e ) {
        Scanner in = new Scanner( System.in );
        int userIn;
    
        System.out.println( "1. Physical Attack\n2. Magic Attack" );
        
        userIn = 0;
            if(in.hasNextInt()) {
                userIn = in.nextInt();
            }
            else {
                in.nextLine();
            }

        switch( userIn ) {
            case 1:
                System.out.println( h.getName() + " " + h.attack( e ) );
                break;
            case 2:
                System.out.println( h.MAGIC_MENU );
                
                userIn = 0;
                if(in.hasNextInt()) {
                    userIn = in.nextInt();
                }
                else {
                    in.nextLine();
                }
                
                switch( userIn ) {
                    case 1:
                        System.out.println( h.magicMissle( e ) );
                        break;
                    case 2:
                        System.out.println( h.fireball( e ) );
                        break;
                    case 3:
                        System.out.println( h.thunderclap( e ) );
                        break;
                    default:
                        System.out.println( "Invalid Spell" );
                }
                break;
            default:
                System.out.println( h.getName() + " passes." );
        }

        if( e.getHP() > 0 ) {
            System.out.println( e.getName() + " " + e.attack( h ) );
            if( h.getHP() == 0 ) {
                return false;
            }
        }
        h.collectGold((int) (Math.random() * 8) + 3); // Gives Hero 3-10 gold after defeating the enemy
    
        return true;
    }
    
    /**
     * This method allows the user to buy health potions or keys on returning to the start of a level.
     * 
     * @param h - User controlled Hero object
     */ 
    public static void store( Hero h ) {
        Scanner input = new Scanner( System.in );
        System.out.println( "Welcome to the store! What would you like to do?" );
        System.out.println( "1. Buy\n2. Exit" );
        
        int selection = 1;  

        while ( true ) {
            if ( input.hasNextInt() ) {
                selection = input.nextInt();

                if ( selection > 0 && selection < 3 ) {
                    break;
                }
            }
            else {
                input.nextLine();
            }
        }

        while (selection == 1) {
            System.out.println( "What would you like to buy?" );
            System.out.println( "1. Health Potions: 25 Gold\n2. Key: 50 Gold" );
            System.out.println( "Amount: " + h.getGold() );


            while (true) {
                if ( input.hasNextInt() ) {
                    selection = input.nextInt();

                    if ( selection > 0 && selection < 3 ) {
                        break;
                    }
                }
                else {
                    input.nextLine();
                }
            }


            if ( selection == 1 ) {

                if ( h.getGold() >= 25 ) {
                    h.spendGold( 25 );
                    System.out.println( "You got a potion! Using it now..." );
                    // Potions are used immediately.
                    h.heal( 25 );
                }
                else {
                    System.out.println( "Not enough gold! Come back when you have gold." );
                    break;
                }

            }
            else if ( selection == 2 ) {

                if ( h.getGold() >= 50 ) {
                    h.spendGold( 50 );
                    System.out.println( "You got a key!" );
                    h.pickUpKey();
                }
                else {
                    System.out.println( "Not enough gold! Come back when you have gold." );
                    break;
                }

            }

            System.out.println( "1. Buy again\n2. Quit" );

            while ( true ) {

                if ( input.hasNextInt() ) {
                    selection = input.nextInt();

                    if ( selection > 0 && selection < 3 ) {
                        break;
                    }
                }
                else {
                    input.nextLine();
                }
            }
        }
    }

    /**
     * This method starts the game by asking the user for their name. As long as the
     * hero is alive, the user will be able to keep moving them around the map.
     * 
     * @param in    - Takes input from user to select from game menu
     * @param name  - Name of the Hero
     * @param hero  - Hero/Main character of game
     * @param enGen - Enemy Generator when the user encounters a monster room
     */
    public static void main( String [] args ) {
        final String DIRECTION_MENU = "1. Go North\n2. Go South\n3. Go East\n4. Go West\n5. Quit";

        Scanner in = new Scanner( System.in );
        System.out.print( "What is your name, traveler? " );
        String name = in.nextLine();
        Hero hero = new Hero( name );
        Map map = Map.getInstance();
        EnemyGenerator enGen = new EnemyGenerator();
        
        char roomC = ' ';
        int userIn;
        boolean alive = true;
    
        
        while( alive ) {
        
            
            map.reveal( hero.getLoc() );
                
        
            switch( roomC ) {
                case 'x':
                    System.out.println( "You cannot go that way." );
                    break;
                case 'n':
                    System.out.println( "There was nothing here." );
                    break;
                case 's':
                    System.out.println( "You're back at the start. Accessing store..." );
                    store( hero );
                    break;
                case 'f':
                    if( hero.useKey() ) {
                        System.out.println( "You found the exit. Proceeding to the next level." );
                    
                        hero.levelUp();
                      
                        map.reveal( hero.getLoc() );
                    }
                    else {
                        System.out.println( "You found the exit. You do not have a key to progress.");
                    }
                    break;
                case 'i':
                    switch( (int)( Math.random() * 2) ) {
                        case 0:
                            System.out.println( "You found a Health Potion! You drink it to restore your health." );
                            hero.heal( 25 );
                            break;
                        case 1:
                            System.out.println( "You found a Key!" );
                            hero.pickUpKey();
                            break;
                    }
                    
                    map.reveal(hero.getLoc());
                    map.removeCharAtLoc(hero.getLoc());
                    break;
                case 'm':
                    if( monsterRoom( hero, enGen.generateEnemy( hero.getLevel() ) ) == false) {
                        alive = false;
                    }
                    if(Map.getInstance().getCharAtLoc(hero.getLoc()) != 'n'){
                        roomC = Map.getInstance().getCharAtLoc(hero.getLoc());
                        continue;
                    }
            }

            System.out.println( hero.toString() );
            System.out.println( DIRECTION_MENU );

            userIn = 0;
            if(in.hasNextInt()) {
                userIn = in.nextInt();
            }
            else {
                in.nextLine();
            }

            switch( userIn ) {
                case 1:
                    roomC = hero.goNorth();
                    break;
                case 2:
                    roomC = hero.goSouth();
                    break;
                case 3:
                    roomC = hero.goEast();
                    break;
                case 4:
                    roomC = hero.goWest();
                    break;
                case 5:
                    alive = false;
                    roomC = ' ';
                    break;
            }
        }
        System.out.println( "Game Over ");
    }
}
