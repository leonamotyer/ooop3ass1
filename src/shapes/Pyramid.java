package shapes;


public class Pyramid extends Shape3D {
    private double edge;

    public Pyramid(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getVolume() {
        return (edge * edge * height) / 3.0;
    }

    @Override
    public double getBaseArea() {
        return edge * edge;
    }

    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}
