import java.util.Vector;

public class Block {

    private String whatWasDone;
    private Integer previousHash;
    private Integer hash;

    public Block(String whatWasDone, Integer previousHash){
        this.whatWasDone = whatWasDone;
        this.previousHash = previousHash;
        Vector<Integer> firstHashing = new Vector<Integer>();
        firstHashing.add(whatWasDone.hashCode());
        firstHashing.add(previousHash);
        this.hash = firstHashing.hashCode();
    }

    public String getwhatWasDone() {
        return this.whatWasDone;
    }

    public Integer getPreviousHash() {
        return this.previousHash;
    }

    public Integer getHash() {
        return this.hash;
    }
}
