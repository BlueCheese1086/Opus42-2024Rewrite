package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import frc.robot.commands.Reset;

public class Tower extends SubsystemBase{
    // Motor declaration
    //private final Talon launcher1 = new Talon(Constants.Launcher.LAUNCHER_X_ID);
    //private final Talon launcher2 = new Talon(Constants.Launcher.LAUNCHER_Y_ID);

    private final CANSparkMax tower1 = new CANSparkMax(Constants.Tower.TOWER_ONE_ID, MotorType.kBrushless);
    private final CANSparkMax tower2 = new CANSparkMax(Constants.Tower.TOWER_TWO_ID, MotorType.kBrushless);
    private final CANSparkMax tower3 = new CANSparkMax(Constants.Tower.TOWER_THREE_ID, MotorType.kBrushless);
    private final CANSparkMax tower4 = new CANSparkMax(Constants.Tower.TOWER_FOUR_ID, MotorType.kBrushless);

    // List for quick reset
    private final CANSparkMax[] motors = {tower1, tower2, tower3, tower4};

    public Tower(){
        // Firmware reset
        Reset.reset(motors);

        tower4.follow(tower1, true);
        tower3.follow(tower1);
        tower4.follow(tower1, true);
        /*
            tower1, + input
            tower2, - input
            tower3, + input
            tower4, - input
        */
    }

    public void runTower(){
        tower1.set(0.25);
    }
    
    public void clearTower(){
        tower1.set(0.25);
    }

    public void stopTower(){
        tower1.set(0);
    }
}