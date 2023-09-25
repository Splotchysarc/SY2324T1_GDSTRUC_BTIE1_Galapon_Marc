import java.util.Objects;

public class Player {
    private int ID;
    private String name;
    private int level;

    public Player(int ID, String name, int level) {
        this.ID = ID;
        this.name = name;
        this.level = level;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ID=" + ID +
                ", name=" + name +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return ID == player.ID && level == player.level && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, level);
    }
}

PlayerLinkedList.java
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
