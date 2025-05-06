
import java.util.Arrays;

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
        
    }


    public static void main(String[] args) {
        Ayoayo game = new Ayoayo();
        Player p1 = game.createPlayer("Player 1");
        game.setPlayer1(p1);
        Player p2 = game.createPlayer("Player 2");
        game.setPlayer2(p2);
        
        game.printBoard();
    }
}