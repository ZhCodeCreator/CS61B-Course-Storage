public class TestPlanet {
    public static void main(String[] args) {
        Planet planetA = new Planet(0, 0, 0, 0, 5, "img1");
        Planet planetB = new Planet(5, 5, 0, 0, 5, "img2");
        double force = planetA.calcForceExertedBy(planetB);
        System.out.println("Force: " + force);
    }
}