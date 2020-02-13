/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.commands.TankDrive;

/*
* The DriveTrain subsystem controls the movement of the robot around the field, using joysticks
* as inputs and outputting to the drive motors.
*/
public class DriveTrain extends SubsystemBase {
  private Joystick m_JoystickL;
  private Joystick m_JoystickR;

  private DifferentialDrive m_DifferentialDrive;

  /**
   * Creates a new DriveTrain
   * 
   * @param differentialDrive The {@link DifferentialDrive} that DriveTrain interacts with the motors through.
   * @param driveStickL The {@link Joystick} that controls the left side of the DriveTrain using {@link tankDrive}.
   * @param driveStickR The {@link Joystick} that controls the right side of the Drivetrian using {@link tankDrive}.
   */
  public DriveTrain(DifferentialDrive differentialDrive, Joystick driveStickL, Joystick driveStickR) {
    setDefaultCommand(new TankDrive(this));

    m_JoystickL = driveStickL;
    m_JoystickR = driveStickR;

    m_DifferentialDrive = differentialDrive;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Gets the value of the vertical axis on the right {@link Joystick}.
   * 
   * @return The value of the vertical axis on the right {@link Joystick}.
   */
  public double getJoystickR() {
    return m_JoystickR.getY();
  }

  /**
   * Gets the value of the vertical axis on the left {@link Joystick}.
   * 
   * @return The value of the vertical axis on the left {@link Joystick}.
   */
  public double getJoystickL() {
    return m_JoystickL.getY();
  }

  /**
   * Operates the {@link DifferentialDrive} using the {@link tankDrive} method at normal speed.
   * 
   * @param rightSpeed The speed the right side of the {@link tankDrive}
   * @param leftSpeed The speed the left side of the {@link tankDrive}
   */
  public void tankDrive(double rightSpeed, double leftSpeed) {
    m_DifferentialDrive.tankDrive(leftSpeed, rightSpeed, true);
  }

  /**
   * Operates the {@link DifferentialDrive} using the {@link tankDrive} method at slow speed.
   * 
   * @param rightSpeed The speed the right side of the {@link tankDrive}
   * @param leftSpeed The speed the left side of the {@link tankDrive}
   */
  public void slowTankDrive(double rightSpeed, double leftSpeed) {
    m_DifferentialDrive.tankDrive(leftSpeed, rightSpeed, false);
  }
}
