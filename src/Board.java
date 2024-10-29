import java.util.Scanner;

public class Board {
//    Constructor
    public Board() {
    }

    Scanner sc = new Scanner(System.in);

    Piece[][] pieces_on_board = new Piece[8][8];

//  Functions to add pieces
    public void addPiece(int x, int y) {
        if (pieces_on_board[x][y] == null) {
            pieces_on_board[x][y] = new SlowPiece();
            pieces_on_board[x][y].setType("S");
            pieces_on_board[x][y].setPosition(x, y);
        } else {
            System.out.println("Error! (" + x + ", " + y + ") is already occupied!");
            return;
        }
    }
    public void addPiece(int x, int y, String piece_speed) {
        if (pieces_on_board[x][y] == null && piece_speed.equals("fast")) {
            pieces_on_board[x][y] = new FastPiece();
            pieces_on_board[x][y].setType("F");
            pieces_on_board[x][y].setPosition(x, y);
        }
        else if (piece_speed.equals("slow") && pieces_on_board[x][y] == null) {
            System.out.println("Error! This is a slow piece, it has fixed speed!");
            return;
        }
        else if (piece_speed.equals("flexible") && pieces_on_board[x][y] == null) {
            pieces_on_board[x][y] = new SlowFlexible();
            pieces_on_board[x][y].setType("SF");
            pieces_on_board[x][y].setPosition(x, y);
        }
        else {
            System.out.println("Error! (" + x + ", " + y + ") is already occupied!");
            return;
        }
    }
    public void addPiece(int x, int y, String piece_speed, String piece_type) {
        if (pieces_on_board[x][y] == null && piece_speed.equals("fast") && piece_type.equals("flexible")) {
            pieces_on_board[x][y] = new FastFlexible();
            pieces_on_board[x][y].setType("FF");
            pieces_on_board[x][y].setPosition(x, y);
        } else if (pieces_on_board[x][y] == null && piece_speed.equals("slow") && piece_type.equals("flexible")) {
            pieces_on_board[x][y] = new SlowFlexible();
            pieces_on_board[x][y].setType("SF");
            pieces_on_board[x][y].setPosition(x, y);
        }
        else if (pieces_on_board[x][y] != null) {
            System.out.println("Error! (" + x + ", " + y + ") is already occupied!");
            return;
        }
        else {
            System.out.println("Error! Wrong input format.");
            return;
        }
    }

    public void addPieceData(int x, int y) {
        if (pieces_on_board[x][y].getName() != null) {
            return;
        }
        System.out.println("Input a name for the new piece:");
        String piece_name = sc.nextLine();
        pieces_on_board[x][y].setName(piece_name);
        if (pieces_on_board[x][y].getColour() != null) {
            return;
        }
        System.out.println("Input a colour for the new piece:");
        String piece_colour = sc.nextLine();
        pieces_on_board[x][y].setColour(piece_colour);
    }

//  Function to check if board space is empty
    public boolean hasPiece(int x, int y) {
        if (pieces_on_board[x][y] == null) {
            return false;
        } else {
            return true;
        }
    }

//  Function to display board
    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieces_on_board[j][i] != null) {
                    System.out.print(" " + pieces_on_board[j][i].getName() + pieces_on_board[j][i].getColour() + pieces_on_board[j][i].getType() + " ");
                }
                else {
                    System.out.print("  -  ");
                }
            }
            System.out.println("\n");
        }
    }
}