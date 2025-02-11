package shapes;


public class TriangularPrism extends Shape3D {
    private double edge;

    public TriangularPrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4.0) * edge * edge;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}
