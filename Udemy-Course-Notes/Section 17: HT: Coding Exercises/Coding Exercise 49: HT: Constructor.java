public class HashTable {

    private Node[] dataMap;  // Class variable

    // Node class
    public static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Constructor
    public HashTable() {
        dataMap = new Node[7]; // Size 7 to match expected output
    }

    public Node[] getDataMap() {
        return dataMap;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    // main method inside HashTable class
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
