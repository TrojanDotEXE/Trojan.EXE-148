package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(group = "1", name = "Main3")
public class Main3 extends LinearOpMode {
    Gamepad currentGamepad1;
    Gamepad previousGamepad1;
    Gamepad currentGamepad2;
    Gamepad previousGamepad2;
     Servo rightClaw, leftClaw;
     double OPEN_D = .12, CLOSE_D = 0;
     double OPEN_S = .45, CLOSE_S = .66;
     boolean clawToggle = false;
     Servo slider1, slider2;
     double EXTENDED_S = .42, RETRACTED_S = .11;
     double EXTENDED_D = .83, RETRACTED_D = .55;
     boolean sliderToggle = false;
     DcMotorEx intakeArm;
     int DOWN_POS = 50, UP_POS = 0;
     double power = 0.2;
     boolean armToggle = false;
     Servo sliderArm;
     double MAX_POS = .6, MIN_POS = 0.05;
    boolean sArmToggle = false;
     DcMotorEx sliderS, sliderD;
     int LOW_J = 0, MID_J = 300, HIGH_J = 1520;
    BNO055IMU imu;

    @Override
    public void runOpMode() throws InterruptedException {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);


        rightClaw = hardwareMap.get(Servo.class, "clawR");
        leftClaw = hardwareMap.get(Servo.class, "clawL");
        rightClaw.setDirection(Servo.Direction.FORWARD);
        leftClaw.setDirection(Servo.Direction.FORWARD);
        rightClaw.setPosition(CLOSE_D);
        leftClaw.setPosition(CLOSE_S);

        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        intakeArm.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeArm.setPower(0);
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        slider1 = hardwareMap.get(Servo.class, "intakeS");
        slider2 = hardwareMap.get(Servo.class, "intakeD");
        slider1.setDirection(Servo.Direction.REVERSE);
        slider2.setDirection(Servo.Direction.FORWARD);
        slider1.setPosition(RETRACTED_S);
        slider2.setPosition(RETRACTED_D);
        currentGamepad1 = new Gamepad();
        previousGamepad1 = new Gamepad();
        currentGamepad2 = new Gamepad();
        previousGamepad2 = new Gamepad();
        while (opModeIsActive() && !isStopRequested()){
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);
            previousGamepad2.copy(currentGamepad2);
            currentGamepad2.copy(gamepad2);

            if(currentGamepad2.left_bumper && !previousGamepad2.left_bumper) clawToggle = !clawToggle;
            if(clawToggle){
                rightClaw.setPosition(OPEN_D);
                leftClaw.setPosition(OPEN_S);
            }
            else{
                rightClaw.setPosition(CLOSE_D);
                leftClaw.setPosition(CLOSE_S);
            }

            if(currentGamepad2.a && !previousGamepad2.a) armToggle = !armToggle;
            if(armToggle){
                intakeArm.setTargetPosition(UP_POS);
                intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while (intakeArm.isBusy()) intakeArm.setPower(power);
            }
            else{
                intakeArm.setTargetPosition(DOWN_POS);
                intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while (intakeArm.isBusy()) intakeArm.setPower(power);
            }

            if(currentGamepad2.left_bumper && !currentGamepad2.left_bumper) sliderToggle = !sliderToggle;
            if(sliderToggle){
                slider1.setPosition(EXTENDED_S);
                slider2.setPosition(EXTENDED_D);
            }
            else {
                slider1.setPosition(RETRACTED_S);
                slider2.setPosition(RETRACTED_D);
            }
        }
    }
}
