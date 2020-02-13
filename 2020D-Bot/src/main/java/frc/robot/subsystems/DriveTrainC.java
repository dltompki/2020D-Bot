/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTrainC extends DriveTrain {

  /**
   * Creates a new DriveTrainC. Creates a {@link DifferentialDrive} using the motor configuration on the competition robot.
   * 
   * @param driveStickL The {@link Joystick} that controls the left side of the robot.
   * @param driveStickR The {@link Joystick} that controls the right side of the robot.
   */
  public DriveTrainC(Joystick driveStickL, Joystick driveStickR) {
    super(
      new DifferentialDrive(
        new SpeedControllerGroup(
          new CANSparkMax(Constants.kDriveSparkFL, MotorType.kBrushless), 
          new CANSparkMax(Constants.kDriveSparkBL, MotorType.kBrushless)
        ), 
        new SpeedControllerGroup(
          new CANSparkMax(Constants.kDriveSparkFR, MotorType.kBrushless), 
          new CANSparkMax(Constants.kDriveSparkBR, MotorType.kBrushless)
        )
      ),
      driveStickL,
      driveStickR
    );

  }

}
