

public class Orc extends Enemy {
    public Orc() {
        super("Orc",4);
    }

    public String attack( Entity e ){
        int d = (int)( Math.random() * 5 );
        e.takeDamage( d );
        return getName() + " attacks " + e.getName() + " for " + d + " damage.";
    }
}
