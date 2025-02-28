package shapes;

import java.util.Comparator;

public abstract class Shape3D implements Comparable<Shape3D> {
    protected double height;

    public Shape3D(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public abstract double getVolume();

    public abstract double getBaseArea();

    @Override
    public int compareTo(Shape3D other) {
        return Double.compare(this.height, other.height);
    }

    public static final Comparator<Shape3D> VolumeComparator = new Comparator<Shape3D>() {
        @Override
        public int compare(Shape3D s1, Shape3D s2) {
            return Double.compare(s1.getVolume(), s2.getVolume());
        }
    };

    public static final Comparator<Shape3D> BaseAreaComparator = new Comparator<Shape3D>() {
        @Override
        public int compare(Shape3D s1, Shape3D s2) {
            return Double.compare(s1.getBaseArea(), s2.getBaseArea());
        }
    };

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [height=" + height 
                + ", volume=" + getVolume() 
                + ", baseArea=" + getBaseArea() + "]";
    }
    
    
    public String heightToString() {
        return this.getClass().getSimpleName() + " [height=" + height + "]";
    }
    
    public String volumeToString() {
        return this.getClass().getSimpleName() + " [volume=" + getVolume() + "]";
    }
    
    public String baseToString() {
        return this.getClass().getSimpleName() + " [baseArea=" + getBaseArea() + "]";
    }
}
