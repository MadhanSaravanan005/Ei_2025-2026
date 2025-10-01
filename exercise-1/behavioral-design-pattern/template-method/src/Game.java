package src;

public abstract class Game {


    public final void play() {
        initialize();
        startPlay();
        while (!isGameOver()) {
            playTurn();
        }
        endPlay();
    }

    protected abstract void initialize();
    protected abstract void startPlay();
    protected abstract void playTurn();
    protected abstract boolean isGameOver();
    protected abstract void endPlay();
}
