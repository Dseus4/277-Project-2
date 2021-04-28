public class Warrior extends EnemyDecorator {
    public Warrior( Enemy e ) {
        super( e, "Warrior", 2 );
    }

    public String attack( Entity e ){
        int d = (int)( Math.random() * 3 ) + 1;
        e.takeDamage( d );
        return super.attack( e ) + '\n' + getName() + " attacks " + e.getName() + " for " + d + " damage.\n";
    }

    public String getName() {
        return super.getName() + " Warrior";
    }
}
