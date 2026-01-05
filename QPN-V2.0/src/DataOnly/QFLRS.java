package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import Enumerations.FZ;

public class QFLRS implements Cloneable, Serializable {
	public ArrayList<QFLRSPart> Parts;

	public QFLRS(FV... flrsValues) {
		Parts = new ArrayList<QFLRSPart>();
		if (flrsValues.length == 4) {
			int index = 0;
			for (FZ zone : FZ.values()) {
				Parts.add(new QFLRSPart(zone, flrsValues[index]));
				++index;
			}
		}

		if (flrsValues.length == 16) {
			int index = 0;
			for (FZ zone1 : FZ.values()) {
				for (FZ zone2 : FZ.values()) {
						Parts.add(new QFLRSPart(zone1, zone2, flrsValues[index]));
						++index;
				}
			}
		}
	}

	public void Print() {
		StringBuilder header = new StringBuilder();
		StringBuilder line = new StringBuilder();

		if (Parts.size() == 4) {
			header.append("(X1)");
			line.append("___");
			int index = 0;
			for (FZ zone : FZ.values()) {
					header.append("[" + zone + "]");
					line.append("[" + Parts.get(index++).ToString() + "]");
				
			}
			System.out.println(header.toString());
			System.out.println(line.toString());
		}

		if (Parts.size() == 16) {
			header.append("(X1/X2)");
			boolean headerPrinted = false;
			int index = 0;
			for (FZ zone1 : FZ.values()) {
				
					line.append(zone1 + "::");
					for (FZ zone2 : FZ.values()) {
							header.append("[" + zone2 + "]");
							line.append("[" + Parts.get(index++).ToString() + "]");
					if (!headerPrinted) {
						System.out.println(header.toString());
						headerPrinted = true;
					}
					System.out.println(line.toString());
					line = new StringBuilder();
				}
			}
		}

	}
}
