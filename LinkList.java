
import java.util.ArrayList;
import java.util.Collections;

public class LinkList {
    private Link first; // Reference to the first link

    // Constructor
    public LinkList() {
        first = null; // Initialize the list as empty
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Add a new card to the front of the list
    public void add(Card card) {
        Link newLink = new Link(card);
        newLink.next = first;
        first = newLink;
    }

    // Remove and return the first card in the list
    public Card removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }
        Link temp = first;
        first = first.next;
        return temp.cardLink;
    }

    // Display all cards in the list
    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    // **Shuffle Method** (Added Here)
    public void shuffle() {
        // Step 1: Extract all cards into an ArrayList
        ArrayList<Card> cardArray = new ArrayList<>();
        while (!isEmpty()) {
            cardArray.add(removeFirst());
        }

        // Step 2: Shuffle the ArrayList
        Collections.shuffle(cardArray);

        // Step 3: Add shuffled cards back to the LinkedList
        for (Card card : cardArray) {
            add(card);
        }
    }
}
