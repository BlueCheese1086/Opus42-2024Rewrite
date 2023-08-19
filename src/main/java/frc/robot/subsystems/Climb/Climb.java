package frc.robot.subsystems.Climb;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.Direction;
import frc.robot.Constants.RobotMap;

public class Climb extends SubsystemBase{
    // Motor+Solenoid config
    private final CANSparkMax leftMotor = new CANSparkMax(RobotMap.CLIMB_LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(RobotMap.CLIMB_RIGHT_ID, MotorType.kBrushless);
    private final Solenoid climbLock = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.CLIMB_SOLENOID_ID);

    /** Creates a new Climb. */
    public Climb() {
        rightMotor.follow(leftMotor, true);
    }

    public void start(Direction direction) {
        switch (direction) {
            case UP:
                leftMotor.set(1);
                break;
            case DOWN:
                leftMotor.set(-1);
                break;
        }
    }

    public void stop() {
        leftMotor.set(0);
    }

    public void toggleLock() {
        climbLock.set(!climbLock.get());
    }
}