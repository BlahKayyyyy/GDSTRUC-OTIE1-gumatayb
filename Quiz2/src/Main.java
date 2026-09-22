public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerList = new PlayerLinkedList();
        playerList.add(new Player(1, "Goku", 500));
        playerList.add(new Player(2, "Saitama", 999));
        playerList.add(new Player(3, "Sakamoto", 10));

        System.out.println("Original List:");
        playerList.printList();

        // size
        System.out.println("Size: " + playerList.size());

        // removeFirst
        Player removed = playerList.removeFirst();
        System.out.println("Removed: " + removed.getName());

        System.out.println("List after removeFirst:");
        playerList.printList();

        // contains
        boolean hasGoku = playerList.contains(new Player(1, "Goku", 500));
        System.out.println("Contains Goku? " + hasGoku);

        // indexOf
        int index = playerList.indexOf(new Player(2, "Saitama", 999));
        System.out.println("Saitama index: " + index);
    }
}