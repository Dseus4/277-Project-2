/**
 * Is an enemy with 5 health and 0-5 attack to fight against the player.
 */
public class Troll extends Enemy {
    /**
     * Constructs Troll as an enemy with its base name and 5 health
     */
    public Troll() {
        super("Troll",5);
    }

    /**
     * Physical attack by the Troll against Hero entity e (0-5).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the Hero entity
     */
    public String attack( Entity e ){
        int d = (int)( Math.random() * 6 );
        e.takeDamage( d );
        return "attacks " + e.getName() + " for " + d + " damage.";
    }
}
