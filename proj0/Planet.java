public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;
        double d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }
    public double calcForceExertedBy(Planet b) {
        double dist = calcDistance(b);
        return G * mass * b.mass / (dist * dist);
    }
    public double calcForceExertedByX(Planet b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;
        double dist = calcDistance(b);
        return (dx / dist) * calcForceExertedBy(b);

    }
    public double calcForceExertedByY(Planet b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;
        double dist = calcDistance(b);
        return (dy / dist) * calcForceExertedBy(b);
    }
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double force = 0;
        double sumForce = 0;
        for (Planet planet : allPlanets) {
            if (!this.equals(planet)) {
                force = calcForceExertedByX(planet);
                sumForce += force;
            }
        }
        return sumForce;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double force = 0;
        double sumForce = 0;
        for (Planet planet : allPlanets) {
            if (!this.equals(planet)) {
                force = calcForceExertedByY(planet);
                sumForce += force;
            }
        }
        return sumForce;
    }
    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
    }
}