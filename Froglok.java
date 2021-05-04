/**
 * Is an enemy with 3 health and 1-3 attack to fight against the player.
 */
public class Froglok extends Enemy {
    /**
     * Constructs Froglok as an enemy with its base name and 3 health
     */
    public Froglok() {
        super("Froglok",3);
    }

    /**
     * Physical attack by the Froglok against Hero entity e (1-3).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the Hero entity
     */
    public String attack( Entity e ){
        int d = (int)( Math.random() * 3 ) + 1;
        e.takeDamage( d );
        return "attacks " + e.getName() + " for " + d + " damage.";
    }
}
