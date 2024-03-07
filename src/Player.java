import java.util.ArrayList;
import java.util.List;

public class Player {

    private final  String name;
    private final  List<Cards> cards;


    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public  PlayerState checkPlayer() {

        int sum = 0;
        boolean hasBlackJack = false;
        if (cards.size() == 2) {
            Cards card1 = cards.get(0);
            Cards card2 = cards.get(1);
            hasBlackJack = (card1.isFigoura() && card2.isAssos()) || (card1.isAssos() && card2.isFigoura());
        }

        for (Cards card : cards) {
            sum += card.getNumberValue();
        }

        boolean isBusted = sum > 21;
        boolean canDraw = !hasBlackJack && !isBusted && sum < 21;

        return new PlayerState(this.name, hasBlackJack, isBusted, canDraw, sum);
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}

