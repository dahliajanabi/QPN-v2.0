package Enumerations;

import java.io.Serializable;

public enum PetriObjectType implements Serializable{
	Undefined,
	PetriNet,
	PetriPlace,
	PetriTransition,
	PetriData,
	DataUnitaryMatrix,
	DataTransfer,
	DataPsivector,
	DataVvector,
	DataTheta,
	DataDigitalPlace,
	DataUnitaryThetaMatrix,
	DataQplace
}
