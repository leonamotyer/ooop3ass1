package shapes;


public class SquarePrism extends Shape3D {
    private double edge;

    public SquarePrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getBaseArea() {
        return edge * edge;
    }

    @Override
    public double getVolume() {
        return edge * edge * height;
    }

    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}

