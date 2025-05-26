package UVS_Simulator;

import Components.PetriNet;

public class UVSTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		 Gammas[] gammas = new Gammas[4];
			for (int i = 0; i < 4; i++)
	            gammas[i] = new Gammas(0.0, 0.0);
	        UVS uvs = new UVS(gammas, Constants.U1, Constants.x_init, null, null);
	        uvs.BuildQPN();
	        uvs.pn.Delay = 0;
//	        uvs.pn.clearPrint = true;
//	        PetriNetWindow frame = new PetriNetWindow(false);
//	        frame.petriNet = uvs.pn;
//	        frame.setVisible(true);
	        uvs.pn.Start();
	        while (!uvs.pn.StopFlag) {}
	    
	      
	        //2nd round
	        Gammas[] gammas2 = new Gammas[4];
	        double[] gamma2 = {0.1, 0.2, 0.3, 0.4};
	        for (int i = 0; i < 4; i++)
	        gammas2[i] = new Gammas(gamma2[i], Math.sqrt(1-gamma2[i]*gamma2[i]));
			UVS uvs2 = uvs.initializeAnotherRound(gammas, Constants.U1) ;
			uvs2.BuildQPN();
			uvs2.pn.Delay = 0;
//			uvs2.pn.clearPrint = false;
//			PetriNetWindow frame2 = new PetriNetWindow(false);
//			frame2.petriNet = uvs2.pn;
//			frame2.setVisible(true);
			uvs2.pn.Start();  
	}

}
