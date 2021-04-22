import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Point;

/**
 * Represents the dungeon Maze where the game will take place as a 5x5 map.
 **/
public class Map{
    
    public char[][] map;
    public boolean[][] revealed;

    /**
     * Constructs empty map
     */
    private Map(){
		map = new char[5][5];
		revealed = new boolean[5][5];
    }
    
    public static Map getInstance(){
	if (instance == null){
	    instance = new Map();
	}

	return instance;
    }

    /**
     * Loads the map for each corresponding level by reading the map txt files
     * accordingly.
     * 
     * @param mapNum - The map number to be loaded
     **/
    public void loadMap(int mapNum){
    	String fileName = "";
        switch( mapNum ) {
    	    case 1:
    	        fileName = "Map1.txt";
                break;
    	    case 2:
    	        fileName = "Map2.txt";
                break;
            case 3:
    	        fileName = "Map3.txt";
                break;
        }
        try{
            File file = new File(fileName);
            Scanner read = new Scanner(file);
            String row;
            
            for( int i = 0; i < map.length; ++i ) {
                row = read.nextLine().replace( " " , "" );
                for( int j = 0; j < map[i].length; ++j ) {
                    map[i][j] = row.charAt( j );
                }
            }
            read.close();
        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        }
        for(int i = 0; i < revealed.length; ++i)
            for(int j = 0; j < revealed[0].length; ++j)
                revealed[i][j] = false;
        reveal( findStart() );

    }

    /**
     * Gets the char located on the map at a specified point.
     * 
     * @param p - Point to get char from
     * @return - Char at p
     **/
    public char getCharAtLoc(Point p){
		return map[p.x][p.y];
    }

    /**
     * Produces the map for the User to keep track of their location.
     * 
     * @param p - Point to draw the User at
     * @return outMap - string representation of the map
     **/
    public String mapToString(Point p){
		String outMap = "";
        for ( int x = 0; x < 5; ++x ) {
            for ( int y = 0; y < 5; ++y ) {
                if (x == p.x && y == p.y){
                    outMap += '*';
                } else if ( revealed[x][y] ) {
                    outMap += map[x][y];
                } else {
                    outMap += 'x';
                }
                outMap += ' ';
            }
            outMap = outMap.substring( 0 , ( outMap.length() - 1 ) ) ;
            outMap += '\n';
        }
        outMap = outMap.substring( 0 , ( outMap.length() - 1 ) ) ;
		return outMap;
    }

    /**
     * Finds where the user starts on the map.
     * 
     * @return - Starting Point
     **/

    public Point findStart(){
		for (int x = 0; x < 5; x++){
			for (int y = 0; y < 5; y++){
				if (map[x][y] == 's'){
                    return new Point(x,y);
				}
			}
		}//end for
		return new Point();
    }

    /**
     * Reveals the specified point
     * 
     * @param p - Point to be revealed
     **/
    public void reveal(Point p){
		revealed[p.x][p.y] = true;
    }

    /**
     * Replaces char at specified point for the purpose of clearing rooms
     * 
     * @param p - Point to be removed/cleared
     **/
    public void removeCharAtLoc(Point p){
        //avoids clearing start and finish
        if( map[p.x][p.y] != 's' && map[p.x][p.y] != 'f') {
		    map[p.x][p.y] = 'n';
        }
    }

}
