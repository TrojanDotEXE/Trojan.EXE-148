package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.robot.camera.Camera;
import org.firstinspires.ftc.teamcode.robot.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.robot.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.robot.mechanisms.Scoring;

public class RobotAuto {
    private OpMode opMode;
    public SampleMecanumDrive drivetrain;
    public Intake intake;
    public Scoring scoring;
    public BNO055IMU imu;
    public Camera camera;
    private ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);

    public RobotAuto(@NonNull OpMode opMode){
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

        intake     = new Intake(opMode);
        scoring    = new Scoring(opMode);
        camera.init();
        opMode.telemetry.addData("[Status]: ", "initializat");
    }

    public void startTimer(){timer.reset();}

    public double getRuntime(){return timer.time();}
}
