package frc.robot.subsystems.Drivetrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.MotorIds;
import frc.robot.DifferentialDrive;

public class Drivetrain extends SubsystemBase{
    // Motor config
    private final CANSparkMax frontLeftMotor = new CANSparkMax(MotorIds.FRONT_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax frontRightMotor = new CANSparkMax(MotorIds.FRONT_RIGHT_ID, MotorType.kBrushless);
    private final CANSparkMax backLeftMotor = new CANSparkMax(MotorIds.BACK_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax backRightMotor = new CANSparkMax(MotorIds.BACK_RIGHT_ID, MotorType.kBrushless);

    // Encoder config
    private final RelativeEncoder leftEncoder = frontLeftMotor.getEncoder();
    private final RelativeEncoder rightEncoder = frontRightMotor.getEncoder();

    // DifferentialDrive class is very useful!
    public final DifferentialDrive diffDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        frontLeftMotor.setInverted(true);
        backLeftMotor.follow(frontLeftMotor, false);
        frontRightMotor.setInverted(false);
        backRightMotor.follow(frontRightMotor, false);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}

    public void arcadeDrive(double xAxisSpeed, double zAxisRotate, boolean squareInputs){
        diffDrive.arcadeDrive(xAxisSpeed, zAxisRotate, squareInputs);
    }

    public void tankDrive(double leftMotor, double rightMotor, boolean squareInputs){
        diffDrive.tankDrive(leftMotor, rightMotor, squareInputs);
    }

    public double getAvgInches() {
        return frontLeftMotor.getEncoder().getPosition();
    }

    public void resetEncoders() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
        
    }
}
