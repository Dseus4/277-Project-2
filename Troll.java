public class Troll extends Enemy {
    public Troll() {
        super("Troll",5);
    }
    public String attack( Entity e ){
        int d = (int)( Math.random() * 6 );
        e.takeDamage( d );
        return "attacks " + e.getName() + " for " + d + " damage.";
    }
}
