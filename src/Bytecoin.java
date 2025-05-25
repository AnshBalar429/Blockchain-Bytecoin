import java.util.ArrayList;

public class Bytecoin {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

    public static void main(String[] args) {
        blockchain.add(new Block("This is the first block", "0"));
        blockchain.add(new Block("Yeah I am second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Yo This is third block", blockchain.get(blockchain.size() - 1).hash));

        for (Block block : blockchain) {
            System.out.println(block.hash);
        }
    }

    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for (int i = 1; i < blockchain.size() - 1; i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Block's Hashes are not equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Block's Hashes are not equal");
                return false;
            }

            //checking if hash is solved
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block is not mined");
                return false;
            }
        }

        return true;

    }
}
