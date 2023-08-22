package frc.robot.subsystems.Tower;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.MotorIds;

public class Tower extends SubsystemBase{
    // Motor Config
    private final CANSparkMax tower1 = new CANSparkMax(MotorIds.TOWER_ONE_ID, MotorType.kBrushless);
    private final CANSparkMax tower2 = new CANSparkMax(MotorIds.TOWER_TWO_ID, MotorType.kBrushless);
    private final CANSparkMax tower3 = new CANSparkMax(MotorIds.TOWER_THREE_ID, MotorType.kBrushless);
    private final CANSparkMax tower4 = new CANSparkMax(MotorIds.TOWER_FOUR_ID, MotorType.kBrushless);

    public Tower() {
        // Inverts motors and makes them follow motor 1.
        tower2.follow(tower1, true);
        tower3.follow(tower1);
        tower4.follow(tower1, true);
        /*
            tower1, + input
            tower2, - input
            tower3, + input
            tower4, - input
        */
    }

    public void set(double speed) {
        tower1.set(speed);
    }
}