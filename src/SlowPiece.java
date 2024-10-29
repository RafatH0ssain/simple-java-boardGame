public class SlowPiece extends Piece {

//  Constructor
    public SlowPiece(String name, String color, Position position) {
        this.Name = name;
        this.Colour = color;
        this.Position = position;
        this.type = "S";
    }
    public SlowPiece(){}

//  ToString
    public String toString() {
        return ("Name: " + this.getName() + "\n, Colour: " + this.getColour() + "\n, Position: " + this.Position.getPosition());
    }

}