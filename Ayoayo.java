public class Ayoayo {

    private final Player[] players;
    private final int[] store;

    public Ayoayo(){
        this.players = new Player[2];
        this.store = new int[2];
    }

    public Player createPlayer(String name){
        return new Player(name);
    }

    public void setPlayer1(Player player){
        this.players[0] = player;
    }

    public void setPlayer2(Player player){
        this.players[1] = player;
    }

    public void printBoard(){
        int index = 0;
        for (Player player : players) {
            System.out.println("player"+ (index + 1) +": " + player.getName() + "\n");
            System.out.println("store: " + store[index] + " seeds\n");
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