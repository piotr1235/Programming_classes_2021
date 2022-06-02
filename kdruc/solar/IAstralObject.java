package kdruc.solar;

import java.util.List;

public interface IAstralObject {
	/**
	 * Returns mass of an astral object
	 *
	 * @return object's mass
	 */
	public double mass();

	/**
	 * Returns current position of an astral object
	 *
	 * @return position vector r
	 */
	public Vector position();

	/**
	 * Returns current velocity of an astral object
	 *
	 * @return velocity vector v
	 */
	public Vector velocity();

	/**
	 * Returns current acceleration of an astral object
	 *
	 * @return acceleration vector a
	 */
	public Vector acceleration();

	/**
	 * Returns list of children in coordinate system of the parent object
	 *
	 * @return list of astral objects
	 */
	public List<IAstralObject> children();

	/**
	 * Updates position, velocity and acceleration of all children objects
	 *
	 * @param time small period of time to update
	 */
	public void update(int time);
}
