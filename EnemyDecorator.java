/**
 * Increases difficulty and abilities of enemies as player progresses through levels.
 */
public abstract class EnemyDecorator extends Enemy{

    protected Enemy enemy;

    /**
     * Constructs decorated enemy with name, health, and original class.
     * 
     * @param e - Enemy to be decorated
     * @param n - Name of enemy
     * @param h - Health of decorated enemy
     */
    public EnemyDecorator( Enemy e, String n, int h) {
        super( n, h );
        enemy = e;
    }

    /**
     * Physical attack by the enemy against hero entity e.
     * 
     * @param e - The opposing entity being attacked
     * @return - String describing the damage dealt to the opposing entity
     */
    public String attack( Entity e ){
        return ( enemy.attack( e ) );
    }
}
