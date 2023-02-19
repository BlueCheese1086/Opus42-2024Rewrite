// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drivetrain.*;
import frc.robot.commands.Intake.*;
import frc.robot.commands.Tower.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Controllers
  private final Joystick joystick = new Joystick(1);
  private final XboxController xbox = new XboxController(2);

  // Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Tower tower = new Tower();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.
    drivetrain.setDefaultCommand(xboxTankDrive());
    String defaultCommand = drivetrain.getDefaultCommand().toString();          
    
    System.out.println(defaultCommand);
    
    new JoystickButton(joystick, 2).onTrue(new ToggleIntake(intake));
    new JoystickButton(joystick, 1).whileTrue(new RunIntake(intake));
    new JoystickButton(joystick, 3).whileTrue(new ClearIntake(intake));

    new JoystickButton(joystick, 5).whileTrue(new RunTower(tower));
    new JoystickButton(joystick, 6).whileTrue(new ClearTower(tower));
      
    // Add launcher capability for Joysticks
    
    /*
    new JoystickButton(xbox, Button.kX.value).onTrue(new ToggleIntake(intake));
    new JoystickButton(xbox, Button.kA.value).whileTrue(new RunIntake(intake));
    new JoystickButton(xbox, Button.kB.value).whileTrue(new ClearIntake(intake));

    new JoystickButton(xbox, Button.kLeftBumper.value).whileTrue(new RunTower(tower));
    new JoystickButton(xbox, Button.kRightBumper.value).whileTrue(new ClearTower(tower));
    */
  }

  /**
   * Use this to pass the ArcadeDrive command to the main {@link Robot} class.
   * Input type: Joystick (May require extra modification due to differences in joystick mapping.)
   * @return The command to run in teleop.
   */
  public Command joystickArcadeDrive() {
    // An ArcadeDrive command will run in teleop.
    return new ArcadeDrive(drivetrain, () -> joystick.getRawAxis(2), () -> -joystick.getRawAxis(1), Constants.Drivetrain.squareInputs);
  }
  
  /**
   * Use this to pass the ArcadeDrive command to the main {@link Robot} class.
   * Input type: Xbox Remote
   * 
   * @return The command to run in teleop.
   */
  public Command xboxArcadeDrive() {
    // An ArcadeDrive command will run in teleop.
    return new ArcadeDrive(drivetrain, () -> -xbox.getLeftY(), () -> xbox.getRightX(), Constants.Drivetrain.squareInputs);
  }

  /**
   * Use this to pass the TankDrive command to the main {@link Robot} class.
   * Input type: Joystick (May require extra modification due to differences in joystick mapping.)
   * @return The command to run in teleop.
   */
  public Command joystickTankDrive(){
    // A TankDrive command will run in teleop.
    return new TankDrive(drivetrain, () -> joystick.getRawAxis(2), () -> joystick.getRawAxis(1), false);
  }

  /**
   * Use this to pass the TankDrive command to the main {@link Robot} class.
   * Input type: Xbox Remote
   * 
   * @return The command to run in teleop.
   */
  public Command xboxTankDrive(){
    // A TankDrive command will run in teleop.
    return new TankDrive(drivetrain, () -> -xbox.getLeftY(), () -> -xbox.getRightY(), false);
  }
}   