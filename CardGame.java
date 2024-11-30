//package linkedLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;



public class CardGame {
    private static LinkList deck = new LinkList(); // Deck of cards
    private static LinkList playerHand = new LinkList(); // Player's hand

    public static void main(String[] args) {
        // Load cards from a file into the deck
        loadCards("cards.txt");

        // Display the deck
        System.out.println("Initial Deck:");
        deck.displayList();

        // Draw 5 cards for the player's hand
        System.out.println("\nDrawing cards for the player's hand:");
        for (int i = 0; i < 5; i++) {
            if (!deck.isEmpty()) {
                playerHand.add(deck.removeFirst());
            }
        }

        // Display the player's hand
        System.out.println("\nPlayer's Hand:");
        playerHand.displayList();

        // Display the remaining deck
        System.out.println("\nRemaining Deck:");
        deck.displayList();
    }

    // Load cards from a file
    private static void loadCards(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 4) {
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    Card card = new Card(suit, name, value, pic);
                    deck.add(card);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}