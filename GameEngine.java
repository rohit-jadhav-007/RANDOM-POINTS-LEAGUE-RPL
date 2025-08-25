package Fantasy;
import java.util.*;

class GameEngine{

    private static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){

        Match match = new Match();
        List<User> users = new ArrayList<>();
        System.out.println("ENTER NUMBER OF USER : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("ENTER USERNAME : ");
            String name = sc.nextLine();

            User user = new User(name);
            users.add(user);

            selectTeam(user, match.getAllPlayer());
        }

        match.simulateMatch();

        System.out.println("<--------- MATCH SUMMARY --------->");
        System.out.println();
        match.displayAllPlayers();

        for (User u : users) {
            u.calculateTotalPoints();
        }

        System.out.println();
        System.out.println("<--------- User Teams & Points --------->");
        for(User u:users){
            System.out.println();
            System.out.println(u.getusername() + "'s TEAM");
            for(Player p : u.getTeam()){
                System.out.println(p);
            }
            System.out.println();
            System.out.println("--------- TOTAL POINTS = "+ u.gettotalPoints() + "---------");
            System.out.println();
        }

        users.sort((a, b) -> b.gettotalPoints() - a.gettotalPoints());


        System.out.println("<----------- LEADERBOARD ----------->");
        for(int i = 0; i<users.size();i++){
            System.out.println((i + 1) + ". " + users.get(i).getusername() + " --> " + users.get(i).gettotalPoints() + " POINTS");
        }
        System.out.println();
        System.out.println("WINNER IS " + users.get(0).getusername() + " WITH " + users.get(0).gettotalPoints() + " POINTS");

    }


    private static void selectTeam(User user, List<Player> allPlayers){
        while(true){
            user.getTeam().clear();
            System.out.println();
            System.out.println(user.getusername() + "<--------- SELECT  11 PLAYERS BY ID --------->");

            for(Player p : allPlayers){
                System.out.println(p.getId() + ", " + p.getName() + ", " + p.getRole() + ", " + p.getTeam());
            }

            ArrayList<Integer> chooseIds = new ArrayList<>();

            for(int i = 0; i<11;i++){
                System.out.print("SELECT PLAYER " + (i+1) + ": ");
                int id = sc.nextInt();

                while(id < 1 || id > 22 || chooseIds.contains(id)){
                    System.out.print("InValid Id / ID ALREADY EXIST");
                    id = sc.nextInt();
                }
                chooseIds.add(id);
                user.addPlayer(allPlayers.get(id-1));
            }
            if(validateteam(user.getTeam())){
                System.out.println("<--------- TEAM SELECTED SUCCESSFULLY --------->");
                System.out.println();
                break;
            }else{
                System.out.println("<--------- INVALID TEAM, PLEASE RESELECT --------->");
                System.out.println();
            }
        }
        sc.nextLine();
    }

    private static boolean validateteam(List<Player> team){

        int gk = 0;
        int def = 0;
        int mid = 0;
        int atk = 0;
        int teamA = 0;
        int teamB = 0;

        for(Player p: team){
            switch(p.getRole()){
                case "GOALKEEPER":
                    gk++;
                    break;
                
                case "DEFENDER":
                    def++;
                    break;
                
                case "MIDFIELDER":
                    mid++;
                    break;

                case "ATTACKER":
                    atk++;
                    break;
            }
            if(p.getTeam().equals("TeamA")) teamA++;
            else teamB++;
        }
        return (team.size()==11 && 
                gk == 1 && 
                def >=4 && def<=5 &&
                mid >=3 && mid<=5 &&
                atk >=1 && atk<=3 &&
                teamA>=4 && teamB<=7 &&
                teamB>=4 && teamA<=7);

    }
}