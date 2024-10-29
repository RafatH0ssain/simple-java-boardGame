public class Piece {

    String Name = null;
    String Colour = null;
    Position Position = new Position(0, 0);
    String type = null;

//  Constructors
    public Piece(String name, String colour, Position position) {
        this.Name = name;
        this.Colour = colour;
        this.Position = position;
    }
    public Piece() {}

//  Move Functions
    public boolean move (int x, int y, String direction, int speed) {
        if ((this.getType().equals("S") || this.getType().equals("SF")) && speed != 1) {
            System.out.println("Error! This piece is a Slow Piece, it cannot have custom speed.");
            return false;
        }
            if (direction.equals("left")) {
                if (this.Position.getX() - speed < 0) {
                    System.out.println("Error! Move is out of bounds.");
                    return false;
                }
                this.setPosition(this.Position.getX() - speed, this.Position.getY());
                System.out.println("Piece at (" + (this.Position.getX() + speed) + ", " + this.Position.getY() + ") moved left by " + speed + " spaces.");
                return true;
            }
            else if (direction.equals("right")) {
                if (this.Position.getX() + speed > 7) {
                    System.out.println("Error! Move is out of bounds.");
                    return false;
                }
                this.setPosition(this.Position.getX() + speed, this.Position.getY());
                System.out.println("Piece at (" + (this.Position.getX() - speed) + ", " + this.Position.getY() + ") moved right by " + speed + " spaces.");
                return true;
            }

            if (this.getType().equals("FF") || this.getType().equals("SF")) {
                if (direction.equals("up")) {
                    if (this.Position.getY() - speed < 0) {
                        System.out.println("Error! Move is out of bounds.");
                        return false;
                    }
                    this.setPosition(this.Position.getX(), this.Position.getY()-speed);
                    System.out.println("Piece at (" + this.Position.getX() + ", " + (this.Position.getY()+speed) + ") moved up by " + speed + " spaces.");
                    return true;
                }
                else if (direction.equals("down")) {
                    if (this.Position.getY() + speed > 7) {
                        System.out.println("Error! Move is out of bounds.");
                        return false;
                    }
                    this.setPosition(this.Position.getX(), this.Position.getY()+speed);
                    System.out.println("Piece at (" + this.Position.getX() + ", " + (this.Position.getY()-speed) + ") moved down by " + speed + " spaces.");
                    return true;
                }

        }
        return false;
    }
    public boolean move (int x, int y, String direction) {
        if (direction.equals("left")) {
            if (this.Position.getX()-1 < 0) {
                System.out.println("Error! Move is out of bounds.");
                return false;
            }
            this.setPosition(this.Position.getX()-1, this.Position.getY());
            System.out.println("Piece at (" + (this.Position.getX()+1) + ", " + this.Position.getY() + ") moved left by 1 space.");
            return true;
        }
        else if (direction.equals("right")) {
            if (this.Position.getX()+1> 7) {
                System.out.println("Error! Move is out of bounds.");
                return false;
            }
            this.setPosition(this.Position.getX()+1, this.Position.getY());
            System.out.println("Piece at (" + (this.Position.getX()-1) + ", " + this.Position.getY() + ") moved right by 1 space.");
            return true;
        }
        if (this.getType().equals("SF") || this.getType().equals("FF")) {
            if (direction.equals("up")) {
                if (this.Position.getY()-1 < 0) {
                    System.out.println("Error! Move is out of bounds.");
                    return false;
                }
                this.setPosition(this.Position.getX(), this.Position.getY()-1);
                System.out.println("Piece at (" + this.Position.getX() + ", " + (this.Position.getY()+1) + ") moved up by 1 space.");
                return true;
            }
            else if (direction.equals("down")) {
                if (this.Position.getY()+1> 7) {
                    System.out.println("Error! Move is out of bounds.");
                    return false;
                }
                this.setPosition(this.Position.getX(), this.Position.getY()+1);
                System.out.println("Piece at (" + this.Position.getX() + ", " + (this.Position.getY()-1) + ") moved down by 1 space.");
                return true;
            }
        }
        return false;
    }


//  Getters
    public String getName() {
        return this.Name;
    }
    public String getColour() {
        return this.Colour;
    }
    public String getType() {
        return this.type;
    }
    public int getX () {
        return this.Position.getX();
    }
    public int getY () {
        return this.Position.getY();
    }

//  Setters
    public void setName(String newName) {
        this.Name = newName;
    }
    public void setColour(String newColour) {
        this.Colour = newColour;
    }
    public void setPosition(int x, int y) {
        this.Position.setX(x);
        this.Position.setY(y);
    }
    public void setType(String type) {
        this.type = type;
    }
//  ToString
    public String toString() {
        return ("Name: " + this.getName() + "\n, Colour: " + this.getColour() + "\n, Position: " + this.Position.getPosition());
    }
}

//Class Position
class Position {

    int x;
    int y;

    //  Constructor
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public String getPosition() {
        return "(" + this.x + "," + this.y + ")";
    }
}