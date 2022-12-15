// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {
  Talon md1 = new Talon(1);
  Talon md2 = new Talon(3);
  Talon mi1 = new Talon(2);
  Talon mi2 = new Talon(4);

  Joystick control = new Joystick(0);

  MotorControllerGroup mds = new MotorControllerGroup(md1, md2);
  MotorControllerGroup mis = new MotorControllerGroup(mi1, mi2);
  DifferentialDrive chas = new DifferentialDrive(mds,mis);

  @Override
  public void robotInit() {}
  @Override
  public void robotPeriodic() {}
  @Override
  public void autonomousInit() {}
  @Override
  public void autonomousPeriodic() {}
  @Override
  public void teleopInit() {}
  @Override
  public void teleopPeriodic() {
   chas.arcadeDrive(control.getRawAxis(3) - control.getRawAxis(2),-control.getRawAxis(0));
  }
  @Override
  public void disabledInit() {}
  @Override
  public void disabledPeriodic() {}
  @Override
  public void testInit() {}
  @Override
  public void testPeriodic() {}
  @Override
  public void simulationInit() {}
  @Override
  public void simulationPeriodic() {}
}
