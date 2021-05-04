public class Warlock extends EnemyDecorator implements Magical {
    
    /**
     * Constructs decorated enemy with name, health, and original class.
     * 
     * @param e - Enemy to be decorated
     */
    public Warlock( Enemy e ) {
        super( e , e.getName() , e.getMaxHP() + 1 );
        
    }
        /**
     * Magic missle attack by the Warlock against entity e (0-2).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String magicMissle( Entity e ) {
        int d = (int)( Math.random() * 3 );
        e.takeDamage( d );
        return "shoots " + e.getName() + " with Magic Missles for " + d + " damage.";
    }

    /**
     * Fireball attack by the Warlock against entity e(0-3).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String fireball( Entity e ) {
        int d = (int)( Math.random() * 4 );
        e.takeDamage(d);
        return "hits " + e.getName() + " with Fireball for " + d + " damage.";
    }

    /**
     * Thunderclap attack by the Warlock against entity e(1-3).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String thunderclap( Entity e ) {
        int d = (int)( Math.random() * 3 ) + 1;
        e.takeDamage( d );
        return "zaps " + e.getName() + " with Thunderclap for " + d + " damage.";
    }
    
    /**
     * String attack method that randomly selects a spell for the Enemy to do.
     * 
     * @param e - The opposing entity being attacked
     * @return - String spell describing the damage dealt to the opposing entity
     */
    public String attack( Entity e ) {
        String out = "";
        switch( (int)( Math.random() * 3 ) ){
            case 0:
                out = magicMissle( e );
                break;
            case 1:
                out = fireball( e );
                break;
            case 2:
                out = thunderclap( e );
                break;
        }
        return super.attack( e ) + "\n" + out;
    }
    
    /**
     * String method that adds the "Warlock" title decorator to the Enemy's name.
     * 
     * @return - The decorated name of the enemy.
     */
    public String getName() {
        return super.getName() + " Warlock";
    }
}
