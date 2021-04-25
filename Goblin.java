

public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin",2);
    }
    public String attack( Entity e ){
        int d = (int)( Math.random() * 2 ) + 1 ;
        e.takeDamage( d );
        return getName() + " attacks " + e.getName() + " for " + d + " damage.";
    }
}
