package com.github.ognen67.gameoflife.mvp;

import java.time.Duration;

public class GameOfLifePresenter {

    private GameOfLifeView view;
    private final GameOfLifeModel model;
    private volatile boolean run = false;
    private volatile long speed = Duration.ofSeconds(1).toMillis();

    public GameOfLifePresenter() {
        model = new GameOfLifeModel();
    }


    public void setView(GameOfLifeView gameOfLifeView) {
        this.view = gameOfLifeView;
    }

    public void start() {
        view.drawView(model.getSize());
        view.drawBoard(model.getBoard());
        startPlayLoop();
    }

    private void startPlayLoop() {
        new Thread(this::playLoop).start();
    }

    private void playLoop() {
        while (true) {
            if (run) {
                view.drawBoard(model.step());
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void flipTile(int i, int j) {
        view.drawBoard(model.flipTile(i, j));
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void playPause() {
        this.run = !run;
    }

    public boolean[][] getBoard(int rows, int columns) {
        model.resizeBoard(rows, columns);
        return model.getBoard();
    }
}
