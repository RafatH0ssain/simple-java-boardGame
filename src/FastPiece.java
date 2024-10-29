public class FastPiece extends Piece {

    //  Constructors
    public FastPiece(String name, String color, Position position) {
        this.Name = name;
        this.Colour = color;
        this.Position = position;
        this.type = "F";
    }

    public FastPiece() {
    }

    //  ToString
    public String toString() {
        return ("Name: " + this.getName() + "\n, Colour: " + this.getColour() + "\n, Position: " + this.Position.getPosition());
    }
}