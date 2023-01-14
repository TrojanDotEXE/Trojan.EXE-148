package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

@TeleOp(group = "Tests", name = "Test Driving [FieldCenteredMode]")
public class FieldCenteredMode extends LinearOpMode {
    private DcMotorEx leftFront, leftRear, rightFront, rightRear;
    public BNO055IMU imu;
    Orientation angles;
    Acceleration gravity;

    @Override
    public void runOpMode() throws InterruptedException {
        double x, y, turn, gamepadAngle, magnitude, robotAngle, movementAngle, pow1, pow2;

        leftFront  = hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        leftRear   = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear  = hardwareMap.get(DcMotorEx.class, "rightRear");
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        composeTelemetry();

        waitForStart();
        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        //TODO copiaza pe main si testeaza
        while (opModeIsActive()) {
            x = gamepad1.left_stick_x;
            y = -gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            magnitude = Range.clip(Math.hypot(x, y), 0, 1);
            gamepadAngle = Math.atan2(y, x);
            robotAngle = Math.toRadians(getAngle());
            movementAngle = gamepadAngle - robotAngle;
            pow1 = Math.sin(movementAngle - Math.PI/4) * magnitude;
            pow2 = Math.sin(movementAngle + Math.PI/4) * magnitude;
            double max = Math.max(Math.abs(pow2), Math.abs(pow1));

            rightFront.setPower((pow1 - turn)/max);
            leftRear.setPower((pow1 + turn)/max);
            rightRear.setPower((pow2 - turn)/max);
            leftFront.setPower((pow2 + turn)/max);

            telemetry.update();
        }
        telemetry.update();
    }

    void composeTelemetry() {
        telemetry.addAction(new Runnable() {
            @Override
            public void run() {
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity = imu.getGravity();
            }
        });
    }

    public double getAngle() {
        return imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
    }
}
