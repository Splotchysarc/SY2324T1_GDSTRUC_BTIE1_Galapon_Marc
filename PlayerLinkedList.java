public class PlayerLinkedList {
    private PlayerNode head;

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);

        head = playerNode;
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
}
