package org.firstinspires.ftc.teamcode.opmodes.configs;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.Intake;
import org.firstinspires.ftc.teamcode.robot.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.robot.Scoring;

@TeleOp(group = "1", name = "Main2")
public class Main2 extends LinearOpMode {
    BNO055IMU imu;
    MecanumDrivetrain drivetrain = new MecanumDrivetrain(this);
    Intake intake                = new Intake(this);
    Scoring scoring              = new Scoring(this);
    Gamepad currentGamepad1;
    Gamepad previousGamepad1;
    Gamepad currentGamepad2;
    Gamepad previousGamepad2;

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
        drivetrain.init(imu);
        scoring.init();
        intake.init();
        currentGamepad1 = new Gamepad();
        previousGamepad1 = new Gamepad();
        currentGamepad2 = new Gamepad();
        previousGamepad2 = new Gamepad();

        waitForStart();

        while (opModeIsActive() && !isStopRequested()){
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);
            previousGamepad2.copy(currentGamepad2);
            currentGamepad2.copy(gamepad2);

            drivetrain.drive(currentGamepad1, previousGamepad1);
            intake.keyBind(currentGamepad2, previousGamepad2);
            scoring.keyBind(currentGamepad2, previousGamepad2);
        }
    }
}

