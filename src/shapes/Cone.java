package shapes;


public class Cone extends Shape3D {
    private double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getVolume() {
        return (Math.PI * radius * radius * height) / 3.0;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() + " [radius=" + radius + "]";
    }
}
