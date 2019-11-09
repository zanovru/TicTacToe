package xo;

import xo.model.Field;
import xo.model.Figure;
import xo.model.Game;
import xo.model.Player;
import xo.view.ConsoleView;

import java.util.Scanner;

public class CLI {

    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Player 1, enter your name: ");
        final String name1 = in.nextLine();
        System.out.print("Player 2, enter your name: ");
        final String name2 = in.nextLine();

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(), "Tic-Tac-Toe");

        final ConsoleView consoleView = new ConsoleView();

        do {
            consoleView.show(gameXO);
        } while(consoleView.move(gameXO));
    }
}
