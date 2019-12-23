/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson05;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class Lesson05 {

    static int X, Y, ENDX, ENDY, xEnemy, yEnemy;
    static char[][] MAP = new char[5][5];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        X = 2;
        Y = 2;
        ENDX = 4;
        ENDY = 4;
        xEnemy = 1;
        yEnemy = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == X && j == Y) {
                    MAP[i][j] = 'X';
                } else if (i == ENDX && j == ENDY) {
                    MAP[i][j] = 'O';
                } else if (i == xEnemy && j == yEnemy) {
                    MAP[i][j] = 'E';
                } else {
                    MAP[i][j] = '-';
                }
            }
        }

        while (true) {
            hienThiMap();
            char input = nhapPhimDiChuyen();
            thayDoiToaDo(input);
            moveEnemy();
            String check = checkThangThua();

            if (!check.equals("tieptuc")) {
                hienThiMap();
                System.out.println("Ket qua: " + check);
                break;
            }

        }
    }

    public static void hienThiMap() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static char nhapPhimDiChuyen() {
        System.out.println("Nhap WASD:");
        String phimDiChuyen = sc.nextLine();
        char phimDiChuyenChar = phimDiChuyen.charAt(0);
        return phimDiChuyenChar;
    }

    public static void thayDoiToaDo(char c) {
        switch (c) {
            case 'A':
                if (Y == 0) {
                    MAP[X][Y] = '-';
                    Y = 4;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    Y--;
                    MAP[X][Y] = 'X';
                }
                break;
            case 'S':
                if (X == 4) {
                    MAP[X][Y] = '-';
                    X = 0;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    X++;
                    MAP[X][Y] = 'X';
                }
                break;
            case 'W':
                if (X == 0) {
                    MAP[X][Y] = '-';
                    X = 4;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    X--;
                    MAP[X][Y] = 'X';
                }
                break;
            case 'D':
                if (Y == 4) {
                    MAP[X][Y] = '-';
                    Y = 0;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    Y++;
                    MAP[X][Y] = 'X';
                }

        }

    }

    public static String checkThangThua() {
        if (X == ENDX && Y == ENDY) {
            return "Thang";
        } else if (X == xEnemy && Y == yEnemy) {
            return "Thua";
        }
        return "tieptuc";
    }

    private static void moveEnemy() {
        MAP[xEnemy][yEnemy] = '-';
        if (xEnemy < X) {
            xEnemy = (xEnemy + 1) % MAP.length;
            MAP[xEnemy][yEnemy] = 'E';
        } else if (xEnemy > X) {
            xEnemy = (xEnemy - 1 + MAP.length) % MAP.length;
            MAP[xEnemy][yEnemy] = 'E';
        } else if (yEnemy > Y) {
            yEnemy--;
            MAP[xEnemy][yEnemy] = 'E';
        } else if (yEnemy < Y) {
            yEnemy++;
            MAP[xEnemy][yEnemy] = 'E';
        }
    }

//
//    private static void moveEnemy() {
//        double[] distance = new double[4];
//        distance[0] = Math.sqrt(Math.pow(X - (xEnemy - 1), 2) + Math.pow(Y - yEnemy, 2));
//        distance[1] = Math.sqrt(Math.pow(X - (xEnemy + 1), 2) + Math.pow(Y - yEnemy, 2));
//        distance[2] = Math.sqrt(Math.pow(X - xEnemy, 2) + Math.pow(Y - (yEnemy - 1), 2));
//        distance[3] = Math.sqrt(Math.pow(X - xEnemy, 2) + Math.pow(Y - (yEnemy + 1), 2));
//
//        double min = Double.MAX_VALUE;
//        int index = 0;
//        for (int i = 0; i < distance.length; i++) {
//            if (distance[i] < min) {
//                min = distance[i];
//
//            }
//        }
//        if (min == distance[0]) {
//            MAP[xEnemy][yEnemy] = '-';
//            xEnemy--;
//            if (xEnemy == -1) {
//                xEnemy = 0;
//            }
//            MAP[xEnemy][yEnemy] = 'E';
//            System.out.println("0");
//        } else if (min == distance[1]) {
//            MAP[xEnemy][yEnemy] = '-';
//            xEnemy++;
//            if (xEnemy == 5) {
//                xEnemy = 4;
//            }
//            MAP[xEnemy][yEnemy] = 'E';
//        } else if (min == distance[2]) {
//            MAP[xEnemy][yEnemy] = '-';
//            yEnemy--;
//            if (yEnemy == -1) {
//                yEnemy = 0;
//            }
//            MAP[xEnemy][yEnemy] = 'E';
//        } else if (min == distance[3]) {
//            MAP[xEnemy][yEnemy] = '-';
//            yEnemy++;
//            if (yEnemy == 5) {
//                yEnemy = 4;
//            }
//            MAP[xEnemy][yEnemy] = 'E';
//        }
//
//    }
}
