public class Updater implements Runnable {
    private Game game;

    public Updater(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            game.update();
            try {
                Thread.sleep(250);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
