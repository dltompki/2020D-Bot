/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

/*
* The DriveTrain subsystem controls the movement of the robot around the field, using joysticks
* as inputs and outputting to the drive motors.
*/
public class DriveTrain extends SubsystemBase {

  public static double JoystickL;
  public static double JoystickR;

  private Joystick m_JoystickL;
  private Joystick m_JoystickR;

  private CANSparkMax m_SparkMaxFL;
  private CANSparkMax m_SparkMaxFR;
  private CANSparkMax m_SparkMaxBL;
  private CANSparkMax m_SparkMaxBR;

  private SpeedControllerGroup m_LeftControllerGroup;
  private SpeedControllerGroup m_RightControllerGroup;

  private DifferentialDrive m_DifferentialDrive;

  public DriveTrain() {

    setDefaultCommand(defaultCommand);

    m_JoystickL = new Joystick(Constants.kJoystickL);
    m_JoystickR = new Joystick(Constants.kJoystickR);

    m_SparkMaxFL = new CANSparkMax(Constants.kDriveSparkFL, MotorType.kBrushless);
    m_SparkMaxFR = new CANSparkMax(Constants.kDriveSparkFR, MotorType.kBrushless);
    m_SparkMaxBL = new CANSparkMax(Constants.kDriveSparkBL, MotorType.kBrushless);
    m_SparkMaxBR = new CANSparkMax(Constants.kDriveSparkBR, MotorType.kBrushless);

    m_LeftControllerGroup = new SpeedControllerGroup(m_SparkMaxFL, m_SparkMaxBL);
    m_RightControllerGroup = new SpeedControllerGroup(m_SparkMaxFR, m_SparkMaxBR);

    m_DifferentialDrive = new DifferentialDrive(m_LeftControllerGroup, m_RightControllerGroup);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    JoystickR = getJoystickR();
    JoystickL = getJoystickL();

  }

  public double getJoystickR() {
    return m_JoystickR.getY();
  }

  public double getJoystickL() {
    return m_JoystickL.getY();
  }

  public void tankDrive(double rightSpeed, double leftSpeed) {
    m_DifferentialDrive.tankDrive(leftSpeed, rightSpeed, false);
  }

  public void slowTankDrive(double rightSpeed, double leftSpeed) {
    m_DifferentialDrive.tankDrive(leftSpeed, rightSpeed, true);
  }
}
