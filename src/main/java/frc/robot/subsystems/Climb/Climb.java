package frc.robot.subsystems.Climb;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Climb extends SubsystemBase {
    // Motor config
    private final CANSparkMax leftClimb = new CANSparkMax(RobotMap.LeftClimbID, MotorType.kBrushless);
    private final CANSparkMax rightClimb = new CANSparkMax(RobotMap.RightClimbID, MotorType.kBrushless);

    // Encoder Config
    private final RelativeEncoder leftEncoder = leftClimb.getEncoder();
    private final RelativeEncoder rightEncoder = rightClimb.getEncoder();

    // Solenoid Config
    private final Solenoid lock = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.ClimbSolenoidID);

    /** Creates a new Drivetrain. */
    public Climb() {
        rightClimb.follow(leftClimb);
    }

    public void setSpeed(double speed) {
        leftClimb.set(speed);
    }

    public void setLock(boolean state) {
        lock.set(state);
    }

    public boolean getLock() {
        return lock.get();
    }

    public double getLeftDistance() {
        return leftEncoder.getPosition();
    }

    public double getRightDistance() {
        return rightEncoder.getPosition();
    }

    public double getAvgDistance() {
        return (getLeftDistance() + getRightDistance()) / 2;
    }
}