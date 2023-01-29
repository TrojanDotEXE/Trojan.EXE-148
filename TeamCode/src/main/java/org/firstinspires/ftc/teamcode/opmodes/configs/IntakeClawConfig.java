package org.firstinspires.ftc.teamcode.opmodes.configs;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeClaw;

//@Disabled
@TeleOp(group = "Configs", name = "Intake Claw Config")
public class IntakeClawConfig extends LinearOpMode {
    IntakeClaw intakeClaw;

    @Override
    public void runOpMode() throws InterruptedException {
        intakeClaw.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()){
            intakeClaw.keyBind(gamepad2);
        }
    }
}
