package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.camera.Camera;
import org.firstinspires.ftc.teamcode.robot.drivetrains.MecanumDrivetrain;

public class Robot {
    private OpMode opMode;
    public MecanumDrivetrain drivetrain;
    public Intake intake;
    public Scoring scoring;
    public BNO055IMU imu;
    private ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);

    public Robot(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
        opMode.telemetry.addData("[Status]: ", "se pregateste...");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        drivetrain = new MecanumDrivetrain(opMode, imu);
        intake     = new Intake(opMode);
        intake.init();
        scoring    = new Scoring(opMode);

        opMode.telemetry.addData("[Status]: ", "initializat");
    }

    public void startTimer(){timer.reset();}

    public double getRuntime(){return timer.time();}
}
