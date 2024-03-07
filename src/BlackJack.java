import java.util.*;
import java.util.stream.Collectors;

public class BlackJack {

    public static void main(String[] args) {
        boolean manaCanPlay = true;
        Scanner scanner = new Scanner(System.in);
        Stack<Cards> cardsStack = BlackJack.suffleTrapoula();

        Player player1 = new Player("player1");
        Player mother = new Player("mother");

        player1.getCards().add(cardsStack.pop());
        mother.getCards().add(cardsStack.pop());
        player1.getCards().add(cardsStack.pop());
        mother.getCards().add(cardsStack.pop());
        System.out.println(player1.getName() +player1.getCards());

                Optional<Cards> maxCard = mother.getCards().stream()
                        .max((card1, card2) -> card1.getNumberValue() - card2.getNumberValue());
                if (maxCard.isEmpty()) {
                    System.out.println(mother.getName() +mother.getCards().get(0) + " hidden");
                } else {
                    System.out.println(mother.getName()+ "[" +(maxCard.get()) + ", hidden]");
                }

        PlayState playState = getPlayState(player1.checkPlayer(),mother.checkPlayer() , manaCanPlay);
        player1.checkPlayer();
        mother.checkPlayer();
        System.out.println(playState);
        boolean isPlayerTurn = true;

        while (playState == PlayState.CONTINUE && manaCanPlay) {

            if (isPlayerTurn) {
                System.out.println("Do you want to continue");
                String answer = scanner.nextLine();
                if (Objects.equals(answer, "yes")) {
                    Cards card = cardsStack.pop();
                    player1.getCards().add(card);
                    System.out.println(player1.getCards());

                } else {
                    isPlayerTurn = false;
                }

            } else {
                if (mother.checkPlayer().getSum() < 17) {
                    Cards card = cardsStack.pop();
                    mother.getCards().add(card);
                } else {
                    System.out.println(mother.getCards());
                    manaCanPlay = false;
                }
            }
            playState = getPlayState(player1.checkPlayer(),mother.checkPlayer() ,manaCanPlay);
        }
        System.out.println(playState);
        if(playState!= PlayState.CONTINUE){
            System.out.println(player1.checkPlayer());
            System.out.println(mother.checkPlayer());
        }
    }

    public static Stack<Cards> suffleTrapoula() {
        List<Cards> trapoula = Arrays.asList(Cards.values());
        Collections.shuffle(trapoula);
        Stack<Cards> cardsStack = new Stack<>();
        System.out.println(cardsStack.addAll(trapoula));

        return cardsStack;
    }

//    public static Map<String, List<Cards>> startPlay(Stack<Cards> cardsStack, Player player1, Player mother) {


//        for (Map.Entry<String, List<Cards>> entry : play.entrySet()) {
//            System.out.println(entry.getKey());
//
//            if (Objects.equals(entry.getKey(), MANA)) {
//                List<Cards> manasCards = entry.getValue();
//                Optional<Cards> maxCard = manasCards.stream()
//                        .max((card1, card2) -> card1.getNumberValue() - card2.getNumberValue());
//                if (maxCard.isEmpty()) {
//                    System.out.println(manasCards.get(0) + " hidden");
//                } else {
//                    System.out.println((maxCard.get()) + " hidden");
//                }
//
//            } else System.out.println(entry.getValue());
//        }
//        return play;
//    }



    public static PlayState getPlayState(PlayerState player1, PlayerState mana, boolean manaCanPlay) {

        if (player1.isHasBlackJack() && !mana.isHasBlackJack()) {
            return PlayState.PLAYER_WINS;
        }
        if (!player1.isHasBlackJack() && mana.isHasBlackJack()) {
            return PlayState.MANA_WINS;
        }
        if (player1.isHasBlackJack() && mana.isHasBlackJack()) {
            return PlayState.DRAW;
        }
        if (player1.isBusted() && !mana.isBusted()) {
            return PlayState.MANA_WINS;
        }
        if (!player1.isBusted() && mana.isBusted()) {
            return PlayState.PLAYER_WINS;
        }
        if (player1.isBusted() && mana.isBusted()) {
            return PlayState.DRAW;
        }

        if (!manaCanPlay) {
            if (player1.getSum() > mana.getSum()) {
                return PlayState.PLAYER_WINS;
            } else if (player1.getSum() == mana.getSum()) {
                return PlayState.DRAW;
            } else return PlayState.MANA_WINS;
        }

        return PlayState.CONTINUE;

    }
}
