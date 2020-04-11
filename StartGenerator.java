import java.util.HashSet;
import java.util.Set;

public class StartGenerator {

    int[][] startState;
    Set<Integer> included;

    public StartGenerator(int size) {
        if (checkSize(size))            
            this.startState = new int[size][size];
        else 
            this.startState = new int[1][1];
        this.included = new HashSet<Integer>();
    }

    public StartGenerator(int sizeX, int sizeY) {
        if (checkSize(sizeX) || checkSize(sizeY))                
            this.startState = new int[sizeX][sizeY];
        else 
            this.startState = new int[1][1];
        this.included = new HashSet<Integer>();
    }

    public void add(int number, int y, int x) throws Exception {
        
        if(number < 1)
            throw new Exception("Number less than one!");
        else if(this.included.contains(number))
            throw new Exception("Number already added!");
        else if(x > startState.length -1 || y > startState.length - 1)
            throw new Exception("Invalid X or Y coord!");
        else {
            if(this.startState[x][y] == 0){
                this.startState[x][y] = number;
                this.included.add(number); 
            } else
                throw new Exception("Number already added at this postion");
        }
    }

    private boolean checkSize(int size){
        if(size < 1)
            return false;
        return true;
    }

    public int[][] genStart(){
        return this.startState;
    }
}