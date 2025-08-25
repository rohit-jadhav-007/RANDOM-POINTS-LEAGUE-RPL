package Fantasy;
import java.util.Random;

class Player{

    private int id;
    private String name;
    private String role;
    private String team;
    private int points;

    Player(int id, String name, String role, String team){
        this.id = id;
        this.name  =name;
        this.role = role;
        this.team = team;
        this.points = 0;
    }

    public void generatePerformance(Random rand){
        this.points = rand.nextInt(101);
    }

    
    public int getPoints(){
        return points; 
    }
    public String getRole(){
        return role; }
    public String getTeam(){
        return team;
    }
    public int getId(){
        return id;    
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return id + ". " + name + " (" + role + ", " + team + ") Points: " + points;
    }
}