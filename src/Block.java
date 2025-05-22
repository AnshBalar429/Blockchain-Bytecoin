import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public Long timestamp;
    public int nonce;

    public String calculateHash() {
        String hash = StringUtil.applySHA256(this.previousHash
                + Long.toString(this.timestamp) + Integer.toString(nonce) + this.data);
        return hash;
    }

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }
}
