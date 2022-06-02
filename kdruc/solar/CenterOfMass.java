package kdruc.solar;

import java.util.List;

public class CenterOfMass extends AstralObject {
	public CenterOfMass(List<IAstralObject> astralObjects) {
		super();
		double totalMass = 0.0;
		Vector r = new Vector();
		for (IAstralObject astralObject : astralObjects) {
			totalMass += astralObject.mass();
			r = r.add(astralObject.position().scale(astralObject.mass()));
		}
		r = r.scale(1 / totalMass);
		setPosition(r);
		setMass(totalMass);
	}
}
