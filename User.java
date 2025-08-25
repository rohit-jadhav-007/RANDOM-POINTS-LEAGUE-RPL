package Fantasy;
import java.util.ArrayList;
import java.util.List;
class User{
    
    private String username;
    private List<Player> team;
    private int totalPoints;

    public User(String username){
        this.username = username;
        this.team = new ArrayList<>();
        this.totalPoints = 0;
    }

    public String getusername(){
        return username;
    }

    public List<Player> getTeam(){
        return team;
    }

    public int gettotalPoints(){
        return totalPoints;
    }

    public void addPlayer(Player p) {
        team.add(p);
    }

    public void calculateTotalPoints(){
        totalPoints = 0;
        for (Player p : team) {
            totalPoints += p.getPoints();
        }
    }

}