package UVS_Optimization;

import UVS_Simulator.UVSSimulator;

import java.util.Random;

public class PSO {
    // Parameters
    private static final int NUM_PARTICLES = 30;
    private static final int MAX_ITERATIONS_PSO = 1000;
    private static final int DIMENSIONS = 4;
    private static final double C1 = 2.0;  // Cognitive parameter
    private static final double C2 = 1.0;  // Social parameter
    private static final double W = 0.7;   // Inertia weight
    private static class Particle {
        double[] position; // [a, b, c, etc]
        double[] velocity;
        double[] pBest;
        double pBestFitness;

        Particle() {
            position = new double[DIMENSIONS];
            velocity = new double[DIMENSIONS];
            pBest = new double[DIMENSIONS];
            pBestFitness = Double.MAX_VALUE;
            Random rand = new Random();
            for (int i = 0; i < DIMENSIONS; i++) {
                // Random initialization
                position[i] = rand.nextDouble();
                velocity[i] = rand.nextDouble()*0.5;
            }
        }

        void updateVelocity(double[] gBest) {
            Random rand = new Random();
            for (int i = 0; i < DIMENSIONS; i++) {
                double r1 = rand.nextDouble();
                double r2 = rand.nextDouble();
                velocity[i] = W * velocity[i] + C1 * r1 * (pBest[i] - position[i]) + C2 * r2 * (gBest[i] - position[i]);
            }
        }

        void updatePosition() {
            for (int i = 0; i < DIMENSIONS; i++) {
                position[i] = limit(position[i] + velocity[i], 0, 1);
            }
        }

        double limit(double x, double lower, double upper){
            if (x < lower) return lower;
            else if (x > upper) return upper;
            else return x;
        }

        double evaluateFitness() {
            return new UVSSimulator().simulateAndGetFitness(position, false);
        }
    }

    public static void main(String[] args) {
        Particle[] particles = new Particle[NUM_PARTICLES];
        double[] gBest = new double[DIMENSIONS];
        double gBestFitness = Double.MAX_VALUE;
        // Initialize particles
        for (int i = 0; i < NUM_PARTICLES; i++) {
            particles[i] = new Particle();
            double fitness = particles[i].evaluateFitness();
            if (fitness > gBestFitness) {
                gBestFitness = fitness;
                System.arraycopy(particles[i].position, 0, gBest, 0, DIMENSIONS);
            }
        }
        // PSO loop
        for (int iter = 0; iter < MAX_ITERATIONS_PSO; iter++) {
            for (Particle particle : particles) {
                double fitness = particle.evaluateFitness();
                if (fitness > particle.pBestFitness) {
                    particle.pBestFitness = fitness;
                    System.arraycopy(particle.position, 0, particle.pBest, 0, DIMENSIONS);
                }
                if (fitness > gBestFitness) {
                    gBestFitness = fitness;
                    System.arraycopy(particle.position, 0, gBest, 0, DIMENSIONS);
                }
                particle.updateVelocity(gBest);
                particle.updatePosition();
            }
            printSolution("iteration" + iter + ", ", gBest, gBestFitness);
        }
        // Output the best solution
        printSolution("Best", gBest, gBestFitness);
    }

    private static void printSolution(String prefix, double[] solution, double fitness) {
        System.out.print(prefix + ". Fitness: " + String.format("%.6f", fitness));
        System.out.print(", solution: [");
        for (int i = 0; i < DIMENSIONS; i++) {
            System.out.print(String.format("%.3f", solution[i]) + (i == DIMENSIONS - 1 ? "]" : ", "));
        }
        System.out.println();
    }
}