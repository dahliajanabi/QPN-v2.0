package Enumerations;

import java.io.Serializable;

public enum TransitionOperation implements Serializable{
	Undefined,
	SendOverNetwork,
	StopPetriNet,
	MakeNull,
	UnitaryMatrix,
	UnitaryMatrixJoin2by1,
	ThetaUnitaryMatrix,
	UnitaryMatrixV,
	CustomUnitaryMatrixV,
	ThetaUnitaryMatrixV,
	SplitQbit,
	SplitRangeQbit,
	SplitIndexesQbit,
	Measurement,
	LaneSplit,
	LaneSplitWithoutOutputThetas,
	IntersectionSplit,
	WriteToFile,
	Throughput,
	exits,
	PsiLaneSplit,
	UnitaryMatrixWithLoop,
	PsiIntersectionSplit,
	ThetaUnitaryMatrixPsi,
	FuzzificationOneQbit,
	FuzzificationTwoQbits,
	QFLRS
}
