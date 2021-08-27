public class Body {
    // instance variables
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    // constructor 1
    public Body(double xP, double yP, double xV,
    double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    // constructor 2
    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
    // calcDistance
    public double calcDistance(Body b){
        double distance_square = Math.pow(xxPos-b.xxPos, 2) + Math.pow(yyPos-b.yyPos, 2);
        return Math.sqrt(distance_square);
    }
    // calcForceExertedBy
    public double calcForceExertedBy(Body b){
        if  (this.equals(b)) {
            return 0;
        }
        double F = 6.67e-11 * mass * b.mass / Math.pow(this.calcDistance(b), 2);
        return F;
    }
    // calcForceExertedByX
    public double calcForceExertedByX(Body b){
        double F_x = this.calcForceExertedBy(b) * (b.xxPos - xxPos) 
        / this.calcDistance(b);
        return F_x;
    }
    // calcForceExertedByY
    public double calcForceExertedByY(Body b){
        double F_y = this.calcForceExertedBy(b) * (b.yyPos - yyPos) 
        / this.calcDistance(b);
        return F_y;
    }
    // calcNetForceExertedByX
    public double calcNetForceExertedByX(Body[] allBodys){
        double NetF_x = 0;
        for (Body b: allBodys){
            if (this.equals(b)){
                continue;
            }
            NetF_x += this.calcForceExertedByX(b);
        }
        return NetF_x;
    }
    // calcNetForceExertedByY
    public double calcNetForceExertedByY(Body[] allBodys){
        double NetF_y = 0;
        for (Body b: allBodys){
            if (this.equals(b)){
                continue;
            }
            NetF_y += this.calcForceExertedByY(b);
        }
        return NetF_y;
    }
    // update
    public void update(double dt, double fX, double fY){
            double acc_x = fX / mass;
            double acc_y = fY / mass;
            xxVel += (dt * acc_x);
            yyVel += (dt * acc_y);
            xxPos += (dt * xxVel);
            yyPos += (dt * yyVel);
    }
    // draw
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }    
}
