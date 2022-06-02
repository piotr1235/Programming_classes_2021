package kdruc.solar;

public class CalculateChange {

	public static AstralObject updateAstralObject(AstralObject astralObject, AstralObject centerOfMass) {
		double m2 = centerOfMass.mass() - astralObject.mass();
		Vector r2 = ((centerOfMass.position().scale(centerOfMass.mass()).add(astralObject.position().scale(-astralObject.mass()))).scale(1 / m2);


	}
}
