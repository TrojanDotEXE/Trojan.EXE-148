package org.firstinspires.ftc.teamcode.robot.drivetrains;

import androidx.annotation.NonNull;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.robot.Scoring;
import org.opencv.core.Mat;

import java.util.Arrays;
import java.util.List;


public class MecanumDrivetrain {
    protected DcMotorEx leftFront, leftRear, rightFront, rightRear;
    protected double frontL, frontR, rearL, rearR;
    protected List<DcMotorEx>  motors;

    protected DriveMode driveMode;
    protected BNO055IMU imu;
    protected OpMode opMode;
    enum DriveMode {
        NORMAL,
        FIELD_CENTERED,
        ASSISTED,
        AIM_ASSISTED
    }

    public MecanumDrivetrain(OpMode opMode, BNO055IMU imu) {this(opMode, imu, DriveMode.FIELD_CENTERED);}

    public MecanumDrivetrain(@NonNull OpMode opMode, BNO055IMU imu, DriveMode driveMode) {
        opMode.telemetry.addData("Mecanum Drive: ", "se pregateste...");

        leftFront = opMode.hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = opMode.hardwareMap.get(DcMotorEx.class, "rightFront");
        leftRear = opMode.hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = opMode.hardwareMap.get(DcMotorEx.class, "rightRear");
        motors = Arrays.asList(leftFront, rightFront, leftRear, rightRear);

        for (DcMotorEx motor: motors) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setDirection(DcMotorSimple.Direction.FORWARD);
            motor.setPower(0);
        }
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        this.driveMode = driveMode;
        this.opMode = opMode;
        this.imu = imu;

        opMode.telemetry.addData("Mecanum Drive: ", "initializat");
    }

    public void setDriveMode(DriveMode driveMode){
        this.driveMode = driveMode;
    }

    public DriveMode getDriveMode(){
        return this.driveMode;
    }

    public void drive(Gamepad gamepad) {
        switch (driveMode) {
            case NORMAL: {
                if (gamepad.a) setDriveMode(DriveMode.FIELD_CENTERED);
                calculatePowers(gamepad);
                opMode.telemetry.addData("Mode ", "Normal");
            }break;
            case FIELD_CENTERED: {
                if (gamepad.b) setDriveMode(DriveMode.NORMAL);
                calculatePowers2(gamepad);
                opMode.telemetry.addData("Mode ", "Field Centered");
            }break;
        }
        leftFront.setPower(frontL);
        rightFront.setPower(frontR);
        leftRear.setPower(rearL);
        rightRear.setPower(rearR);
    }

    public void drive(double power, double angle, double turn) {
        double pow1 = Range.clip(Math.sin(Math.toRadians(angle) - Math.PI/4) * power, -1, 1);
        double pow2 = Range.clip(Math.sin(Math.toRadians(angle) + Math.PI/4) * power, -1, 1);
        rightFront.setPower(pow1 - turn);
        leftRear.setPower(pow1 + turn);
        leftFront.setPower(pow2 + turn);
        rightRear.setPower(pow2 - turn);
    }

    protected void calculatePowers(@NonNull Gamepad gamepad) {
        double x = gamepad.left_stick_x;
        double y = -gamepad.left_stick_y;
        double turn = gamepad.right_stick_x;
        double magnitude = Range.clip(Math.hypot(x, y), 0, 1);
        double gamepadAngle = Math.atan2(y, x);
        double pow1 = Range.clip(Math.sin(gamepadAngle - Math.PI/4) * magnitude, -1, 1);
        double pow2 = Range.clip(Math.sin(gamepadAngle + Math.PI/4) * magnitude, -1, 1);
        double scale = gamepad.left_stick_button  ? .5 : 1;

        frontR = (pow1 - turn ) * scale;
        rearL = (pow1 + turn ) * scale;
        frontL = (pow2 + turn ) * scale;
        rearR = (pow2 - turn ) * scale;

        opMode.telemetry.addData("Turn", turn);
        opMode.telemetry.addData("Pow1", pow1);
        opMode.telemetry.addData("Pow2", pow2);
        powersToTelemetry(opMode.telemetry);
    }

    private void calculatePowers2(@NonNull Gamepad gamepad) {
        double x = gamepad.left_stick_x;
        double y = -gamepad.left_stick_y;
        double turn = gamepad.right_stick_x;
        double magnitude = Range.clip(Math.hypot(x, y), 0, 1);
        double gamepadAngle = Math.atan2(y, x);
        double robotAngle = getAngle();
        double movementAngle = gamepadAngle - robotAngle;
        double pow1 = Range.clip(Math.sin(movementAngle - Math.PI/4) * magnitude, -1, 1);
        double pow2 = Range.clip(Math.sin(movementAngle + Math.PI/4) * magnitude, -1, 1);
        double scale = gamepad.left_stick_button  ? .5 : 1;

        frontR = (pow1 - turn)* scale;
        rearL = (pow1 + turn)* scale;
        frontL = (pow2 + turn)* scale;
        rearR = (pow2 - turn)* scale;
    }

    public void toTelemetry(){
        opMode.telemetry.addData("Left Front Pow / Pos ", "%.2f / %.2f", leftFront.getPower(), leftFront.getCurrentPosition());
        opMode.telemetry.addData("Right Front Pow / Pos ", "%.2f / %.2f", rightFront.getPower(), rightFront.getCurrentPosition());
        opMode.telemetry.addData("Left Rear Pow / Pos ", "%.2f / %.2f", leftRear.getPower(), leftRear.getCurrentPosition());
        opMode.telemetry.addData("Left Front Pow / Pos ", "%.2f / %.2f", rightRear.getPower(), rightRear.getCurrentPosition());
    }

    public double getAngle() {
        return imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS).firstAngle;
    }

    public void powersToTelemetry(@NonNull Telemetry t) {
        t.addData("LeftFront:", "%.3f / %.3f", leftFront.getPower(), frontL);
        t.addData("RightFront: ", "%.3f / %.3f", rightFront.getPower(), frontR);
        t.addData("LeftRear: ", "%.3f / %.3f", leftRear.getPower(), rearL);
        t.addData("RightRear: ", "%.3f / %.3f", rightRear.getPower(), rearR);
    }
}
