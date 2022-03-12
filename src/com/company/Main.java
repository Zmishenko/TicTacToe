package com.company;

/*
Вход: XXXOO__O_ / Выход: X wins
Вход: XOXOXOXXO / Выход: X wins
Вход: XOOOXOXXO / Выход: O wins
Вход: XOXOOXXXO / Выход: Draw
Вход: XO_OOX_X_ / Выход: Game not finished
Вход: XO_XO_XOX / Выход: Impossible
Вход: _O_X__X_X / Выход: Impossible
Вход: _OOOO_X_X / Выход: Impossible
*/

import java.util.*;

public class Main {
    static List<Integer> posX = new ArrayList<>();
    static List<Integer> posO = new ArrayList<>();

    static List<Integer> topRow = Arrays.asList(1, 2, 3);
    static List<Integer> midRow = Arrays.asList(4, 5, 6);
    static List<Integer> botRow = Arrays.asList(7, 8, 9);
    static List<Integer> leftCell = Arrays.asList(1, 4, 7);
    static List<Integer> midRoCell = Arrays.asList(2, 5, 8);
    static List<Integer> rigthCell = Arrays.asList(3, 6, 9);
    static List<Integer> cross1 = Arrays.asList(1, 5, 9);
    static List<Integer> cross2 = Arrays.asList(3, 5, 7);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 0;

        System.out.print("Enter cells: ");
        String string = scanner.next();

        String[][] arr = new String[3][3];


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = String.valueOf(string.charAt(n++));
            }
        }


        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("| ");
            System.out.println();
        }
        System.out.println("---------");

        for (int i = 0; i < string.length(); i++) {
            isXorO(arr, i+1);
        }
        System.out.println(isWin());
    }

    private static void isXorO(String[][] arr1, int pos) {
        switch (pos) {
            case 1:
                if (Objects.equals(arr1[0][0], "X")) {
                    posX.add(1);
                } else if (Objects.equals(arr1[0][0], "O")) {
                    posO.add(1);
                }
                break;
            case 2:
                if (Objects.equals(arr1[0][1], "X")) {
                    posX.add(2);
                } else if (Objects.equals(arr1[0][1], "O")) {
                    posO.add(2);
                }
                break;
            case 3:
                if (Objects.equals(arr1[0][2], "X")) {
                    posX.add(3);
                } else if (Objects.equals(arr1[0][2], "O")) {
                    posO.add(3);
                }
                break;
            case 4:
                if (Objects.equals(arr1[1][0], "X")) {
                    posX.add(4);
                } else if (Objects.equals(arr1[1][0], "O")) {
                    posO.add(4);
                }
                break;
            case 5:
                if (Objects.equals(arr1[1][1], "X")) {
                    posX.add(5);
                } else if (Objects.equals(arr1[1][1], "O")) {
                    posO.add(5);
                }
                break;
            case 6:
                if (Objects.equals(arr1[1][2], "X")) {
                    posX.add(6);
                } else if (Objects.equals(arr1[1][2], "O")) {
                    posO.add(6);
                }
                break;
            case 7:
                if (Objects.equals(arr1[2][0], "X")) {
                    posX.add(7);
                } else if (Objects.equals(arr1[2][0], "O")) {
                    posO.add(7);
                }
                break;
            case 8:
                if (Objects.equals(arr1[2][1], "X")) {
                    posX.add(8);
                } else if (Objects.equals(arr1[2][1], "O")) {
                    posO.add(8);
                }
                break;
            case 9:
                if (Objects.equals(arr1[2][2], "X")) {
                    posX.add(9);
                } else if (Objects.equals(arr1[2][2], "O")) {
                    posO.add(9);
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + pos);
        }

    }





    public static String isWin() {
        List<List> win = new ArrayList<>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCell);
        win.add(midRoCell);
        win.add(rigthCell);
        win.add(cross1);
        win.add(cross2);

        if (Objects.equals(posXCheck(), "X wins") && Objects.equals(posOCheck(), "O wins")) {
            return "Impossible";
        } else if(posX.containsAll(topRow)) {
            return "X wins";
        } else if (posX.containsAll(midRow)) {
            return "X wins";
        }  else if (posX.containsAll(botRow)) {
            return "X wins";
        } else if (posX.containsAll(leftCell)) {
            return "X wins";
        } else if (posX.containsAll(midRoCell)) {
            return "X wins";
        } else if (posX.containsAll(rigthCell)) {
            return "X wins";
        } else if (posX.containsAll(cross1)) {
            return "X wins";
        } else if (posX.containsAll(cross2)) {
            return "X wins";
        } else if(posO.containsAll(topRow)) {
            return "O wins";
        } else if(posO.containsAll(midRow)) {
            return "O wins";
        } else if(posO.containsAll(botRow)) {
            return "O wins";
        } else if(posO.containsAll(leftCell)) {
            return "O wins";
        } else if(posO.containsAll(midRoCell)) {
            return "O wins";
        } else if(posO.containsAll(rigthCell)) {
            return "O wins";
        } else if(posO.containsAll(cross1)) {
            return "O wins";
        } else if(posO.containsAll(cross2)) {
            return "O wins";
        } else if((posO.size() + posX.size() == 9) || (posO.size() - posX.size() == 1) || (posX.size() - posO.size() == 1)) {
            return "Draw";
        } else if (posO.size() - posX.size() > 1 || posX.size() - posO.size() > 1) {
            return "Impossible";
        } else {
            return "Game not finished";
        }

    }

    public  static String posXCheck() {
        if(posX.containsAll(topRow)) {
            return "X wins";
        } else if (posX.containsAll(midRow)) {
            return "X wins";
        }  else if (posX.containsAll(botRow)) {
            return "X wins";
        } else if (posX.containsAll(leftCell)) {
            return "X wins";
        } else if (posX.containsAll(midRoCell)) {
            return "X wins";
        } else if (posX.containsAll(rigthCell)) {
            return "X wins";
        } else if (posX.containsAll(cross1)) {
            return "X wins";
        } else if (posX.containsAll(cross2)) {
            return "X wins";
        } else {
            return "null";
        }
    }

    public  static String posOCheck() {
        if(posO.containsAll(topRow)) {
            return "O wins";
        } else if(posO.containsAll(midRow)) {
            return "O wins";
        } else if(posO.containsAll(botRow)) {
            return "O wins";
        } else if(posO.containsAll(leftCell)) {
            return "O wins";
        } else if(posO.containsAll(midRoCell)) {
            return "O wins";
        } else if(posO.containsAll(rigthCell)) {
            return "O wins";
        } else if(posO.containsAll(cross1)) {
            return "O wins";
        } else if(posO.containsAll(cross2)) {
            return "O wins";
        } else {
            return "null";
        }
    }

}
