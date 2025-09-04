package MultiQbitUVS.Intersection_1;

import java.util.ArrayList;

import Components.Activation;
import Components.LaneActivationParameter;
import Components.Condition;
import Components.GuardMapping;
import Components.IntersectionActivationParameter;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataDigital;
import DataObjects.DataQplace;
import DataObjects.DataTheta;
import DataObjects.DataTransfer;
import DataObjects.DataUnitaryMatrix;
import DataObjects.DataUnitaryThetaMatrix;
import DataOnly.ComplexValue;
import DataOnly.Digital;
import DataOnly.Psivector;
import DataOnly.Qplace;
import DataOnly.Theta;
import DataOnly.TransferOperation;
import DataOnly.UnitaryMatrix;
import DataOnly.UnitaryThetaMatrix;
import DataOnly.UnitaryThetaMatrixValue;
import DataOnly.Vvector;
import DataOnly.QBit;
import Enumerations.LogicConnector;
import Enumerations.QplacePrintSetting;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import Enumerations.UnitaryThetaMatrixValueFuncType;

public class Intersection_1 {

	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Intersection_1";
		pn.NetworkPort = 1080;

		// -------------Unitary Matrixes----------------

		DataUnitaryMatrix constantValue1 = new DataUnitaryMatrix();
		constantValue1.SetName("MPlus");
		constantValue1.SetValue(new UnitaryMatrix(16, 16, 
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f,
				1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f));
		pn.ConstantPlaceList.add(constantValue1);

		DataUnitaryMatrix constantValue2 = new DataUnitaryMatrix();
		constantValue2.SetName("MMinus");
		constantValue2.SetValue(new UnitaryMatrix(16, 16, 
				0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
				0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f,
				1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
		pn.ConstantPlaceList.add(constantValue2);
		
		DataUnitaryMatrix constantValue3 = new DataUnitaryMatrix();
		constantValue3.SetName("I");
		constantValue3.SetValue(new UnitaryMatrix(16, 16, 
				1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
				0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f));
		pn.ConstantPlaceList.add(constantValue3);


				

		// ---------------------Places----------------------

		DataQplace pi1 = new DataQplace(); // input form lane 1 (1 qbit)
		pi1.SetName("p_i1");
		pi1.SetValue(new Qplace(
				new Psivector(16, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)       
						),QplacePrintSetting.PsiOnly));
		pn.PlaceList.add(pi1);

		DataQplace pi2 = new DataQplace(); // input from lane 2 (1 qbit)
		pi2.SetName("p_i2");
		pi2.SetValue(new Qplace(
				new Psivector(16, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)       
						),QplacePrintSetting.PsiOnly));
		pn.PlaceList.add(pi2);

