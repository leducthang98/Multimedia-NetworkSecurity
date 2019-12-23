/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuabtvn01;

import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class ChuaBtvn06 {

    public static int PLAYER = 1;
    public static int[][] board = new int[3][3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
        show();
        while (true) {
            move();
            if (check()) {
                System.out.println("Nguoi choi" + PLAYER + "chien thang");
                break;
            }
            swapPlayer();
            show();
        }
    }

    private static void move() {
        System.out.println("Nhap toa do nguoi choi");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (board[x][y] != 0) {
            System.out.println("Trung vi tri, danh lai!");
            move();
        } else {
            board[x][y] = PLAYER;
        }
    }

    private static void swapPlayer() {
        if (PLAYER == 1) {
            PLAYER = 2;
        } else if (PLAYER == 2) {
            PLAYER = 1;
        }
        System.out.println(PLAYER);
    }

    private static void show() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static boolean check() {
        if (board[0][0] != 0 && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            return true;
        }
        if (board[1][0] != 0 && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            return true;
        }
        if (board[2][0] != 0 && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            return true;
        }
        if (board[0][0] != 0 && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            return true;
        }
        if (board[0][1] != 0 && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            return true;
        }
        if (board[0][2] != 0 && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            return true;
        }
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return true;
        }
        return false;
    }
}
