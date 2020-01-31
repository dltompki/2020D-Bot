/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The TankDrive command uses two joystick values from the DriveTrain subsystem to drive the robot
 * with the API tankDrive method.
 */
public class TankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final DriveTrain m_subsystem;

  private DifferentialDrive m_DifferentialDrive;

  /**
   * Creates a new TankDrive.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TankDrive(DriveTrain subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    m_DifferentialDrive = new DifferentialDrive(leftMotor, rightMotor)
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
