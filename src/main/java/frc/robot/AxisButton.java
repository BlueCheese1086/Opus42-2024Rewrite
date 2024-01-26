package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** A {@link Button} that gets its state from a {@link GenericHID}. */
public class AxisButton extends Trigger {
	/**
	 * Create a gamepad axis for triggering commands as if it were a button.
	 *
	 * @param joystick The GenericHID object that has the axis (e.g. Joystick, KinectStick, etc)
	 * @param axisNumber The axis number (see {@link GenericHID#getRawAxis(int)})
	 * @param threshold The threshold above which the axis shall trigger a command
	 */
	public AxisButton(GenericHID joystick, int axisNumber, double threshold) {
		super(() -> Math.abs(joystick.getRawAxis(axisNumber)) > threshold);
	}
}