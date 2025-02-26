
// Shape.java
public abstract class Shape implements Comparable<Shape> {
    public abstract double getHeight();
    public abstract double getBaseArea();
    public abstract double getVolume();

    @Override
    public int compareTo(Shape other) {
        return Double.compare(other.getHeight(), this.getHeight());
    }

    public static Comparator<Shape> BASE_AREA_COMPARATOR = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s2.getBaseArea(), s1.getBaseArea());
        }
    };

    public static Comparator<Shape> VOLUME_COMPARATOR = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s2.getVolume(), s1.getVolume());
        }
    };
}