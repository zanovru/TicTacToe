package xo.controllers;

import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.getFieldSize(); x++) {
            countFigure += countFiguresInTheRow(field, x);
        }

        if (countFigure == field.getFieldSize() * field.getFieldSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;
        else
        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final int row) {
        int countFigure = 0;
        for (int x = 0; x < field.getFieldSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}
