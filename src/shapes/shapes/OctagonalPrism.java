package shapes;


public class OctagonalPrism extends Shape3D {
    private double edge;

    public OctagonalPrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * edge * edge;
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
