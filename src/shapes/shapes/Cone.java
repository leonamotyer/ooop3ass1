package shapes;

/**
 * Represents a Cone, a subclass of Shape3D.
 * 
 * A cone is defined by its height (inherited) and radius.
 * This class provides methods to compute its volume and base area.
 */
public class Cone extends Shape3D {
    private double radius;

    /**
     * Constructs a Cone with a specified height and radius.
     * 
     * @param height The height of the cone.
     * @param radius The radius of the base of the cone.
     */
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    
    /**
     * Returns the radius of the cone's base.
     * 
     * @return The radius of the cone.
     */
    public double getRadius() {
        return radius;
    }

    
    /**
     * Calculates and returns the volume of the cone.
     * 
     * Formula: (1/3) * π * r² * h
     * 
     * @return The volume of the cone.
     */
    @Override
    public double getVolume() {
        return (Math.PI * radius * radius * height) / 3.0;
    }

    
    /**
     * Calculates and returns the base area of the cone.
     * 
     * Formula: π * r²
     * 
     * @return The base area of the cone.
     */
    @Override
    public double getBaseArea() {
        return Math.PI * radius * radius;
    }
    
    
    /**
     * Returns a string representation of the cone, including its height and radius.
     * 
     * @return A formatted string representing the cone.
     */
    @Override
    public String toString() {
        return super.toString() + " [radius=" + radius + "]";
    }
}
