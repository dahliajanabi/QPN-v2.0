package Enumerations;

public enum Orientation {
	Right(0), Left(1), Up(2), Down(3);

	public final int Value;

	private Orientation(int value) {
		Value = value;
	}
}
