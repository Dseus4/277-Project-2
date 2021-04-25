public class Warrior extends EnemyDecorator {
    public Warrior( Enemy e ) {
        super( e );
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
