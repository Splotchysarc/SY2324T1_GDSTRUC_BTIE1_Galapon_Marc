import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardStacks
{
    private final Stack<Card> stack = new Stack<>();

    public void push(Card card)
    {
        stack.push(card);
    }

    public Card pop()
    {
        return stack.pop();
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public int size()
    {
        return stack.size();
    }

    public Card peek()
    {
        return stack.peek();
    }

    public void shuffle()
    {
        Collections.shuffle(stack);
    }

    public void addAll(List<Card> cards)
    {
        stack.addAll(cards);
    }
}
