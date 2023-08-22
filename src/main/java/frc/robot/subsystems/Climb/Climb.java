package frc.robot.subsystems.Climb;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.MotorIds;

public class Climb extends SubsystemBase{
    // Motor config
    private final CANSparkMax leftClimb = new CANSparkMax(MotorIds.FRONT_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax rightClimb = new CANSparkMax(MotorIds.FRONT_RIGHT_ID, MotorType.kBrushless);

    // Encoder Config
    private final RelativeEncoder leftEncoder = leftClimb.getEncoder();
    private final RelativeEncoder rightEncoder = rightClimb.getEncoder();

    // Solenoid Config
    private final Solenoid lock = new Solenoid(PneumaticsModuleType.CTREPCM, MotorIds.CLIMB_SOLENOID_ID);

    /** Creates a new Drivetrain. */
    public Climb() {
        rightClimb.follow(leftClimb);
    }

    public void set(double speed) {
        leftClimb.set(speed);
    }

    public void lock() {
        lock.set(false);
    }

    public void unlock() {
        lock.set(true);
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
