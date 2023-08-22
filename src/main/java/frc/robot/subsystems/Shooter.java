package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants.RobotMap;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase{
    // Motor config
    private final TalonFX x = new TalonFX(RobotMap.LAUNCHER_X_ID);
    private final TalonFX y = new TalonFX(RobotMap.LAUNCHER_Y_ID);
    private final Servo hood = new Servo(RobotMap.HOOD_ID);

    /** Creates a new Shooter. */
    public Shooter() {
        x.config_kP(0, ShooterConstants.LAUNCHER_KP);
        x.config_kI(0, ShooterConstants.LAUNCHER_KI);
        x.config_kD(0, ShooterConstants.LAUNCHER_KD);
        x.config_kF(0, ShooterConstants.LAUNCHER_KF);

        y.setInverted(true);
        y.follow(x, FollowerType.PercentOutput);

        y.config_kP(0, ShooterConstants.LAUNCHER_KP);
        y.config_kI(0, ShooterConstants.LAUNCHER_KI);
        y.config_kD(0, ShooterConstants.LAUNCHER_KD);
        y.config_kF(0, ShooterConstants.LAUNCHER_KF);
    }

    /**
     * Runs the shooter at a specified speed.
     * @param speed The percent speed the motors will move at in a range of -1 to 1.
     */
    public void setSpeed(double speed) {
        set(speed);
    }

    /**
     * Runs the shooter at a specified speed.
     * @param speed The percent speed the motors will move at in a range of -1 to 1.
     */
    public void set(double speed) {
        x.set(TalonFXControlMode.PercentOutput, speed);
    }

    /**
     * Sets the servo hood position.
     * @param pos The desired position of the servo hood in a range of 0 to 180.
     */
    public void setHoodPosition(double degrees) {
        hood.setAngle(degrees);
    }

    /** Gets the servo hood position. */
    public double getHoodPosition() {
        return hood.getAngle();
    }
}