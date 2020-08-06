package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        System.out.println("Enter cells: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cells = "         ";
        //cells = cells.replace("_", " ");
        displayTable(cells);
        boolean isX = true;
        while (true) {
            while (true) {
                System.out.println("Enter the coordinates: ");
                String coordinates = bufferedReader.readLine();
                String[] m = coordinates.split(" ");
                try {
                    int line = Integer.parseInt(m[0]);
                    int column = Integer.parseInt(m[1]);
                    if ((line >= 1 && line <= 3) && (column >= 1 && column <= 3)) {
                        int position = ((2 - (column - 1)) * 3) + (line - 1);
                        if (cells.charAt(position) == ' ') {
                            StringBuilder copyOfCells = new StringBuilder(cells);
                            copyOfCells.setCharAt(position, isX ? 'X' : 'O');
                            isX = !isX;
                            cells = copyOfCells.toString();
                            break;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } catch (Exception e) {
                    System.out.println("You should enter number!");
                }
            }
            displayTable(cells);
            if(checkWin(cells)){
                break;
            }
        }
    }
    private static boolean checkWin(String cells) {
        String gameNotFinished = "Game not finished";
        String draw = "Draw";
        String xWins = "X wins";
        String oWins = "O wins";
        String impossible = "Impossible";
        String line1 = cells.substring(0, 3);
        String line2 = cells.substring(3, 6);
        String line3 = cells.substring(6);
        String column1 = cells.charAt(0) + "" + cells.charAt(3) + "" + cells.charAt(6);
        String column2 = cells.charAt(1) + "" + cells.charAt(4) + "" + cells.charAt(7);
        String column3 = cells.charAt(2) + "" + cells.charAt(5) + "" + cells.charAt(8);
        String diag1 = cells.charAt(0) + "" + cells.charAt(4) + "" + cells.charAt(8);
        String diag2 = cells.charAt(2) + "" + cells.charAt(4) + "" + cells.charAt(6);
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < cells.length(); i++) {
            if (cells.charAt(i) == 'X') {
                countX++;
            } else if (cells.charAt(i) == 'O') {
                countO++;
            }
            if ((countX - countO) >= 2 || (countO - countX) >= 2) {
                System.out.println(impossible);
            } else if (line1.equals("XXX") && (line2.equals("OOO") || line3.equals("OOO"))) {
                System.out.println(impossible);
            } else if (line2.equals("XXX") && (line1.equals("OOO") || line3.equals("OOO"))) {
                System.out.println(impossible);
            } else if (line3.equals("XXX") && (line1.equals("OOO") || line2.equals("OOO"))) {
                System.out.println(impossible);
            } else if (column1.equals("XXX") && (column2.equals("OOO") || column3.equals("OOO"))) {
                System.out.println(impossible);
            } else if (column2.equals("XXX") && (column1.equals("OOO") || column3.equals("OOO"))) {
                System.out.println(impossible);
            } else if (column3.equals("XXX") && (column1.equals("OOO") || column2.equals("OOO"))) {
                System.out.println(impossible);
            } else if (line1.equals("OOO") && (line2.equals("XXX") || line3.equals("XXX"))) {
                System.out.println(impossible);
            } else if (line2.equals("OOO") && (line1.equals("XXX") || line3.equals("XXX"))) {
                System.out.println(impossible);
            } else if (line3.equals("OOO") && (line1.equals("XXX") || line2.equals("XXX"))) {
                System.out.println(impossible);
            } else if (column1.equals("OOO") && (column2.equals("XXX") || column3.equals("XXX"))) {
                System.out.println(impossible);
            } else if (column2.equals("OOO") && (column1.equals("XXX") || column3.equals("XXX"))) {
                System.out.println(impossible);
            } else if (column3.equals("OOO") && (column1.equals("XXX") || column2.equals("XXX"))) {
                System.out.println(impossible);
            } else if (line1.equals("XXX") || line2.equals("XXX") || line3.equals("XXX")
                    || column1.equals("XXX") || column2.equals("XXX") || column3.equals("XXX")
                    || diag1.equals("XXX") || diag2.equals("XXX")) {
                System.out.println(xWins);
                return true;
            } else if (line1.equals("OOO") || line2.equals("OOO") || line3.equals("OOO")
                    || column1.equals("OOO") || column2.equals("OOO") || column3.equals("OOO")
                    || diag1.equals("OOO") || diag2.equals("OOO")) {
                System.out.println(oWins);
                return true;
            } else if (cells.contains(" ")) {
                System.out.println(gameNotFinished);
                return false;
            } else {
                System.out.println(draw);
                return true;
            }
        }
        return false;
    }
    private static void displayTable(String cells) {
        System.out.println("----------");
        for (int i = 0; i < cells.length(); i = i + 3) {
            System.out.print("| ");
            System.out.print(cells.charAt(i) + " "
                    + cells.charAt(i + 1) + " "
                    + cells.charAt(i + 2));
            System.out.println(" |");
        }
        System.out.println("----------");
    }
}