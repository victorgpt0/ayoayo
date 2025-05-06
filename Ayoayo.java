
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ayoayo {

    private final Player[] players;

    public Ayoayo(){
        this.players = new Player[2];
    }

    public Player createPlayer(String name){
        return new Player(name, 0, new int[]{4, 4, 4, 4, 4, 4});
    }

    public void setPlayer1(Player player){
        this.players[0] = player;
    }

    public void setPlayer2(Player player){
        this.players[1] = player;
    }

    public void playGame(int player, int pit){
        pit = pit - 1;
        player = player - 1;

        if( pit < 0 || pit > 6){
            System.out.println("Invalid number for pit index. /1 - 6 Accepted/");
            return;
        }

        // select a pit and take all seeds from it and add one by one to the next pit
        int seeds = players[player].emptyPit(pit);
        int currentIndex = pit;
        while(seeds > 0 && currentIndex < 5){
            currentIndex++;
            players[player].addToPit(currentIndex, 1);
            seeds--;
        }
        //if last seed is in my pit and that pit is empty, take the seeds from the opponent exactly opposite pit
        if(seeds == 1 && players[player].getPit()[currentIndex] == 0){
            int oppositePit = 5 - currentIndex;
            int oppositeSeeds = players[player + 1].emptyPit(oppositePit);
            players[player].addToStore(oppositeSeeds + seeds);
        }
        //and the rest add to the store
        if(seeds > 0){
            players[player].addToStore(1);
            seeds--;
            System.out.println("player "+ (player + 1) + " take another turn");
        }
        //add the rest to the opponents pits
        currentIndex=0;
        while(seeds > 0 && currentIndex < 5){
            players[player + 1].addToPit(currentIndex, 1);
            currentIndex++;
            seeds--;
        }

    }

    public List<Integer> combinedList(){
        List<Integer> combined = new ArrayList<>();
        for(Player player : players){
            for(int pit : player.getPit()){
                combined.add(pit);
            }
            combined.add(player.getStore());
        }
        return combined;
    }

    public void printBoard(){
        int index = 0;
        for (Player player : players) {
            System.out.println("player"+ (index + 1) +": " + player.getName() + "\n");
            
            System.out.println("store: " + player.getStore() + " seeds\n");
            
            System.out.println(Arrays.toString(player.getPit()) + "\n");
            
            index++;
        }
    }

    public void returnWinner(){
        System.out.println(combinedList());
    }


    public static void main(String[] args) {
        Ayoayo game = new Ayoayo();
        Player p1 = game.createPlayer("Player 1");
        game.setPlayer1(p1);
        Player p2 = game.createPlayer("Player 2");
        game.setPlayer2(p2);

        game.playGame(1,1);
        game.playGame(1,2);
        game.playGame(1,5);


    }
}