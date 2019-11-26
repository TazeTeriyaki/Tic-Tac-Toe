import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] field = new String[3][3];

        boolean xWin = false;
        boolean yWin = false;
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                field[i][j] = "_" + "";
                System.out.print(field[i][j] +" ");
            }
            System.out.println("|");

        }
        System.out.println("---------");

        int turn = 1;
        while (true) {
            int x = 0;
            int y = 0;

            boolean bError = true;

            while (bError) {
                System.out.println("Enter the coordinates:");
                if (scanner.hasNextInt())
                    x = scanner.nextInt();
                else {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                    continue;
                }
                if (scanner.hasNextInt())
                    y = scanner.nextInt();
                else {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                    continue;
                }
                bError = false;
            }


            if (y == 1) {
                y = 2;
            } else if (y == 2) {
                y = 1;
            } else if (y == 3) {
                y = 0;
            }
            if (x > 3 || x < 1 || y > 2 || y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (field[y][x - 1].equals("X") || field[y][x - 1].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else if (turn % 2 == 1) {
                field[y][x - 1] = "X";
                turn++;
            } else if (turn % 2 == 0) {
                field[y][x - 1] = "O";
                turn++;
            }

            System.out.println("---------");

            for (int i = 0; i < field.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j].equals("X")) {
                        System.out.print("X ");
                    }
                    if (field[i][j].equals("O")) {
                        System.out.print("O ");
                    }
                    if (field[i][j].equals(" ")) {
                        System.out.print("  ");
                    } else if (field[i][j].equals("_")) {
                        System.out.print("_ ");
                    }
                }
                System.out.println("|");

            }
            System.out.println("---------");


            if (field[0][0].equals("X") && field[0][0].equals(field[0][1]) && field[0][0].equals(field[0][2])) {
                xWin = true;
            } else if(field[1][0].equals("X") && field[1][0].equals(field[1][1]) && field[1][0].equals(field[1][2])) {
                xWin = true;
            } else if(field[2][0].equals("X") && field[2][0].equals(field[2][1]) && field[2][0].equals(field[2][2])) {
                xWin = true;
            } else if(field[0][0].equals("X") && field[0][0].equals(field[1][0]) && field[0][0].equals(field[2][0])) {
                xWin = true;
            } else if(field[0][1].equals("X") && field[0][1].equals(field[1][1]) && field[0][1].equals(field[2][1])) {
                xWin = true;
            } else if(field[0][2].equals("X") && field[0][2].equals(field[1][2]) && field[0][2].equals(field[2][2])) {
                xWin = true;
            } else if(field[0][0].equals("X") && field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2])) {
                xWin = true;
            } else if(field[2][0].equals("X") && field[2][0].equals(field[1][1]) && field[2][0].equals(field[0][2])) {
                xWin = true;
            }

            if (field[0][0].equals("O") && field[0][0].equals(field[0][1]) && field[0][0].equals(field[0][2])) {
                yWin = true;
            } else if(field[1][0].equals("O") && field[1][0].equals(field[1][1]) && field[1][0].equals(field[1][2])) {
                yWin = true;
            } else if(field[2][0].equals("O") && field[2][0].equals(field[2][1]) && field[2][0].equals(field[2][2])) {
                yWin = true;
            } else if(field[0][0].equals("O") && field[0][0].equals(field[1][0]) && field[0][0].equals(field[2][0])) {
                yWin = true;
            } else if(field[0][1].equals("O") && field[0][1].equals(field[1][1]) && field[0][1].equals(field[2][1])) {
                yWin = true;
            } else if(field[0][2].equals("O") && field[0][2].equals(field[1][2]) && field[0][2].equals(field[2][2])) {
                yWin = true;
            } else if(field[0][0].equals("O") && field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2])) {
                yWin = true;
            } else if(field[2][0].equals("O") && field[2][0].equals(field[1][1]) && field[2][0].equals(field[0][2])) {
                yWin = true;
            }

            if (xWin) {
                System.out.println("X wins");
                break;
            } else if (yWin) {
                System.out.println("O wins");
                break;
            } else if (turn == 10) {
                System.out.println("Draw");
                break;
            }
        }
    }
}