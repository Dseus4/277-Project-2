public class Warlock extends EnemyDecorator implements Magical {
    public Warlock( Enemy e ) {
        super( e.getName(), e.getMaxHP() + 1 ); // adds 1 to the maxHP of the warlock
        
    }
        /**
     * Magic missle attack by the Warlock against entity e (1-6).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String magicMissle( Entity e ) {
        int d = (int)( Math.random() * 3 );
        e.takeDamage( d );
        return getName() + " shoots " + e.getName() + " with Magic Missles for " + d + " damage.";
    }

    /**
     * Fireball attack by the Warlock against entity e(2-5).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String fireball( Entity e ) {
        int d = (int)( Math.random() * 4 );
        e.takeDamage(d);
        return getName() + " hits " + e.getName() + " with Fireball for " + d + " damage.";
    }

    /**
     * Thunderclap attack by the Warlock against entity e(3-4).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String thunderclap( Entity e ) {
        int d = (int)( Math.random() * 3 ) + 1;
        e.takeDamage( d );
        return getName() + " zaps " + e.getName() + " with Thunderclap for " + d + " damage.";
    }
    
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
        return super.attack( e ) + out;
    }

    public String getName() {
        return super.getName() + " Warlock";
    }
}
