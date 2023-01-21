package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.camera.Camera;
import org.firstinspires.ftc.teamcode.robot.drivetrains.MecanumDrivetrain;

public class RobotAuto {
    private LinearOpMode opMode;
    public Intake intake;
    public Scoring scoring;
    public MecanumDrivetrain drivetrain;
    public Camera camera;
    public BNO055IMU imu;
    private ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);

    public RobotAuto(@NonNull LinearOpMode opMode){
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
        camera     = new Camera(opMode);
        drivetrain = new MecanumDrivetrain(opMode, imu);

        camera.init();

        opMode.telemetry.addData("[Status]: ", "initializat");
    }

    public void startTimer(){timer.reset();}

    public double getRuntime(){return timer.time();}
}
