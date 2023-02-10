package org.firstinspires.ftc.teamcode.opmodes.configs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.mechanisms.ScoringArm;

//@Disabled
@TeleOp(group = "Configs", name = "Scoring Arm Config")

public class ScoringArmConfig extends LinearOpMode {
    ScoringArm arm;

    @Override
    public void runOpMode() throws InterruptedException {
        arm.init(hardwareMap);
        Gamepad currentGamepad2 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        waitForStart();
        while (opModeIsActive()){
            previousGamepad2.copy(currentGamepad2);
            currentGamepad2.copy(gamepad2);

//            arm.keyBind(currentGamepad2, previousGamepad2);
        }
    }
}