		DataQplace pi3 = new DataQplace(); // input from lane 3 (1 qbit)
		pi3.SetName("p_i3");
		pi3.SetValue(new Qplace(
				new Psivector(16, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)       
						),QplacePrintSetting.PsiOnly));
		pn.PlaceList.add(pi3);

		DataQplace pi4 = new DataQplace(); // input from lane 4 (1 qbit)
		pi4.SetName("p_i4");
		pi4.SetValue(new Qplace(
				new Psivector(16, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)       
						),QplacePrintSetting.PsiOnly));
		pn.PlaceList.add(pi4);

		DataQplace p0 = new DataQplace(); // current state of all lanes //Qbit list of 4 (each item 16 Qbit)
		p0.SetName("p0");
		p0.SetValue(new Qplace(
				new Psivector(64, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)) 
						,QplacePrintSetting.PsiOnly));
		pn.PlaceList.add(p0);

		DataQplace p1 = new DataQplace(); // U*
		p1.SetName("p1");
		pn.PlaceList.add(p1);
		
		DataQplace p2 = new DataQplace(); // x
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataQplace p3 = new DataQplace(); // U'
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataQplace p4 = new DataQplace(); // x'
		p4.SetName("p4");
		pn.PlaceList.add(p4);

		DataQplace p5 = new DataQplace(); // x''
		p5.SetName("p5");
		pn.PlaceList.add(p5);

		DataQplace p6 = new DataQplace(); // E
		p6.SetName("p6");
		pn.PlaceList.add(p6);
		
		DataQplace p7 = new DataQplace(); // remaining cars after p5 split used 2nd shot to set p0
		p7.SetName("p7");
		pn.PlaceList.add(p7);

		DataQplace pe = new DataQplace(); // Em
		pe.SetName("p_e");
		pn.PlaceList.add(pe);

		DataDigital pc0 = new DataDigital();
		pc0.SetName("p_c0");
		pc0.SetValue(new Digital(1));
		pn.PlaceList.add(pc0);

		DataDigital pc1 = new DataDigital();
		pc1.SetName("p_c1");
		pc1.SetValue(new Digital(16));
		pn.PlaceList.add(pc1);

		DataDigital pc2 = new DataDigital(); // gets value after ti split
		pc2.SetName("p_c2"); 
		pn.PlaceList.add(pc2);

		DataDigital pc3 = new DataDigital(); // equals to pc1
		pc3.SetName("p_c3");
		pc1.SetValue(new Digital(16));
		pn.PlaceList.add(pc3);


		DataDigital pc4 = new DataDigital();
		pc4.SetName("p_c4");
		pc4.SetValue(new Digital(32));
		pn.PlaceList.add(pc4);

		DataDigital pcm = new DataDigital();
		pcm.SetName("p_cm");
		pcm.SetValue(new Digital(1));
		pn.PlaceList.add(pcm);

		DataQplace po = new DataQplace();
		po.SetName("p_o");
		pn.PlaceList.add(po);

		// op channels to other lanes in other intersections
		DataTransfer p_o1_out = new DataTransfer();
		p_o1_out.SetName("p_o1_out");
		p_o1_out.Value = new TransferOperation("localhost", "3084", "p_i1"); // to intersection 3 lane 4
		pn.PlaceList.add(p_o1_out);

		DataTransfer p_o2_out = new DataTransfer();
		p_o2_out.SetName("p_o2_out");
		p_o2_out.Value = new TransferOperation("localhost", "2081", "p_i1"); // to intersection 2 lane 1
		pn.PlaceList.add(p_o2_out);
		
		DataQplace p_zero1 = new DataQplace(); // zero place //Qbit list of 4 (each item 16 Qbit)
		p_zero1.SetName("p_zero1");
		p_zero1.Value =  new Qplace(
				new Psivector(64, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)) 
						,QplacePrintSetting.PsiOnly);
		pn.PlaceList.add(p_zero1);
		
		DataQplace p_zero2 = new DataQplace(); // zero place //Qbit list of 4 (each item 16 Qbit)
		p_zero2.SetName("p_zero2");
		p_zero2.Value =  new Qplace(
				new Psivector(64, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
				          new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)) 
						,QplacePrintSetting.PsiOnly);
		pn.PlaceList.add(p_zero2);
		
		// split places
		DataQplace ps1 = new DataQplace();
		ps1.SetName("p_s1");
		pn.PlaceList.add(ps1);

		DataQplace ps2 = new DataQplace();
		ps2.SetName("p_s2");
		pn.PlaceList.add(ps2);

		DataQplace ps3 = new DataQplace();
		ps3.SetName("p_s3");
		pn.PlaceList.add(ps3);

		DataQplace ps4 = new DataQplace();
		ps4.SetName("p_s4");
		pn.PlaceList.add(ps4);
		
		// Split values 
		DataDigital pv1 = new DataDigital();
		pv1.SetName("p_v1");
		pv1.SetValue(new Digital(16));
		pn.PlaceList.add(pv1);
		
		DataDigital pv2 = new DataDigital();
		pv2.SetName("p_v2");
		pv2.SetValue(new Digital(16));
		pn.PlaceList.add(pv2);
		
		DataDigital pv3 = new DataDigital();
		pv3.SetName("p_v3");
		pv3.SetValue(new Digital(16));
		pn.PlaceList.add(pv3);
		
	
		

		// -------------------Transitions----------------------
		
		// t0 ------------------------------------------------
		PetriTransition t0 = new PetriTransition(pn);
		t0.TransitionName = "t0";
		t0.InputPlaceName.add("p0");

		Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
		Condition T0Ct2 = new Condition(t0, "p_c0", TransitionCondition.NotNull);
		T0Ct2.SetNextCondition(LogicConnector.AND, T0Ct2);

		GuardMapping grdT0 = new GuardMapping();
		grdT0.condition = T0Ct1;

		ArrayList T0inputList = new ArrayList<String>();
		T0inputList.add("p0");
		ArrayList T0ConstantList = new ArrayList<String>();
		T0ConstantList.add("I");

		grdT0.Activations.add(new Activation(t0, T0inputList, T0ConstantList, TransitionOperation.UnitaryMatrix, "p2"));
		t0.GuardMappingList.add(grdT0);

		pn.Transitions.add(t0);

		// ti ------------------------------------------------
		PetriTransition ti = new PetriTransition(pn); //problem here the input is 4 places instead of 1
		ti.TransitionName = "ti";
		ti.InputPlaceName.add("p_i1");
		ti.InputPlaceName.add("p_i2");
		ti.InputPlaceName.add("p_i3");
		ti.InputPlaceName.add("p_i4");
		ti.InputPlaceName.add("p_zero1");

		Condition TiCt1 = new Condition(ti, "p_i1", TransitionCondition.NotNull);
		Condition TiCt2 = new Condition(ti, "p_i2", TransitionCondition.NotNull);
		Condition TiCt3 = new Condition(ti, "p_i3", TransitionCondition.NotNull);
		Condition TiCt4 = new Condition(ti, "p_i4", TransitionCondition.NotNull);
		Condition TiCt5 = new Condition(ti, "p_c1", TransitionCondition.NotNull);
		Condition TiCt6 = new Condition(ti, "p_zero1", TransitionCondition.NotNull);
		TiCt5.SetNextCondition(LogicConnector.AND, TiCt6);
		TiCt4.SetNextCondition(LogicConnector.AND, TiCt5);
		TiCt3.SetNextCondition(LogicConnector.AND, TiCt4);
		TiCt2.SetNextCondition(LogicConnector.AND, TiCt3);
		TiCt1.SetNextCondition(LogicConnector.AND, TiCt2);

		GuardMapping grdTi = new GuardMapping();
		grdTi.condition = TiCt1;

		ArrayList TiConstantList = new ArrayList<String>();
		TiConstantList.add("p_c1");
		TiConstantList.add("MMinus");
		TiConstantList.add("MPlus");
		
		ArrayList TioutputList = new ArrayList<String>();
		TioutputList.add("p1");
		TioutputList.add("p3");

		// split function
		grdTi.Activations.add(new Activation(ti, ti.InputPlaceName, TiConstantList, TransitionOperation.PsiLaneSplit, TioutputList));

		ti.GuardMappingList.add(grdTi);

		pn.Transitions.add(ti);

		// t1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1"); 
		t1.InputPlaceName.add("p2"); 

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		ArrayList T1inputList = new ArrayList<String>();
		T1inputList.add("p2");
		ArrayList T1ConstantList = new ArrayList<String>();
		T1ConstantList.add("MPlus");
		T1ConstantList.add("p_c2");
		grdT1.Activations
				.add(new Activation(t1, T1inputList, T1ConstantList, TransitionOperation.UnitaryMatrixWithLoop, "p4"));
		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// t2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p3"); 
		t2.InputPlaceName.add("p4"); 

		Condition T2Ct1 = new Condition(t2, "p3", TransitionCondition.NotNull);
		Condition T2Ct2 = new Condition(t2, "p4", TransitionCondition.NotNull);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;

		ArrayList T2inputList = new ArrayList<String>();
		T2inputList.add("p4");
		ArrayList T2ConstantList = new ArrayList<String>();
		T2ConstantList.add("MPlus");
		T2ConstantList.add("p_c3");

		grdT2.Activations
				.add(new Activation(t2, T2inputList, T2ConstantList, TransitionOperation.UnitaryMatrixWithLoop, "p3"));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// t3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p5"); 
		t3.InputPlaceName.add("p_zero2");

		Condition T3Ct1 = new Condition(t3, "p5", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t3, "p_c4", TransitionCondition.NotNull);
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;

		ArrayList T3ConstantList = new ArrayList<String>();
		T3ConstantList.add("p_c4");
		T3ConstantList.add("MMinus");
		T3ConstantList.add("MPlus");
		
		ArrayList T3outputList = new ArrayList<String>();
		T3outputList.add("p6");
		T3outputList.add("p7");
		T3outputList.add("p_c44");//DataDigital to save the increment

		// split function
		grdT3.Activations.add(new Activation(t3, t3.InputPlaceName, T3ConstantList, TransitionOperation.PsiLaneSplit, T3outputList));


		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// tm ------------------------------------------------
		PetriTransition tm = new PetriTransition(pn); // measurement
		tm.TransitionName = "tm";
		tm.InputPlaceName.add("p6"); 
		tm.InputPlaceName.add("p_cm");
		tm.IsReversible = true;

		Condition TmCt1 = new Condition(tm, "p6", TransitionCondition.NotNull);
		Condition TmCt2 = new Condition(tm, "p_cm", TransitionCondition.NotNull);
		TmCt1.SetNextCondition(LogicConnector.AND, TmCt2);

		GuardMapping grdTm = new GuardMapping();
		grdTm.condition = TmCt1;
		grdTm.Activations.add(new Activation(tm, "p6", TransitionOperation.Measurement, "p_e")); // measurement, the
																									// result is put in
																									// alpha only

		tm.GuardMappingList.add(grdTm);

		pn.Transitions.add(tm);

		// t4 ------------------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "t4";
		t4.InputPlaceName.add("p6"); 

		Condition T4Ct1 = new Condition(t4, "p6", TransitionCondition.NotNull);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4Ct1;

		ArrayList T4inputList = new ArrayList<String>();
		T4inputList.add("p6");
		ArrayList T4ConstantList = new ArrayList<String>();
		T4ConstantList.add("I");

		grdT4.Activations
				.add(new Activation(t4, T4inputList, T4ConstantList, TransitionOperation.UnitaryMatrix, "p_o"));

		t4.GuardMappingList.add(grdT4);

		pn.Transitions.add(t4);

		// t4 split-----------------------------------------------------
		PetriTransition t4split = new PetriTransition(pn); //split function not implemented yet
		t4split.TransitionName = "t4split";
		t4split.InputPlaceName.add("p_o");

		Condition T4sCt1 = new Condition(t4split, "p_o", TransitionCondition.NotNull);

		GuardMapping grdT4s = new GuardMapping();
		grdT4s.condition = T4sCt1;
		
		ArrayList splitValues = new ArrayList <String>();
		splitValues.add("p_v1");
		splitValues.add("p_v2");
		splitValues.add("p_v3");
		
		ArrayList outputt4split = new ArrayList<String>();
		outputt4split.add("P_s1");
		outputt4split.add("P_s2");
		outputt4split.add("P_s3");
		outputt4split.add("P_s4");

		grdT4s.Activations.add(new Activation(t4split, t4split.InputPlaceName, splitValues, TransitionOperation.PsiIntersectionSplit, outputt4split));

		pn.Transitions.add(t4split);

		// t4 out-----------------------------------------------------
		PetriTransition t4out = new PetriTransition(pn); 
		t4out.TransitionName = "t4out";
		t4out.InputPlaceName.add("p_s1");
		t4out.InputPlaceName.add("p_s2");
		t4out.InputPlaceName.add("p_s3");
		t4out.InputPlaceName.add("p_s4");

		Condition T4outCt1 = new Condition(t4, "p_s1", TransitionCondition.NotNull);
		Condition T4outCt2 = new Condition(t4, "p_s2", TransitionCondition.NotNull);
		Condition T4outCt3 = new Condition(t4, "p_s3", TransitionCondition.NotNull);
		Condition T4outCt4 = new Condition(t4, "p_s4", TransitionCondition.NotNull);
		T4outCt3.SetNextCondition(LogicConnector.AND, T4outCt4);
		T4outCt2.SetNextCondition(LogicConnector.AND, T4outCt3);
		T4outCt1.SetNextCondition(LogicConnector.AND, T4outCt2);

		GuardMapping grdT4out = new GuardMapping();
		grdT4out.condition = T4outCt1;
		
		grdT4out.Activations.add(new Activation(t4out, "P_s2",TransitionOperation.SendOverNetwork, "p_o1_out"));  
		grdT4out.Activations.add(new Activation(t4out, "P_s3",TransitionOperation.SendOverNetwork, "p_o2_out"));  

		// the two other outputs are just exits from model (consumed)

		// Start PN----------------------------------------------

		System.out.println("Quantum Split_1 started \n ------------------------------");
		pn.Delay = 1000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
