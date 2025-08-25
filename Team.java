package Fantasy;
import java.util.ArrayList;
import java.util.List;
class Team{

        private String name;
        private List<Player> players;

        public Team(String name){
            this.name = name;
            this.players = new ArrayList<>();
        }

        public String getname(){
            return name;
        }

        public List<Player> getPlayers(){
            return players;
        }

        public void addplayer(Player p){
            players.add(p);
        }

}