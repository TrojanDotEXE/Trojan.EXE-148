package org.firstinspires.ftc.teamcode.robot;

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
    private DcMotorEx leftFront, leftRear, rightFront, rightRear;
    private double frontL, frontR, rearL, rearR;
    private List<DcMotorEx>  motors;
    private DriveMode driveMode;
    private BNO055IMU imu;
    private OpMode opMode;
    private boolean slowToggle = false;
    enum DriveMode {
        NORMAL,
        FIELD_CENTERED,
    }

    public MecanumDrivetrain(OpMode opMode) {this(opMode, DriveMode.FIELD_CENTERED);}

    public MecanumDrivetrain(@NonNull OpMode opMode, DriveMode driveMode) {
        this.driveMode = driveMode;
        this.opMode = opMode;

    }

    public void init(BNO055IMU imu) {
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
        this.imu = imu;
    }

    public void setDriveMode(DriveMode driveMode){
        this.driveMode = driveMode;
    }

    public DriveMode getDriveMode(){
        return this.driveMode;
    }

    public void drive(Gamepad gamepad, Gamepad prevGamepad) {
        switch (driveMode) {
            case NORMAL: {
                if (gamepad.a) setDriveMode(DriveMode.FIELD_CENTERED);
                calculatePowers(gamepad, prevGamepad);
            }break;
            case FIELD_CENTERED: {
                if (gamepad.a) setDriveMode(DriveMode.NORMAL);
                calculatePowers2(gamepad, prevGamepad);
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

    protected void calculatePowers(@NonNull Gamepad gamepad, Gamepad prevGamepad) {
        double x = gamepad.left_stick_x;
        double y = -gamepad.left_stick_y;
        double turn = gamepad.right_stick_x;
        double magnitude = Range.clip(Math.hypot(x, y), 0, 1);
        double gamepadAngle = Math.atan2(y, x);
        double pow1 = Range.clip(Math.sin(gamepadAngle - Math.PI/4) * magnitude, -1, 1);
        double pow2 = Range.clip(Math.sin(gamepadAngle + Math.PI/4) * magnitude, -1, 1);
        if(gamepad.left_stick_button && !prevGamepad.left_stick_button) slowToggle = !slowToggle;
        double scale = slowToggle  ? .5 : 1;

        frontR = (pow1 - turn ) * scale;
        rearL = (pow1 + turn ) * scale;
        frontL = (pow2 + turn ) * scale;
        rearR = (pow2 - turn ) * scale;
    }

    private void calculatePowers2(@NonNull Gamepad gamepad, Gamepad prevGamepad) {
        double x = gamepad.left_stick_x;
        double y = gamepad.left_stick_y;
        double turn = gamepad.right_stick_x;
        double magnitude = Range.clip(Math.hypot(x, y), 0, 1);
        double gamepadAngle = Math.atan2(y, x);
        double robotAngle = getAngle();
        double movementAngle = gamepadAngle + robotAngle;
        double pow1 = Range.clip(Math.sin(movementAngle - Math.PI/4) * magnitude, -1, 1);
        double pow2 = Range.clip(Math.sin(movementAngle + Math.PI/4) * magnitude, -1, 1);
        if(gamepad.left_stick_button && !prevGamepad.left_stick_button) slowToggle = !slowToggle;
        double scale = slowToggle  ? .5 : 1;

        frontR = (pow1 - turn)* scale;
        rearL = (pow1 + turn)* scale;
        frontL = (pow2 + turn)* scale;
        rearR = (pow2 - turn)* scale;
    }

    public double getAngle() {
        return imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS).firstAngle;
    }
}
