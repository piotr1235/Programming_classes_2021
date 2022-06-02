package kdruc.solar;

import java.util.ArrayList;
import java.util.List;

public class AstralObject implements IAstralObject {

	private double mass;
	private Vector position;
	private Vector velocity;
	private Vector acceleration;
	private List<IAstralObject> children;

	public AstralObject(){
		this(0.0, new Vector(), new Vector(), new Vector());
	}

	public AstralObject(double mass, Vector position, Vector velocity, Vector acceleration) {
		this.mass = mass;
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
		children = new ArrayList();
	}

	@Override
	public double mass() {
		return mass;
	}

	public void setMass(double mass) {this.mass = mass;}

	@Override
	public Vector position() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	@Override
	public Vector velocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	@Override
	public Vector acceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector acceleration) {
		this.acceleration = acceleration;
	}

	@Override
	public List<IAstralObject> children() {
		return children;
	}
	public void addChild(AstralObject astralObject){
		children.add(astralObject);
	}

	@Override
	public void update(int time) {
		AstralObject centerOfMass = new CenterOfMass(children);
		List<IAstralObject> updatedChildren = new ArrayList<>();
			for(IAstralObject child : children){

			}
			children = updatedChildren;
	}
}
