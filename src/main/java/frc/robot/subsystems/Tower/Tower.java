package frc.robot.subsystems.Tower;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Tower extends SubsystemBase {
    // Motor Config
    private final CANSparkMax tower1 = new CANSparkMax(RobotMap.TOWER_ONE_ID, MotorType.kBrushless);
    private final CANSparkMax tower2 = new CANSparkMax(RobotMap.TOWER_TWO_ID, MotorType.kBrushless);
    private final CANSparkMax tower3 = new CANSparkMax(RobotMap.TOWER_THREE_ID, MotorType.kBrushless);
    private final CANSparkMax tower4 = new CANSparkMax(RobotMap.TOWER_FOUR_ID, MotorType.kBrushless);

    public Tower() {
        // Inverts motors and makes them follow motor 1.
        tower2.follow(tower1, true);
        tower3.follow(tower1);
        tower4.follow(tower1, true);
    }

    public void set(double speed) {
        tower1.set(speed);
    }
}