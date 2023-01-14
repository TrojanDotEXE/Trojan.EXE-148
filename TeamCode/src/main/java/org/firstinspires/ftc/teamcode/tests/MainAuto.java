package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.robot.AutoRobot;
import org.firstinspires.ftc.teamcode.robot.Camera;
import org.firstinspires.ftc.teamcode.robot.Robot;

@Autonomous(group = "Tests", name = "Test Camera [Detect & Move]")
public class MainAuto extends LinearOpMode {
//    AutoRobot robot = new AutoRobot(this);
    Camera camera = new Camera(this);
    DcMotorEx leftFront, leftRear, rightFront, rightRear;
    final double WHEEL_DIAMETER = 9.6;
    final double TICKS_PER_REVOLUTION = 538;
    final double TICKS_PER_CM = (TICKS_PER_REVOLUTION / WHEEL_DIAMETER);

    @Override
    public void runOpMode() throws InterruptedException {
//        robot.init();
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");

        leftFront .setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear  .setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear .setDirection(DcMotorSimple.Direction.FORWARD);

        leftFront .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear  .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        camera.init();
        camera.runCameraScan();

        int tagID = camera.getTagID();
//        switch (tagID) {
//            case 1: {
////                leftFront .setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100)); // 538 fot 9.6 cm
////                rightFront.setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100));
////                leftRear  .setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100));
////                rightRear .setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100));
////            }
//            break;
//            case 2: {
//                leftFront .setTargetPosition(-40*TICKS_PER_CM);
//                rightFront.setTargetPosition(-40*TICKS_PER_CM);
//                leftRear  .setTargetPosition(-40*TICKS_PER_CM);
//                rightRear .setTargetPosition(-40*TICKS_PER_CM);
//            }
//            break;
//            case 3: {
//                leftFront.setTargetPosition(20*TICKS_PER_CM);
//                rightFront.setTargetPosition(20*TICKS_PER_CM);
//                leftRear.setTargetPosition(20*TICKS_PER_CM);
//                rightRear.setTargetPosition(20*TICKS_PER_CM);
//            }
//            break;
//        }
            leftFront .setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftRear  .setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightRear .setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

            leftFront .setPower(.3);
            rightFront.setPower(.3);
            leftRear  .setPower(.3);
            rightRear .setPower(.3);

            while (opModeIsActive() && leftFront.isBusy()){
                telemetry.addData("leftFront ", leftFront.getCurrentPosition());
                telemetry.addData("leftRear ", leftRear.getCurrentPosition());
                telemetry.addData("rightFront ", rightFront.getCurrentPosition());
                telemetry.addData("rightRear ", rightRear.getCurrentPosition());
                telemetry.update();
                idle();
            }
    }
}

