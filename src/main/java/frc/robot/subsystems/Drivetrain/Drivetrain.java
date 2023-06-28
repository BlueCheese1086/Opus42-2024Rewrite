package frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DifferentialDrive;
import frc.robot.Reset;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{
    // Motor config
    private final CANSparkMax frontLeftMotor = new CANSparkMax(Constants.Drivetrain.FRONT_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax frontRightMotor = new CANSparkMax(Constants.Drivetrain.FRONT_RIGHT_ID, MotorType.kBrushless);
    private final CANSparkMax backLeftMotor = new CANSparkMax(Constants.Drivetrain.BACK_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax backRightMotor = new CANSparkMax(Constants.Drivetrain.BACK_RIGHT_ID, MotorType.kBrushless);

    // List for quick reset
    private final CANSparkMax[] motors = {frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor};

    // DifferentialDrive class is very useful!
    public final DifferentialDrive diffDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        Reset.reset(motors);

        frontLeftMotor.setInverted(true);
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);
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
}
