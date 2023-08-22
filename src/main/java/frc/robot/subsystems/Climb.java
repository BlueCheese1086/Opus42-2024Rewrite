package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Climb extends SubsystemBase{
    // Motor config
    private final CANSparkMax leftClimb = new CANSparkMax(RobotMap.FRONT_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax rightClimb = new CANSparkMax(RobotMap.FRONT_RIGHT_ID, MotorType.kBrushless);

    // Encoder Config
    private final RelativeEncoder leftEncoder = leftClimb.getEncoder();
    private final RelativeEncoder rightEncoder = rightClimb.getEncoder();

    // Solenoid Config
    private final Solenoid lock = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.CLIMB_SOLENOID_ID);

    /** Creates a new Climb subsystem. */
    public Climb() {
        rightClimb.follow(leftClimb);
    }

    public void setSpeed(double speed) {
        leftClimb.set(speed);
    }

    public double getSpeed() {
        return leftClimb.get();
    }

    public void setLock(boolean state) {
        // Flipped because false is locked, and I want to think of this more as whether or not the lock is enabled.
        lock.set(!state);
    }

    public void toggleLock() {
        lock.toggle();
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