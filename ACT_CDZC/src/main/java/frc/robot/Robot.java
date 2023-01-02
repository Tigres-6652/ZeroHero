//CRISTOPHER DANIEL ZAPATA CANTÚ (EDUCACIÓN STEAM - Modelos Formativos)
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  double TiempoMatch;

   //CONTROL
  Joystick xbox = new Joystick(0);

  // MOTORES DERECHOS
  WPI_TalonSRX MR1 = new WPI_TalonSRX(1);
  WPI_TalonSRX MR2 = new WPI_TalonSRX(2);
  
  // MOTORES IZQUIERDOS
  WPI_TalonSRX ML1 = new WPI_TalonSRX(3);
  WPI_TalonSRX ML2 = new WPI_TalonSRX(4);

  //INTAKE (Motor / Valvula)
  WPI_TalonSRX MInt = new WPI_TalonSRX(5);
  Solenoid Valv = new Solenoid(PneumaticsModuleType.CTREPCM,6);
  
  //SHOOTER
  WPI_TalonSRX Msht1 = new WPI_TalonSRX(7);
  WPI_TalonSRX Msht2 = new WPI_TalonSRX(8);

  
  // AGRUPACIÓN POR LADO
  MotorControllerGroup motoresR = new MotorControllerGroup(MR1, MR2);
  MotorControllerGroup motoresL = new MotorControllerGroup(ML1, ML2);

  // CHASSIS
  DifferentialDrive Robotcito = new DifferentialDrive(motoresR,motoresL);
 
 //
  double tiempomatch;

 
  //FUNCIONES 
  public void Intake(boolean state, double speed){
    Valv.set(state);
    MInt.set(speed);
  }

  public void Shoot(double speed){
    Msht1.set(speed);
    Msht2.set(-speed);


  }

  @Override
  public void robotInit() {

motoresL.setInverted(true);
motoresR.setInverted(false);
  }

  @Override
  public void robotPeriodic() {

     tiempomatch=Timer.getMatchTime();
     SmartDashboard.putNumber("matchtime", tiempomatch);

  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {

    if(tiempomatch<15&&tiempomatch>10){

Shoot(0.5);
Robotcito.arcadeDrive(0.4, 0);
Intake(true, 0.5);
}else{
      Intake(false, 0);
      Shoot(0);
      Robotcito.arcadeDrive(0.4, 0);


    }




  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    //ROBOT CONTROLADO (Palanca izquierda)
    Robotcito.arcadeDrive(xbox.getRawAxis(1),xbox.getRawAxis(0));

    //CONTROL DE INTAKE
    if(xbox.getRawButton(3)){
      Intake(true,1); //SALE (Boton X)
    }else if(xbox.getRawButton(2)){
      Intake(false,-1); //ENTRA (Boton B)
    }else{
      Intake(false,0); //QUIETO 
    }

    //CONTROL DE SHOOTER 
    if(xbox.getRawButton(4)){
      Shoot(1.0); //DISPARA (Boton Y)
    }else if(xbox.getRawButton(2)){
      Shoot(0.0); //QUIETO
    }

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

