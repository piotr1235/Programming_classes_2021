package kdruc.solar;

import java.util.List;

public class AstralObject implements IAstralObject {

	private final double mass;

	public AstralObject(double mass) {
		this.mass = mass;
	}

	@Override
	public double mass() {
		return mass;
	}

	@Override
	public Vector position() {
		return null;
	}

	@Override
	public Vector velocity() {
		return null;
	}

	@Override
	public Vector acceleration() {
		return null;
	}

	@Override
	public List<IAstralObject> children() {
		return null;
	}

	@Override
	public void update(int time) {

	}
}
