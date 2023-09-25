public class PlayerLinkedList {
    private PlayerNode head;
    private int size; //Size Variable

    public PlayerLinkedList() {
        this.size = 0;
    }

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);

        head = playerNode;
        size++; // Increase the size when element is added
    }

    public void RemoveFirstElement() {
        if (head == null)
        {
            return;
        }
        head = head.getNextPlayer();
        size--; // Decrease the size when element is removed
    }

    public int GETSize() {
        return size;
    }



    public void printList()
    {
        PlayerNode current = head;
        System.out.print("Head ->");

        while (current != null)
        {
            System.out.print(current);
            System.out.print(" -> ");

            current = current.getNextPlayer();
        }

        System.out.print("null");
    }

    //3

    public boolean contains(Player FindPlayer) {
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(FindPlayer)) {
                return true; // Player Found
            }
            current = current.getNextPlayer();
        }
        return false; // Player not found
    }

    public int indexOf(Player FindPlayer) {
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if (current.getPlayer().equals(FindPlayer)) {
                return index; // Player is found at...
            }
            current = current.getNextPlayer();
            index++;
        }
        return -1; // Player not found
    }
}
