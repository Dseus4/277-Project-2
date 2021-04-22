
/**
 * Player Controlled Entity Class
 */

class Hero extends Entity implements Magical{
    private Map map = Map.getInstance();
    private java.awt.Point loc = new java.awt.Point();
    private int level = 1;
    private int key = 0;
    private int gold = 0;
    /**
     * Construct hero with 25 health and place hero in map 1.
     * 
     * @param n - Name of hero
     */
    public Hero( String n ) {
        super( n , 25 );
        map.loadMap( 1 );
        loc = map.findStart();
    }

    /**
     * Generates string of Hero's info with structure:
     * <p>
     * Hp:[hp]/[maxHp]<br>
     * Level:[level]<br>
     * x x x x x<br>
     * x x x x x<br>
     * x x x x x<br>
     * x x x x x<br>
     * x x x x x
     * </p>
     * 
     * @return - String representation of Hero
     */
    public String toString() {
        return 
            super.toString() +
            "\nLevel: " + level +
            "\n" + map.mapToString( loc );
    }

    /**
     * Upon leveling up, a new map will be loaded and the level will be increased
     */
    public void levelUp() {
        level = ( level ) % 3 + 1;
        map.loadMap( level );
    }

    /**
     * The user chooses to go North on the map from their current position
     * 
     * @return out - Room char of new location.
     */
    public char goNorth() {
        if( loc.x > 0 ) {
            loc.x--;
            
            char out = map.getCharAtLoc( loc );
        
            return out;
      }
      return 'x';
    }

    /**
     * The user chooses to go South on the map from their current position
     * 
     * @return out - Room char of new location.
     */
    public char goSouth() {
        if( loc.x < 4 ) {
              loc.x++;
              
              char out = map.getCharAtLoc( loc );
              
              return out;
        }
        return 'x';
    }

    /**
     * The user chooses to go East on the map from their current position
     * 
     * @return out - Room char of new location.
     */
    public char goEast() {
        if( loc.y < 4 ) {
            loc.y++;
            
            char out = map.getCharAtLoc( loc );
            
            return out;
        }
        return 'x';
    }

    /**
     * The user chooses to go West on the map from their current position
     * 
     * @return out - Room char of new location.
     */
    public char goWest() {
        if(loc.y > 0) {
            loc.y--;
            
            char out = map.getCharAtLoc( loc );
            
            return out;
        }
        return 'x';
    }

    /**
     * Used when trying to exit floor
     * 
     * @return - if hero has any keys
     */
    public boolean hasKey() {
        return key > 0;
    }

    /**
     * Used when user buys key at a store or in an item room
     * 
     */
    public void pickUpKey() {
        key++;
    }

    /**
     * When player tries to exit floor
     * 
     * @return - If player successfully uses key
     */
    public boolean useKey() {
        if (hasKey()) {
            key--;
            return true;
        }
        return false;
    }

    /**
     * Physical attack by the Hero against entity e (1-4).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String attack( Entity e ) {
        int d = (int)( Math.random() * 4 ) + 1;
        e.takeDamage(d);
        return getName() + " attacks " + e.getName() + " for " + d + " damage.";
    }

    /**
     * Magic missle attack by the Hero against entity e (1-6).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String magicMissle( Entity e ) {
        int d = (int)( Math.random() * 6 )+ 1;
        e.takeDamage(d);
        return getName() + " shoots " + e.getName() + " with Magic Missles for " + d + " damage.";
    }

    /**
     * Fireball attack by the Hero against entity e(2-5).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String fireball( Entity e ) {
        int d = (int)( Math.random() * 4 )+ 2;
        e.takeDamage(d);
        return getName() + " hits " + e.getName() + " with Fireball for " + d + " damage.";
    }

    /**
     * Thunderclap attack by the Hero against entity e(3-4).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String thunderclap( Entity e ) {
        int d = (int)( Math.random() * 2 )+ 3;
        e.takeDamage(d);
        return getName() + " zaps " + e.getName() + " with Thunderclap for " + d + " damage.";
    }
    /**
    * getGold returns gold
    *
    *@return - amount of gold hero has currently
    */
    public int getGold(){
        return gold;
    }
    /**
    * collectedGold - adds g to gold when hero finds gold
    *
    *@Param g - amount of gold hero has found
    */
    public void collectGold(int g){
        gold += g;
    }
    /**
    *spendGold - subtracts g from gold when hero spends gold
    *
    *@Param g - amount of gold Hero spends
    */
    public void spendGold(int g){
        gold -= g;
    }

    public int getLevel(){
        return level;
    }
    
    public java.awt.Point getLoc(){
        return loc;
    
    }
    
}
    
