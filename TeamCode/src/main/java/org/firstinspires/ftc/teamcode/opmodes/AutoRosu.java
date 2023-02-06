package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robot.RobotAuto;

@Autonomous(group = "Tests", name = "Test Camera [Detect & Move]")
public class AutoRosu extends LinearOpMode {
    RobotAuto robot = new RobotAuto(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        robot.camera.runCameraScan();
        int tagID = robot.camera.getTagID();

//        switch (tagID) {
//            case 1: {
//                leftFront .setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100)); // 538 fot 9.6 cm
//                rightFront.setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100));
//                leftRear  .setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100));
//                rightRear .setTargetPosition(Math.round((9.6 * TICKS_PER_REVOLUTION)*100));
//            }
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
        waitForStart();
    }
}

