import java.text.DecimalFormat;

import org.jgap.*;
import org.jgap.impl.*;
public class GA {
    private static final int MAX_ALLOWED_EVOLUTIONS = 1000;
    public static void main(String[] args) throws InvalidConfigurationException{
        Configuration conf = new DefaultConfiguration();
        Configuration.resetProperty(Configuration.PROPERTY_FITEVAL_INST);
        //low value for fitness = better
        conf.setFitnessEvaluator(new DeltaFitnessEvaluator());
        conf.setPreservFittestIndividual(true);
        conf.setKeepPopulationSizeConstant(true);

        conf.setFitnessFunction(new SSTFitness());
        int nrGenes = 4;
        IChromosome sampleChromosome = new Chromosome(conf, new DoubleGene(conf, 0, 1), nrGenes);
        conf.setSampleChromosome(sampleChromosome);
        conf.setPopulationSize(100);
        Genotype population = Genotype.randomInitialGenotype(conf);
        for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
            population.evolve();
            IChromosome bestChrSoFar = population.getFittestChromosome();
            System.out.println(i + ". " +
                    "Fitness: " + bestChrSoFar.getFitnessValue() + ", " +
                    "solution: " + SSTFitness.toStringGamma(bestChrSoFar));
        }
    }
}

class SSTFitness extends FitnessFunction {
    public double evaluate(IChromosome chr) {
        double[] gamma = Mapping(chr);
        return UVS.simulateAndGetFitness(gamma);
    }
    //add Mapping(chr) method
    public static double[] Mapping(IChromosome chr)
    {
        double[] u = new double[4];
        for (int i=0; i<chr.size(); i++)
            u[i] = ((Double)chr.getGene(i).getAllele()).doubleValue();
        return u;
    }

    public static String toStringGamma(IChromosome chr)
    {
        DecimalFormat df2 = new DecimalFormat("#.###");

        double[] gamma = Mapping(chr);
        String s = "[";
        for (int i=0; i< gamma.length;i++)
            s += (i==0 ? "":",") + df2.format(gamma[i]);
        s+="]";
        return s;
    }
}
