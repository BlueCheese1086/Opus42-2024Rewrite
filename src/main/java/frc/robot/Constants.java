// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class RobotMap { // Assume that all motors are CANSparkMax unless stated otherwise.
        // Drivetrain Subsystem IDs
        public static final int FrontLeftID = 1;
        public static final int FrontRightID = 2;
        public static final int BackLeftID = 3;
        public static final int BackRightID = 4;

        // Climb Subsystem IDs
        public static final int LeftClimbID = 11;
        public static final int RightClimbID = 12;
        public static final int ClimbSolenoidID = 2;
        
        // Intake Subsystem IDs
        public static final int LeftIntakeID = 21;
        public static final int RightIntakeID = 22;
        public static final int TopIntakeID = 31;
        public static final int IntakeSolenoidID = 3;
        
        // Tower Subsystem IDs
        public static final int Tower1ID = 41; // back top
        public static final int Tower2ID = 42; // back bottom
        public static final int Tower3ID = 43; // front bottom
        public static final int Tower4ID = 44; // front top
        
        // Shooter Subsystem IDs
        public static final int FrontShooterID = 51; // TalonFX
        public static final int BackShooterID = 52; // TalonFX
        public static final int HoodID = 3; // Servo
    }
    
    public static class ShooterConstants { // Constants for the shooter
        public static final double LAUNCHER_DEFAULT_VELOCITY = 9.0; // meters/second

        public static final double LAUNCHER_MIN_ANGLE = 80.2141;
        public static final double LAUNCHER_MAX_ANGLE = 90;

        public static final double CAMERA_HEIGHT = 0.762; // meters
        public static final double CAMERA_ANGLE = 45; // degrees
        public static final double LAUNCHER_WHEEL_DIAMETER = 0.1016; // meters??
        public static final double LAUNCHER_WHEEL_CIRCUMFERENCE = 2 * Math.PI * (LAUNCHER_WHEEL_DIAMETER / 2);
        public static final double LAUNCHER_ENCODER_UNITS_PER_ROTATION = 2048.0;
        public static final double LAUNCHER_MAX_VELOCITY = 6380.0 * 2048.0 / 600.0;

        public static final double UPPER_HUB_HEIGHT = 2.64; // meters
        public static final double GRAVITY = 9.8; // meters/second
        public static final double CARGO_DIAMETER = 0.24;

        public static final double DRIVETRAIN_POSITION_SCALE = (8.98) / (CARGO_DIAMETER * Math.PI); // m -> rotation
        public static final double WHEEL_TO_WHEEL_RADIUS = Math.sqrt(Math.pow(74.72, 2) + Math.pow(52.75, 2)); // cm

        public static final double TURN_ERROR = 0.005 * DRIVETRAIN_POSITION_SCALE; // Rotations
        public static final double DRIVE_ERROR = 0.003 * DRIVETRAIN_POSITION_SCALE; // Rotaions
    }

    public static class DriveConstants { // Constants for the drivetrain
        public static final boolean squareInputs = true;
        public static final double maxSpeed = 0.5;
        public static final double deadband = 0.2;

        public static final double Ks = 0.37003;
        public static final double Kv = 1.1603;
        public static final double Ka = 0.40226;

        public static final double MAX_FORWARD_VELOCITY = 6.0; // meters/second
        public static final double MAX_TURNING_VELOCITY = 20; // radians/second

        // Ramsete stuff
        public static final double b = 1.25;
        public static final double zeta = 1;

        // PID Things
        public static final double MP_DRIVE_KP = 1.0 / 1000.0;
        public static final double MP_DRIVE_KI = 0;
        public static final double MP_DRIVE_KD = 0;
        public static final double MP_DRIVE_FF = 1.0 / 5676.0;

        public static final double TRACK_WIDTH = 0.762; // Meters
        public static final double WHEEL_CIRCUMPHRENCE = Units.inchesToMeters(6 * Math.PI); // Meters
        public static final double GEARBOX_RATIO = 8.89;

        public static final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(TRACK_WIDTH);
        public static final DifferentialDriveWheelSpeeds wheelSpeeds = new DifferentialDriveWheelSpeeds(0.0, 0.0);
    }
}