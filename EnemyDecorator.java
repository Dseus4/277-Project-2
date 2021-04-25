public abstract class EnemyDecorator extends Enemy{

    protected Enemy enemy;
    public EnemyDecorator( Enemy e ) {
        super( e.getName() , e.getHP() );
        enemy = e;
    }

    public String attack( Entity e ){
        return ( enemy.attack( e ) );
    }
}