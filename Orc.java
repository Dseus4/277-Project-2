/**
 * Is an enemy with 4 health and 0-4 attack to fight against the player.
 */
public class Orc extends Enemy {
    /**
     * Constructs Orc as an enemy with its base name and 4 health
     */
    public Orc() {
        super("Orc",4);
    }

    /**
     * Physical attack by the Orc against Hero entity e (0-4).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the Hero entity
     */
    public String attack( Entity e ){
        int d = (int)( Math.random() * 5 );
        e.takeDamage( d );
        return "attacks " + e.getName() + " for " + d + " damage.";
    }
}
