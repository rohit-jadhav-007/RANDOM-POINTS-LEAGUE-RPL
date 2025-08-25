package Fantasy;
import java.util.*;

class Match{

    private List<Player> allPlayers;

    public Match(){
        this.allPlayers = new ArrayList<>();
        createPlayer();
    }

    public List<Player> getAllPlayer(){
        return allPlayers;
    }

    public void createPlayer(){
        int id = 1;

        //<-------------TEAM 1 ------------->

        allPlayers.add(new Player(id++, "Player A1", "GOALKEEPER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A2", "DEFENDER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A3", "DEFENDER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A4", "DEFENDER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A5", "DEFENDER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A6", "MIDFIELDER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A7", "MIDFIELDER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A8", "MIDFIELDER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A9", "ATTACKER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A10", "ATTACKER", "TeamA"));
        allPlayers.add(new Player(id++, "Player A11", "ATTACKER", "TeamA"));

        //<-------------TEAM 2 ------------->

        allPlayers.add(new Player(id++, "Player B1", "GOALKEEPER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B2", "DEFENDER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B3", "DEFENDER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B4", "DEFENDER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B5", "DEFENDER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B6", "MIDFIELDER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B7", "MIDFIELDER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B8", "MIDFIELDER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B9", "ATTACKER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B10", "ATTACKER", "TeamB"));
        allPlayers.add(new Player(id++, "Player B11", "ATTACKER", "TeamB"));

    }

    public void simulateMatch(){
        Random rand = new Random();
        for(int i = 0; i<allPlayers.size();i++){
            Player p = allPlayers.get(i);
            p.generatePerformance(rand);
        }
    }

    public void displayAllPlayers(){
        for(Player p : allPlayers){
            System.out.println(p);
        }
    }
}