package UVS_Simulator;

import Components.PetriNet;
import Components.PetriNetWindow;

public class UVSTest {

	public static void main(String[] args) throws CloneNotSupportedException {
//		 Gammas[] gammas = new Gammas[4];
//			for (int i = 0; i < 4; i++)
//	            gammas[i] = new Gammas(0.0, 0.0);
//	        UVS uvs = new UVS(gammas, Constants.U1, Constants.x_init, null, null);
//	        uvs.BuildQPN();
//	        uvs.pn.Delay = 0;
////	        uvs.pn.clearPrint = true;
////	        PetriNetWindow frame = new PetriNetWindow(false);
////	        frame.petriNet = uvs.pn;
////	        frame.setVisible(true);
//	        uvs.pn.Start();
//	        while (!uvs.pn.StopFlag) {}
	        
	        
			 Gammas[] gammas = new Gammas[4];
				gammas[0] = new Gammas(0.532, 0.498);
				gammas[1] = new Gammas(0.373, 0.461);
				gammas[2] = new Gammas(0.42, 0.495);
				gammas[3] = new Gammas(0.437, 0.429);
				double[] U1 = { 0.3, 0.9, 0.1, 0.6, 0.4, 0.9, 0.1, 0.8 };
				double[] x_init = { 0.698,0.620,0.261,0.309,0.656,0.147,0.343,0.637,0.412,0.684,0.609,0.166,0.326,0.282,0.607,0.541};
		        UVS uvs = new UVS(gammas, U1, x_init, null, null);
		        uvs.BuildQPN();
		        uvs.pn.Delay = 0;
		        uvs.pn.clearPrint = true;
		        PetriNetWindow frame = new PetriNetWindow(false);
		        frame.petriNet = uvs.pn;
		        frame.setVisible(true);
//		        uvs.pn.Start();
		        while (!uvs.pn.StopFlag) {}
	    
	      
	        //2nd round
//	        Gammas[] gammas2 = new Gammas[4];
//	        double[] gamma2 = {0.1, 0.2, 0.3, 0.4};
//	        for (int i = 0; i < 4; i++)
//	        gammas2[i] = new Gammas(gamma2[i], Math.sqrt(1-gamma2[i]*gamma2[i]));
	        double[] U2 = { 0.7, 0.7, 0.6, 0.6, 0.8, 0.8, 0.5, 0.7};
			UVS uvs2 = uvs.initializeAnotherRound(gammas, U2) ;
			uvs2.BuildQPN();
			uvs2.pn.Delay = 0;
//			uvs2.pn.clearPrint = false;
//			PetriNetWindow frame2 = new PetriNetWindow(false);
//			frame2.petriNet = uvs2.pn;
//			frame2.setVisible(true);
			uvs2.pn.Start();  
	}

}
