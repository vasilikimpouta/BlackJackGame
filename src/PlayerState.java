public class PlayerState {

    private final String name;
    private final boolean hasBlackJack;
    private final boolean isBusted;
    private final boolean canDraw;
    private final int sum;


    public PlayerState(String name, boolean hasBlackJack, boolean isBusted, boolean canDraw, int sum) {
        this.name = name;
        this.hasBlackJack = hasBlackJack;
        this.isBusted = isBusted;
        this.canDraw = canDraw;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public boolean isHasBlackJack() {
        return hasBlackJack;
    }

    public boolean isBusted() {
        return isBusted;
    }

    public boolean isCanDraw() {
        return canDraw;
    }

    public int getSum() {
        return sum;
    }


    @Override
    public String toString() {
        return "PlayerState{" +
                "Name=" + name +
                ", hasBlackJack=" + hasBlackJack +
                ", isBusted=" + isBusted +
                ", canDraw=" + canDraw +
                ", sum=" + sum +
                '}';
    }
}
