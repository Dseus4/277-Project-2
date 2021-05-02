

public class Froglok extends Enemy {
    public Froglok() {
        super("Froglok",3);
    }

    public String attack( Entity e ){
        int d = (int)( Math.random() * 3 ) + 1;
        e.takeDamage( d );
        return "attacks " + e.getName() + " for " + d + " damage.";
    }
}
