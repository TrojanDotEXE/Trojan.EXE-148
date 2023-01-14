package org.firstinspires.ftc.teamcode.robot.drivetrains;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class AutoMecanum extends MecanumDrivetrain{

    private final double WHEEL_DIAMETER = 9.6;
    private final double TICKS_PER_REVOLUTION = 537.7;
    private final double TICKS_PER_CM = TICKS_PER_REVOLUTION / WHEEL_DIAMETER;

    public AutoMecanum(OpMode opMode, BNO055IMU imu) {
        super(opMode, imu);
        for (DcMotorEx motor : motors) {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }

    public void drive (int distance) {

    int targetPosition = (int)TICKS_PER_CM * distance;
     for(DcMotorEx motor : motors){
         motor.setTargetPosition(targetPosition);
         motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
     }
     while (leftFront.isBusy() && leftRear.isBusy() && rightFront.isBusy() && rightRear.isBusy()){
         for(DcMotorEx motor : motors){
             motor.setPower(.5);
         }
         opMode.telemetry.addData("Target Pos", targetPosition);
         opMode.telemetry.addData("leftFront Pos", leftFront.getCurrentPosition());
         opMode.telemetry.addData("rightFront Pos", rightFront.getCurrentPosition());
         opMode.telemetry.addData("leftRear Pos", leftRear.getCurrentPosition());
         opMode.telemetry.addData("rightRear Pos", rightRear.getCurrentPosition());

     }

    }



}
