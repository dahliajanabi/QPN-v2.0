package Components;

public class LaneActivationParameter {

	public String QbitInput;
	public String QbitLaneName;
	public String ThetaConstantName;
	public String QbitGammaName;

	public LaneActivationParameter(String QbitInput, String QbitLaneName, String ThetaConstantName, String QbitGammaName) {
		this.QbitInput = QbitInput;
		this.QbitLaneName = QbitLaneName;
		this.ThetaConstantName = ThetaConstantName;
		this.QbitGammaName = QbitGammaName;
	}
}
