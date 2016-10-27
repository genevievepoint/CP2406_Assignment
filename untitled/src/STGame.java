import com.sun.media.jfxmedia.events.PlayerStateEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class STGame {
    public static final int NUM_CARDS_TO_DEAL = 8;
    public static STGame currGame;
    public ArrayList<STCard> cards;
    public static int numPlayers;
    public int dealerID;
    public STPlayer[] players;
    public STDeck deck = new STDeck();
    int yourPlayerId;
    public String categoryInPlay;
    public STCard cardInPlay;
    public int humanPlayerID;
    public String categoryChoice;

    public STGame(int numPlayers){
        this.numPlayers = numPlayers;
        deck = new STDeck();

        currGame = this;
    }

    public STGame() {

    }

    public int selectDealer(){
        Random rand = new Random();
        dealerID = rand.nextInt((numPlayers - 1) + 1);
        System.out.println("Dealer ID = " + dealerID);
        return dealerID;
    }

    public boolean validCardToPlay(){
        return true;
    }

    public void dealRandomCardsToEachPlayer(){

        players = new STPlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new STPlayer("PlayerId= " + i);
        }
        for (STPlayer player : players){
            ArrayList<STCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);
        }
    }
    public void selectYouAsPlayer(){
        yourPlayerId = 0;
    }
    public STPlayer getHumPlayer(){
        return players[humanPlayerID];
    }

    public int getNumPlayers(){
        return numPlayers;
    }
    public void playTheGame() {

    }

    public boolean validCardToPlay(STCard card) {
        return true;
    }

    public boolean playCard(STCard card) {
        //play card by human
        //loop over the rest of bots
        STMainGUI.mainUI.reload();
        //and wait 1 sec
        return true;

    }

    public void setCurrentCard(STCard card) {

    }

    public void setHumPlayer() {
        humanPlayerID = 0;
    }

    public void AiTakeTurn(){
        int aiChoice;
        STPlayer aiPlayer = players[CP2406A1.currentPlayer];
        int aiCount = aiPlayer.cards.size();

        if (categoryInPlay == null){
            categoryInPlay = aiChoosesCategory();
        }
        if (cardInPlay == null){
            Random rand = new Random();
            cardInPlay = aiPlayer.cards.remove(rand.nextInt(aiPlayer.cards.size() - 1));
        }
        if (aiPlayer.cards.size() == 0){
            System.out.println("AI Won!");
            System.out.println(finishGame());
        }
        else{
            for (int i = 0; i < aiPlayer.cards.size(); i++){
                aiChoice = i;
                if (aiPlayer.cards.get(aiChoice).getCategory(categoryInPlay) < cardInPlay.getCategory(categoryInPlay)) {
                    System.out.println("AI checking cards in play");
                    aiCount--;
                    if (aiCount == 0){
                        System.out.println("AI cannot play a card");
                        System.out.println("AI picking up a card");
                        STCard extraCard = deck.dealCards(1).remove(0);
                        aiPlayer.cards.add(extraCard);
                        break;
                    }
                }
                else{
                    STCard selectedCard = aiPlayer.cards.remove(aiChoice);
                    System.out.println("AI selecting a card to play \n");
                    System.out.println("AI's choice is: " + selectedCard);
                    cardInPlay = selectedCard;
                    break;
                }
            }
        }
    }
    public int humPlayerTakeTurn(){
        int choice = 0;
        if (categoryInPlay == null) {
            Scanner cardCat = new Scanner(System.in);
            System.out.println("Enter Card Category");
            categoryChoice = cardCat.nextLine();
            boolean choiceError = true;
            while (choiceError) {
                choiceError = checkCardCategory(categoryChoice);
                if (choiceError) {
                    System.out.println("Enter Card Category");
                    categoryChoice = cardCat.nextLine();
                }
            }
            categoryInPlay = categoryChoice;
        }
        Scanner userInput = new Scanner(System.in);
        if (cardInPlay == null) {
            System.out.println("Human Select a card to play\n");
            choice = userInput.nextInt() - 1;
        }
        if (cardInPlay != null) {
            if (isTrumpCard(choice)) {
                if (cardInPlay.getTitle().equals("The Miner")) {
                    categoryInPlay = "Economic value";
                }
                if (cardInPlay.getTitle().equals("The Petrologist")) {
                    categoryInPlay = "Crustal abundance";
                }
                if (cardInPlay.getTitle().equals("The Mineralogist")) {
                    categoryInPlay = "Cleavage";
                }
                if (cardInPlay.getTitle().equals("The Geophysicist")) {
                    categoryInPlay = "Specific Gravity";
                } else {
                    categoryInPlay = categoryChoice;
                }
            }
            System.out.println("Human Select a card to play\n");
            choice = userInput.nextInt() - 1;
            boolean errorInCard = true;
            while (errorInCard) {
                errorInCard = checkIfCardCanBePlayed(choice);
                if (errorInCard) {
                    System.out.println("Error in card");
                    System.out.println("Human select a Card to play");
                    choice = userInput.nextInt() - 1;
                }
            }
        }
        cardInPlay = players[0].cards.remove(choice);//removes users card they just played

        if (players[0].cards.size() == 0) {// if player has 0 cards, the game is finished and the player wins
            System.out.println(finishGame());
        }
        return choice;
    }


    protected static void printCards(STPlayer player){
        int cardNumber = 1;
        for (STCard card : player.cards){
            System.out.println("\nCard: " + cardNumber);
            System.out.println(card);
            cardNumber += 1;
        }
    }

    public String finishGame() {
        System.out.println("CONGRATULATIONS you are the first player to play all your cards! You WIN!");
        System.exit(1);
        return "You Just WON!";
    }

    public boolean checkCardCategory(String categoryChoice) {
        if (categoryChoice.equals("Hardness") || (categoryChoice.equals("Specific Gravity") ||
                (categoryChoice.equals("Cleavage") || (categoryChoice.equals("Crustal abundance") || (categoryChoice.equals("Economic value")))))) {
            return false;
        }
        System.out.println("Category error");
        return true;
    }

    public boolean checkIfCardCanBePlayed(int choice) {

        if (choice == 100) {// enter 101 to skip turn
            skipTurn();
//            return false;
        }
        if (players[0].cards.size() <= choice || choice < 0) {
            System.out.println("Cannot play this card, the card number is out of range");
            return true;
        }
        if (isTrumpCard(choice)) {
            return false;
        }
        if (players[0].cards.get(choice).getCategory(categoryInPlay) <= cardInPlay.getCategory(categoryInPlay)) {
            System.out.println("Cannot play this card, the card category value is too low");
            return true;
        }
        return false;
    }

    public boolean isTrumpCard(int choice) {
        STCard card = players[0].cards.get(choice);
        return card.getCardType().equals("trump");
    }

    public static void setNumPlayers(int numberOfPlayers) {
        numPlayers = numberOfPlayers;
        System.out.println("num" + numPlayers);
    }

    public String aiChoosesCategory() {
        String[] aiCategoryChoice = {"Hardness", "Cleavage", "Specific Gravity", "Crustal abundance", "Economic value"};
        String aiChoiceCat;
        System.out.println("AI is choosing a category:");
        aiChoiceCat = (aiCategoryChoice[new Random().nextInt(aiCategoryChoice.length)]);
        System.out.println(aiChoiceCat);
        return aiChoiceCat;
    }

    public void skipTurn() {
        System.out.println("Skipping Turn");
        addCard();
        CP2406A1.playTheGame();
    }

    public void addCard() {
        STCard extraCard = deck.dealCards(1).remove(0);
        players[0].cards.add(extraCard);
    }

    public void dealRandomCards() {
        players = new STPlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new STPlayer("Player ID =" + i);
        }
        for (STPlayer player : players) {
            ArrayList<STCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);
        }
    }
}
