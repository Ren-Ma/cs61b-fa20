public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int N = in.readInt();
        double Radius = in.readDouble();
        return Radius;
    }
    
    public static Body[] readBodies(String filename){
        In in = new In(filename);
        int N = in.readInt();
        double Radius = in.readDouble();
        Body[] Bodies = new Body[N];
        for (int i = 0; i < N; i += 1) {
            double  xxPos = in.readDouble(),
                    yyPos = in.readDouble(),
                    xxVel = in.readDouble(),
                    yyVel = in.readDouble(),
                    mass = in.readDouble();
			String name = in.readString();
			Bodies[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, name);
        }
        return Bodies;
    }
    
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]),
                dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        int N = bodies.length;
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time <= T){
            double[] xForces = new double[N], yForces = new double[N];
            for (int i = 0; i < N; i += 1) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            // Update only after all forces have been calculated.
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < N; i += 1){
                bodies[i].update(dt, xForces[i], yForces[i]);
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", N);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < N; i ++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel, bodies[i].yyPos,
            bodies[i].mass, bodies[i].imgFileName);
        }
    }
}
