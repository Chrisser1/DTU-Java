public class DirectionVector {
    private double x;
    private double y;

    // Constructor
    public DirectionVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Vector magnitude (length)
    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    // Normalize the vector (make its length = 1)
    public DirectionVector normalize() {
        double magnitude = magnitude();
        if (magnitude == 0) {
            throw new IllegalStateException("Cannot normalize a zero vector.");
        }
        return new DirectionVector(x / magnitude, y / magnitude);
    }

    // Scale the vector by a scalar
    public DirectionVector scale(double scalar) {
        return new DirectionVector(x * scalar, y * scalar);
    }

    // Add another vector to this vector
    public DirectionVector add(DirectionVector other) {
        return new DirectionVector(this.x + other.x, this.y + other.y);
    }

    // Subtract another vector from this vector
    public DirectionVector subtract(DirectionVector other) {
        return new DirectionVector(this.x - other.x, this.y - other.y);
    }

    // Dot product of this vector with another vector
    public double dotProduct(DirectionVector other) {
        return this.x * other.x + this.y * other.y;
    }

    // Calculate the angle between this vector and another vector (in degrees)
    public double angleBetween(DirectionVector other) {
        double dot = this.dotProduct(other);
        double magnitudes = this.magnitude() * other.magnitude();
        if (magnitudes == 0) {
            throw new IllegalStateException("Cannot calculate angle with a zero vector.");
        }
        return Math.toDegrees(Math.acos(dot / magnitudes));
    }

    // ToString method for easy debugging
    @Override
    public String toString() {
        return "DirectionVector{" + "x=" + x + ", y=" + y + '}';
    }

    // Static method to create a zero vector
    public static DirectionVector zero() {
        return new DirectionVector(0, 0);
    }
}
