package org.firstinspires.ftc.teamcode.opmodes.configs;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.mechanisms.IntakeClaw;

//@Disabled
@TeleOp(group = "Configs", name = "Intake Claw Config")
public class IntakeClawConfig extends LinearOpMode {
    IntakeClaw intakeClaw = new IntakeClaw();
    Gamepad currentGamepad2;
    Gamepad previousGamepad2;

    @Override
    public void runOpMode() throws InterruptedException {
        intakeClaw.init(hardwareMap);
        currentGamepad2 = new Gamepad();
        previousGamepad2 = new Gamepad();

        waitForStart();
        while (opModeIsActive()){
            previousGamepad2.copy(currentGamepad2);
            currentGamepad2.copy(gamepad2);
            intakeClaw.keyBind(currentGamepad2, previousGamepad2);
        }
    }
}
