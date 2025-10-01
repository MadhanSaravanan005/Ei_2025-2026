package src;

public class Cricket extends Game {
    private int turns = 0;
    private final int maxTurns = 3; 

    @Override
    protected void initialize() {
        System.out.println("Cricket Game Initialized. Setting up pitch and rules.");
    }

    @Override
    protected void startPlay() {
        System.out.println("First ball bowled! Cricket Game Started.");
    }

    @Override
    protected void playTurn() {
        System.out.println("Cricket Turn: Bowl, bat, field, run between wickets.");
        turns++;
    }

    @Override
    protected boolean isGameOver() {
        return turns >= maxTurns;
    }

    @Override
    protected void endPlay() {
        System.out.println("Cricket Game Over. Last ball played!");
    }
}
