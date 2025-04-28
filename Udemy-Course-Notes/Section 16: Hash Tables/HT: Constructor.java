// THIS GOES IN YOUR MAIN CLASS TO TEST YOUR CODE:
// -----------------------------------------------



public class Main {

    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();

        myHashTable.printTable();
        
        
        /*
            EXPECTED OUTPUT:
            ----------------
            0:
            1:
            2:
            3:
            4:
            5:
            6:

    	*/
      
    }

}





// THIS CODE GOES IN YOUR HASHTABLE CLASS:
// ---------------------------------------
      



public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

}
