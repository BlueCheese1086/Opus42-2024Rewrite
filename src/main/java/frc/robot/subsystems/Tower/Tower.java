package frc.robot.subsystems.Tower;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Tower extends SubsystemBase {
    // Motor Config
    private final CANSparkMax tower1 = new CANSparkMax(RobotMap.Tower1ID, MotorType.kBrushless);
    private final CANSparkMax tower2 = new CANSparkMax(RobotMap.Tower2ID, MotorType.kBrushless);
    private final CANSparkMax tower3 = new CANSparkMax(RobotMap.Tower3ID, MotorType.kBrushless);
    private final CANSparkMax tower4 = new CANSparkMax(RobotMap.Tower4ID, MotorType.kBrushless);
    private final TalonFX frontShooter = new TalonFX(RobotMap.FrontShooterID);
    private final TalonFX backShooter = new TalonFX(RobotMap.BackShooterID);
    private final Servo hood = new Servo(RobotMap.HoodID);

    /**
     * Creates a new Tower subsystem.
     * This subsystem is in charge of controlling the tower and shooter.
     */
    public Tower() {
        // Getting the factory defaults of each motor.
        tower1.restoreFactoryDefaults();
        tower2.restoreFactoryDefaults();
        tower3.restoreFactoryDefaults();
        tower4.restoreFactoryDefaults();
        frontShooter.getConfigurator().apply(new TalonFXConfiguration());
        backShooter.getConfigurator().apply(new TalonFXConfiguration());

        // Inverts motors and makes them follow motor 1.
        tower2.follow(tower1, true);
        tower3.follow(tower1);
        tower4.follow(tower1, true);
        backShooter.setControl(new Follower(frontShooter.getDeviceID(), true));

        // Setting the IdleModes to brake.
        tower1.setIdleMode(IdleMode.kBrake);
        tower2.setIdleMode(IdleMode.kBrake);
        tower3.setIdleMode(IdleMode.kBrake);
        tower4.setIdleMode(IdleMode.kBrake);
    }

    /** Sets the speed of the tower. */
    public void setSpeed(double speed) {
        tower1.set(speed);
        frontShooter.set(speed);
        backShooter.set(speed);
    }

    /** Sets the servo hood position to a specified number of degrees. */
    public void setHoodPosition(double degrees) {
        hood.setAngle(degrees);
    }

    /** Gets the servo hood position. */
    public double getHoodPosition() {
        return hood.getAngle();
    }
}