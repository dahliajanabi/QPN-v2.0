package UVS_Simulator;


public class UVSSimulator {
    UVS uvs = null;

    public double runWithUandGammaAndGetThroughtput(double[] u, double[] gamma) {
        Gammas[] gammas = new Gammas[4];
        for (int i = 0; i < 4; i++)
            gammas[i] = new Gammas(gamma[i], Math.sqrt(1-gamma[i]*gamma[i]));
        if (uvs == null) { // if this is the firt run, initialize the UVS
            uvs = new UVS(gammas, u, Constants.x_init, null, null);
        } else {
            try {
				uvs = uvs.initializeAnotherRound(gammas, u);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        uvs.runToEndFast();
        try {
			uvs = uvs.initializeAnotherRound(gammas, u);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        uvs.runToEndFast();
        return uvs.getThroughput();
    }

    public double simulateAndGetFitness(double[] gamma, boolean printThroughput) {
        double throughput1 = this.runWithUandGammaAndGetThroughtput(Constants.U1, gamma);
        if (printThroughput) System.out.println("troughput 1: " + throughput1);

        double throughput2 = 0; //this.runWithUandGammaAndGetThroughtput(Constants.U2, gamma);
        if (printThroughput) System.out.println("troughput 2: " + throughput2);

        double throughput3 = 0; //this.runWithUandGammaAndGetThroughtput(Constants.U3, gamma);
        if (printThroughput) System.out.println("troughput 3: " + throughput3);

        return throughput1 + throughput2 + throughput3;
    }

    public static void main(String[] args) {
        double[] gamma = {  0.1, 0.1, 0.3, 0.3 };
        //double[] gamma = {  0.8, 0.1, 0.1, 0.9 };
        UVSSimulator simulator = new UVSSimulator();

        double throughput = simulator.runWithUandGammaAndGetThroughtput(Constants.U1, gamma);
        System.out.println("troughput: " + throughput);

    }

    public static void printRunningOf3Scenarios(double[] gamma1, double[] gamma2, double[] gamma3) {
        UVSSimulator simulator = new UVSSimulator();

        double throughput1 = simulator.runWithUandGammaAndGetThroughtput(Constants.U1, gamma1);
        double throughput2 = simulator.runWithUandGammaAndGetThroughtput(Constants.U2, gamma2);
        double throughput3 = simulator.runWithUandGammaAndGetThroughtput(Constants.U3, gamma3);

        System.out.println("U \t\t\t gamma \t throughput");
        for (int i=0;i<Constants.U1.length;i++)
            System.out.print((i==0?"(":",") + Constants.U1[i] + (i==Constants.U1.length-1?"":")\t"));
        for (int i=0;i<gamma1.length;i++)
            System.out.print((i==0?"(":",") + "("+gamma1[i]+","+(Math.sqrt(1-gamma1[i]*gamma1[i]))+")" + (i==gamma1.length-1?"":")\t"));
        System.out.println(throughput1);

        for (int i=0;i<Constants.U2.length;i++)
            System.out.print((i==0?"(":",") + Constants.U2[i] + (i==Constants.U2.length-1?"":")\t"));
        for (int i=0;i<gamma2.length;i++)
            System.out.print((i==0?"(":",") + "("+gamma2[i]+","+(Math.sqrt(1-gamma2[i]*gamma2[i]))+")" + (i==gamma2.length-1?"":")\t"));
        System.out.println(throughput2);

        for (int i=0;i<Constants.U3.length;i++)
            System.out.print((i==0?"(":",") + Constants.U3[i] + (i==Constants.U3.length-1?"":")\t"));
        for (int i=0;i<gamma3.length;i++)
            System.out.print((i==0?"(":",") + "("+gamma3[i]+","+(Math.sqrt(1-gamma3[i]*gamma3[i]))+")" + (i==gamma3.length-1?"":")\t"));
        System.out.println(throughput3);
    }
}
