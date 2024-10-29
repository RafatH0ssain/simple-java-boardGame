import java.util.Scanner;

public class GameDemo {
    static Board gameBoard = new Board();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String user_input = "";

//      While loop that runs until user types "exit"
        while(!user_input.equals("exit")){
            System.out.println("Enter a command (type help for details):");
            user_input = sc.nextLine();

            if(user_input.equals("help")){ //if typed "help"
                printHelp();
            }
            else if(user_input.equals("exit")){ //if typed "exit"
                System.out.println("Done.");
                break;
            }
            else if(user_input.equals("print")){ //if typed "print"
                gameBoard.displayBoard();
            }
            else if(user_input.startsWith("create")){ //if typed "create"
                String[] inputs = user_input.split(" ");
                if (inputs.length < 3) {
                    System.out.println("Error! Please provide coordinates and/or piece details.");
                    continue;
                }
                if (!inputs[1].matches(".*\\d.*") || !inputs[2].matches(".*\\d.*")){
                    System.out.println("Error! Please provide coordinates!");
                    continue;
                }
                int x_value = Integer.parseInt(inputs[1]);
                int y_value = Integer.parseInt(inputs[2]);
                if (x_value < 0 || y_value < 0 || x_value > 7 || y_value > 7) {
                    System.out.println("Please provide coordinates between 0 to 7!");
                    continue;
                }
                if (inputs.length >= 4) { //runs if user has given type of piece as well
                    String piece_speed = inputs[3];
                    if (inputs.length >= 5) { //runs if user has given speed of piece as well
                        String piece_type = inputs[4];
                        if (inputs[3].matches(".*\\d.*") || inputs[4].matches(".*\\d.*")){
                            System.out.println("Error! Please provide speed and type!");
                            continue;
                        }
                        if (inputs.length >= 6) { //runs if user has given name and/or colour as well
                            if (inputs.length >= 7) {
                                gameBoard.addPiece(x_value, y_value, piece_speed, piece_type);
                                gameBoard.pieces_on_board[x_value][y_value].setName(inputs[5]);
                                gameBoard.pieces_on_board[x_value][y_value].setColour(inputs[6]);
                                continue;
                            }
                            else {
                                gameBoard.addPiece(x_value, y_value, piece_speed, piece_type);
                                gameBoard.pieces_on_board[x_value][y_value].setName(inputs[5]);
                                gameBoard.addPieceData(x_value, y_value);
                                continue;
                            }
                        }
                        gameBoard.addPiece(x_value, y_value, piece_speed, piece_type);
                        gameBoard.addPieceData(x_value, y_value);
                    }
                    else if (piece_speed.equals("fast") || piece_speed.equals("slow") || piece_speed.equals("flexible")){
                        gameBoard.addPiece(x_value, y_value, piece_speed);
                        gameBoard.addPieceData(x_value, y_value);
                    }
                }
                else {
                    gameBoard.addPiece(x_value, y_value);
                    gameBoard.addPieceData(x_value, y_value);
                }
            }
            else if (user_input.startsWith("move")) { //if typed "move"
                String[] inputs = user_input.split(" ");
                if (inputs.length < 3) {
                    System.out.println("Error! Please provide coordinate details.");
                    continue;
                }
                if (!inputs[1].matches(".*\\d.*") || !inputs[2].matches(".*\\d.*")){
                    System.out.println("Error! Please provide coordinates!");
                    continue;
                }
                int x_value = Integer.parseInt(inputs[1]);
                int y_value = Integer.parseInt(inputs[2]);

                if (x_value < 0 || y_value < 0 || x_value > 7 || y_value > 7) {
                    System.out.println("Error! Please provide valid coordinates!");
                    continue;
                }
                if (!gameBoard.hasPiece(x_value, y_value)) {
                    System.out.println("Error! No piece at (" + x_value + "," + y_value + ")");
                    continue;
                }
                if (inputs.length >= 4) { //runs if direction is given
                    String piece_direction = inputs[3];

                    if (inputs.length >= 5) { //runs if speed is given
                        if (!inputs[4].matches(".*\\d.*")){
                            System.out.println("Error! Please provide a number for Speed!");
                            continue;
                        }
                        int piece_speed = Integer.parseInt(inputs[4]);
                        if (piece_direction.equals("up") && gameBoard.hasPiece(x_value, y_value-piece_speed)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                        else if (piece_direction.equals("down") && gameBoard.hasPiece(x_value, y_value+piece_speed)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                        else if (piece_direction.equals("left") && gameBoard.hasPiece(x_value-piece_speed, y_value)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                        else if (piece_direction.equals("right") && gameBoard.hasPiece(x_value+piece_speed, y_value)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                        if (gameBoard.pieces_on_board[x_value][y_value].move(x_value, y_value, piece_direction, piece_speed)) { //Swap places of coordinate before and coordinate after the move command
                            gameBoard.pieces_on_board[gameBoard.pieces_on_board[x_value][y_value].getX()][gameBoard.pieces_on_board[x_value][y_value].getY()]
                                    = gameBoard.pieces_on_board[x_value][y_value];
                            gameBoard.pieces_on_board[x_value][y_value] = null;
                        }
                    }
                    else {
                        if (piece_direction.equals("up") && gameBoard.hasPiece(x_value, y_value-1)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                        else if (piece_direction.equals("down") && gameBoard.hasPiece(x_value, y_value+1)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                        else if (piece_direction.equals("left") && gameBoard.hasPiece(x_value-1, y_value)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                        else if (piece_direction.equals("right") && gameBoard.hasPiece(x_value+1, y_value)) {
                            System.out.println("Error! Piece already exists in this space!");
                            continue;
                        }
                         if (gameBoard.pieces_on_board[x_value][y_value].move(x_value, y_value, piece_direction)){ //Swap places of coordinate before and coordinate after the move command
                             gameBoard.pieces_on_board[gameBoard.pieces_on_board[x_value][y_value].getX()][gameBoard.pieces_on_board[x_value][y_value].getY()]
                                     = gameBoard.pieces_on_board[x_value][y_value];
                             gameBoard.pieces_on_board[x_value][y_value] = null;
                         }
                    }
                }
            }
        }
    }

    public static void printHelp(){ //function to print help
        System.out.println("Possible commands are as follows:");
        System.out.println("create location [fast][flexible]: Creates a new piece");
        System.out.println("move location direction [spaces]: Moves a piece");
        System.out.println("print: Displays the board");
        System.out.println("help: Displays help");
        System.out.println("exit: Exits the program.\n\n");
    }
}