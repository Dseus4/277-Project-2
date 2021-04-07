/**
  * Used either by the MagicalEnemy entity and Hero entity to choose from a list of magical attacks.
  */

interface Magical{
    static final String MAGIC_MENU = "1. Magic Missle\n2. Fireball\n3. Thunderclap";
    public String magicMissle( Entity e );
    public String fireball( Entity e );
    public String thunderclap( Entity e );
}