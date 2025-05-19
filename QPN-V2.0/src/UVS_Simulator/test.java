package UVS_Simulator;

import Components.PetriNet;
import Components.PetriNetWindow;

public class test {
	public static void main(String[] args) {
// 
		// test 1 Throughput = 1.199154019355774
		Gammas[] g = { new Gammas(0.1, 0.2), new Gammas(0.2, 0.3), new Gammas(0.3, 0.4), new Gammas(0.4, 0.5) };
		UVS uvs = new UVS(g, Constants.U1, Constants.x_init);
		PetriNet pn = uvs.BuildQPN();
		pn.Delay = 0;
//		pn.clearPrint = false;
//		PetriNetWindow frame = new PetriNetWindow(false);
//		frame.petriNet = pn;
//		frame.setVisible(true);
//		pn.Start();


		// test 2 different gamma same input as test1 Throughput = 1.2464406192302704

		Gammas[] g2 = { new Gammas(0.2, 0.7), new Gammas(0.1, 0.5), new Gammas(0.6, 0.7), new Gammas(0.8, 0.5) };
		UVS uvs2 = new UVS(g2, Constants.U1, Constants.x_init);
		PetriNet pn2 = uvs2.BuildQPN();
		pn2.Delay = 0;
//		pn2.clearPrint = true;
//		PetriNetWindow frame2 = new PetriNetWindow(false);
//		frame2.petriNet = pn2;
//		frame2.setVisible(true);
//		pn2.Start();
		
		
		// test 3 same gamma as test 2 different Ux Throughput = 2.8251238614320755
		double[] x_init = { 0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.3, 0.3 };
		UVS uvs3 = new UVS(g2, Constants.U1, x_init);
		PetriNet pn3 = uvs3.BuildQPN();
		pn3.Delay = 0;
//		pn2.clearPrint = true;
//		PetriNetWindow frame2 = new PetriNetWindow(false);
//		frame2.petriNet = pn2;
//		frame2.setVisible(true);
		pn3.Start();
	}
}
