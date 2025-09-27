package src;

public class Football extends Game {
    private int turns = 0;
    private final int maxTurns = 3; // simulate few turns

    @Override
    protected void initialize() {
        System.out.println("Football Game Initialized. Setting up field and rules.");
    }

    @Override
    protected void startPlay() {
        System.out.println("Kick-off! Football Game Started.");
    }

    @Override
    protected void playTurn() {
        System.out.println("Football Turn: Dribble, pass, shoot, defend.");
        turns++;
    }

    @Override
    protected boolean isGameOver() {
        return turns >= maxTurns;
    }

    @Override
    protected void endPlay() {
        System.out.println("Football Game Over. Whistle blown!");
    }
}
