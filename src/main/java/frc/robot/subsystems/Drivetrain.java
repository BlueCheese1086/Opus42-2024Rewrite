package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase{
    // Motor config
    private final CANSparkMax frontLeftMotor = new CANSparkMax(RobotMap.FRONT_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax frontRightMotor = new CANSparkMax(RobotMap.FRONT_RIGHT_ID, MotorType.kBrushless);
    private final CANSparkMax backLeftMotor = new CANSparkMax(RobotMap.BACK_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax backRightMotor = new CANSparkMax(RobotMap.BACK_RIGHT_ID, MotorType.kBrushless);

    // Encoder config
    private final RelativeEncoder leftEncoder = frontLeftMotor.getEncoder();
    private final RelativeEncoder rightEncoder = frontRightMotor.getEncoder();

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        frontLeftMotor.setInverted(true);
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);
    }

    /** Drives the robot with the y axis of one joystick and the x axis of another.  Drives robots in a way similar to how most games are played. */
    public void arcadeDrive(double xSpeed, double zRotation) {
        // Applies a deadband to the inputs.
        MathUtil.applyDeadband(xSpeed, DriveConstants.deadband);
        MathUtil.applyDeadband(zRotation, DriveConstants.deadband);

        // Square the inputs (while preserving the sign) to increase fine control while permitting full power.
        if (DriveConstants.squareInputs) {
            xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
            zRotation = Math.copySign(zRotation * zRotation, zRotation);
        }

        // Creates the saturated speeds of the motors
        double leftSpeed = xSpeed - zRotation;
        double rightSpeed = xSpeed + zRotation;

        // Finds the maximum possible value of throttle + turn along the vector that the joystick is pointing, and then desaturates the wheel speeds.
        double greaterInput = Math.max(Math.abs(xSpeed), Math.abs(zRotation));
        double lesserInput = Math.min(Math.abs(xSpeed), Math.abs(zRotation));
        if (greaterInput == 0.0) {
            leftSpeed = 0;
            rightSpeed = 0;
        } else {
            double saturatedInput = (greaterInput + lesserInput) / greaterInput;
            leftSpeed /= saturatedInput;
            rightSpeed /= saturatedInput;
        }

        // Sets the speed of the motors.
        frontLeftMotor.set(leftSpeed * DriveConstants.maxSpeed);
        frontRightMotor.set(rightSpeed * DriveConstants.maxSpeed);
    }

    public double getAvgInches() {
        return frontLeftMotor.getEncoder().getPosition();
    }

    public void resetEncoders() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }

    public double getLeftDistanceInch() {
        return leftEncoder.getPosition();
    }

    public double getRightDistanceInch() {
        return rightEncoder.getPosition();
    }

    public double getAverageDistanceInch() {
        return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
    }
}