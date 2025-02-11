package shapes;


public class PentagonalPrism extends Shape3D {
    private double edge;

    public PentagonalPrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getBaseArea() {
        return (5 * edge * edge * Math.tan(Math.toRadians(54))) / 4.0;
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

