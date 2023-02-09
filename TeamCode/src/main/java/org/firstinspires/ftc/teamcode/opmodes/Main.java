package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.Robot;

@TeleOp(group = "1", name = "Main")
public class Main extends LinearOpMode {
    Robot robot = new Robot(this);
    Gamepad currentGamepad1;
    Gamepad previousGamepad1;
    Gamepad currentGamepad2;
    Gamepad previousGamepad2;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
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

            robot.intake.keyBind(currentGamepad2, previousGamepad2);
        }
    }



//    @Override
//    public void loop() {
//        previousGamepad1.copy(currentGamepad1);
//        currentGamepad1.copy(gamepad1);
//        previousGamepad2.copy(currentGamepad2);
//        currentGamepad2.copy(gamepad2);
//
////        robot.drivetrain.drive(currentGamepad1, previousGamepad1);
//        robot.intake.keyBind(currentGamepad2, previousGamepad2);
////        robot.scoring.keyBind(currentGamepad2, previousGamepad2);
////        robot.scoring.getPos();
//        telemetry.update();
//    }
}
