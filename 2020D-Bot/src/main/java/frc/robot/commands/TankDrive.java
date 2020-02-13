/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * The TankDrive command uses two joystick values from the DriveTrain subsystem to drive the robot
 * with the API tankDrive method.
 */
public class TankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final DriveTrain m_DriveTrain;

  /**
   * Creates a new TankDrive.
   * Adds DriveTrain as a requirement.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TankDrive(DriveTrain subsystem) {
    m_DriveTrain = subsystem;

    addRequirements(subsystem);
  }

  @Override
  /**
   * Calls the tank drive method with joystick values as arguments.
   */
  public void execute() {
    m_DriveTrain.tankDrive(m_DriveTrain.getJoystickR(), m_DriveTrain.getJoystickL());
  }
}
