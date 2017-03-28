package com.github.aelmod.cligrid;

import com.github.aelmod.cligrid.Util.ConsoleUtils;

import java.io.FileNotFoundException;

public class App {

    public static void main(String... args) throws FileNotFoundException {
        String[][] strings = new String[][]{{"*", "*"}, {"*"}, {"*", "*", "*"}, {"1234"}};

        String[][] strings2 = new String[][]{
                {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
                {"", "", "", "1", "2", "3", "4"},
                {"5", "6", "7", "8", "9", "10", "11"},
                {"12", "13", "14", "15", "16", "17", "18"},
                {"19", "20", "21", "22", "23", "24", "25"},
                {"26", "27", "28", "29", "30", "31"},
        };

        Grid grid = new Grid(System.out, 11, 1);
        grid.setHeaderFormatter((cell, rowNumber, columnNumber) -> {
            if (columnNumber == 0) return ConsoleUtils.Color.red(cell);
            if (columnNumber % 2 == 0) return ConsoleUtils.Color.purple(cell);
            return cell;
        });
        grid.setCellFormatter((cell, rowNumber, columnNumber) -> {
            if (cell.equals("28")) return ConsoleUtils.Color.yellow(cell);
            if (columnNumber == 0) return ConsoleUtils.Color.red(cell);
            if (columnNumber % 2 == 0) return ConsoleUtils.Color.purple(cell);
            if (rowNumber % 2 == 0) return ConsoleUtils.Color.blue(cell);
            return cell;
        });
        grid.render(strings2);
    }
}
