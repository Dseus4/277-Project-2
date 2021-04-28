public abstract class EnemyDecorator extends Enemy{

    protected Enemy enemy;
    public EnemyDecorator( Enemy e, String n, int h) {
        super( n + e.getName(), e.getMaxHP() + h );
        enemy = e;
    }

    public String attack( Entity e ){
        return ( enemy.attack( e ) );
    }
}
