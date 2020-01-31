/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/*
* The DriveTrain subsystem controls the movement of the robot around the field, using joysticks
* as inputs and outputting to the drive motors.
*/
public class DriveTrain extends SubsystemBase {

  public double JoystickL;
  public double JoystickR;

  private Joystick m_JoystickL;
  private Joystick m_JoystickR;

  public CANSparkMax m_SparkMax1;
  public CANSparkMax m_SparkMax2;
  public CANSparkMax m_SparkMax3;
  public CANSparkMax m_SparkMax4;

  public DriveTrain() {

    m_JoystickL = new Joystick(0);
    m_JoystickR = new Joystick(1);

    m_SparkMax1 = new CANSparkMax(1, MotorType.kBrushless);

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
}
