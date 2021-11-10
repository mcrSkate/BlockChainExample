import java.util.Vector;

public class HashSystem implements BlockChain{

    private Vector<Integer> hashHistoric;
    private Vector<String> textHistoric;
    private Integer currentHash;

    public HashSystem(){
        this.hashHistoric = new Vector<Integer>();
        this.textHistoric = new Vector<String>();
        this.currentHash = 0;
    }

    public void addBlock(String whatWasDone){
        Block block = new Block(whatWasDone, currentHash);
        this.currentHash = block.getHash();
        this.hashHistoric.add(this.currentHash);
        this.textHistoric.add(whatWasDone);
    }

    public String getHistoric() {

        String aux = "";
        for(int i=0;i<this.hashHistoric.size();i++){
            aux += this.textHistoric.get(i) + "\n" + this.hashHistoric.get(i)+"\n";
        }
        return aux;
    }
}
