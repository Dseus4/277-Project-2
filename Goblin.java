/**
 * Is an enemy with 2 health and 1-2 attack to fight against the player.
 */
public class Goblin extends Enemy {
    /**
     * Constructs Goblin as an enemy with its base name and 2 health
     */
    public Goblin() {
        super("Goblin",2);
    }

    /**
     * Physical attack by the Goblin against Hero entity e (1-2).
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the Hero entity
     */
    public String attack( Entity e ){
        int d = (int)( Math.random() * 2 ) + 1 ;
        e.takeDamage( d );
        return "attacks " + e.getName() + " for " + d + " damage.";
    }
}
