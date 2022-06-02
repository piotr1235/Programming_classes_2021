package kdruc.solar;

public class Planet extends AstralObject {
	private final String name;

	public Planet(String name, double mass) {
		super(mass);
		this.name = name;
	}
}
