package shapes;

import java.util.Comparator;

/**
 * Abstract base class for all 3D shapes.
 * 
 * This class provides a common structure for 3D shapes, including height,
 * methods for computing volume and base area, and comparators for sorting.
 */
public abstract class Shape3D implements Comparable<Shape3D> {
    protected double height;


    /**
     * Constructs a Shape3D object with the specified height.
     * 
     * @param height The height of the shape.
     */
    public Shape3D(double height) {
        this.height = height;
    }

    
    /**
     * Returns the height of the shape.
     * 
     * @return The height of the shape.
     */
    public double getHeight() {
        return height;
    }
    
    
    /**
     * Abstract method to calculate the volume of the shape.
     * 
     * @return The volume of the shape.
     */
    public abstract double getVolume();
    

    /**
     * Abstract method to calculate the base area of the shape.
     * 
     * @return The base area of the shape.
     */
    public abstract double getBaseArea();

    
    /**
     * Compares two Shape3D objects based on their height.
     * 
     * @param other The other Shape3D object.
     * @return A negative, zero, or positive value if this shape's height is
     *         less than, equal to, or greater than the other shape's height.
     */
    @Override
    public int compareTo(Shape3D other) {
        return Double.compare(this.height, other.height);
    }

    
    /**
     * Comparator for sorting shapes based on volume.
     */
    public static final Comparator<Shape3D> VolumeComparator = new Comparator<Shape3D>() {
        @Override
        public int compare(Shape3D s1, Shape3D s2) {
            return Double.compare(s1.getVolume(), s2.getVolume());
        }
    };

    
    /**
     * Comparator for sorting shapes based on base area.
     */
    public static final Comparator<Shape3D> BaseAreaComparator = new Comparator<Shape3D>() {
        @Override
        public int compare(Shape3D s1, Shape3D s2) {
            return Double.compare(s1.getBaseArea(), s2.getBaseArea());
        }
    };

    
    /**
     * Returns a string representation of the shape, including height, volume, and base area.
     * 
     * @return A formatted string representing the shape.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "             [height=" + height 
                + ",       volume=" + getVolume() 
                + ",       baseArea=" + getBaseArea() + "]";
    }
    
    
    /**
     * Returns a string representation of the shape with only the height.
     * 
     * @return A formatted string representing the height.
     */
    public String heightToString() {
        return this.getClass().getSimpleName() + "             [height=" + height + "]";
    }
    
    
    /**
     * Returns a string representation of the shape with only the volume.
     * 
     * @return A formatted string representing the volume.
     */
    public String volumeToString() {
        return this.getClass().getSimpleName() + "             [volume=" + getVolume() + "]";
    }
    
    
    /**
     * Returns a string representation of the shape with only the base area.
     * 
     * @return A formatted string representing the base area.
     */
    public String baseToString() {
        return this.getClass().getSimpleName() + "             [baseArea=" + getBaseArea() + "]";
    }
}
