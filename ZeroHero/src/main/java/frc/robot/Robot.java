// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.dsfdsf

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
 
 //------MOTORES-------/////
  WPI_TalonSRX motorDer1 = new WPI_TalonSRX(0);
  WPI_TalonSRX motorDer2 = new WPI_TalonSRX(1);
  MotorControllerGroup motoresDerecha = new MotorControllerGroup(motorDer1, motorDer2);

  WPI_TalonSRX motorIzq1 = new WPI_TalonSRX(2);
  WPI_TalonSRX motorIzq2 = new WPI_TalonSRX(3);
  MotorControllerGroup motoresIzquierda = new MotorControllerGroup(motorIzq1, motorIzq2);

  DifferentialDrive chassis = new DifferentialDrive(motoresIzquierda, motoresDerecha);


  // Joystick //
  Joystick control = new Joystick(0);



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

    double adelateAtras = control.getRawAxis(2);
    double izquierdaDerecha = control.getRawAxis(5);
    chassis.arcadeDrive(adelateAtras, izquierdaDerecha);


  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

}
