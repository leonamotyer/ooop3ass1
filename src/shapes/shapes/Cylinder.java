package shapes;


public class Cylinder extends Shape3D {
    private double radius;

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
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
