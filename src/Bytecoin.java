import java.util.ArrayList;

public class Bytecoin {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        blockchain.add(new Block("This is the first block", "0"));
        blockchain.add(new Block("Yeah I am second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Yo This is third block", blockchain.get(blockchain.size() - 1).hash));

        for (Block block : blockchain) {
            System.out.println(block.hash);
        }
    }
}
