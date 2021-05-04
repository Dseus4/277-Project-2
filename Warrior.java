public class Warrior extends EnemyDecorator {
    
    /**
     * Constructs decorated enemy with name, health, and original class.
     * 
     * @param e - Enemy to be decorated
     */
    public Warrior( Enemy e ) {
        super( e , e.getName() , e.getMaxHP() + 2 );
    }
    
    /**
     * String attack method that randomizes an attack to be dealt to the entity and is decorated to the original attack.
     * 
     * @param e - The opposing entity being attacked
     * @return - Decorated string describing the damage dealt to the opposing entity along the super.
     */
    public String attack( Entity e ){
        int d = (int)( Math.random() * 3 ) + 1;
        e.takeDamage( d );
        return super.attack( e ) + '\n' + "attacks " + e.getName() + " for " + d + " damage.";
    }
    
    /**
     * String method that adds the "Warrior" title decorator to the Enemy's name.
     * 
     * @return - The decorated name of the enemy.
     */
    public String getName() {
        return super.getName() + " Warrior";
    }
}
