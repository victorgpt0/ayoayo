public class Player {
    private String name;
    private int store;
    private int[] pit;

    public Player(String name, int store, int[] pit){
        this.name = name;
        this.store = store;
        this.pit = pit;
    }

    public String getName(){
        return name;
    }

    public int getStore(){
        return store;
    }

    public int[] getPit(){
        return pit;
    }

    public void addToStore(int seeds){
        store += seeds;
    }

    public void addToPit(int index, int seeds){
        pit[index] += seeds;
    }

    public void removeFromStore(int seeds){
        if(store >= seeds){
            store -= seeds;
        } else{
            System.out.println("Not enough seeds in store to remove.");
        }
    }

    public void removeFromPit(int index, int seeds){
        if(pit[index] >= seeds){
            pit[index] -= seeds;
        } else{
            System.out.println("Not enough seeds in pit to remove.");
        }
    }

    public int emptyPit(int index){
        int seeds = pit[index];
        pit[index] = 0;
        return seeds;
    }

    public boolean isEmptyPits(){
        for(int seeds : pit){
            if(seeds != 0){
                return false;
            }
        }
        return true;
    }
}
