package org.firstinspires.ftc.teamcode.opmodes.configs;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeArm;

//@Disabled
@TeleOp(group = "Configs", name = "Motor Config")
public class IntakeArmConfig extends LinearOpMode {
    IntakeArm intakeArm;

    @Override
    public void runOpMode() throws InterruptedException {
        intakeArm.init(hardwareMap);
        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        waitForStart();

        while (opModeIsActive()){
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);

            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);

            intakeArm.keyBind(currentGamepad2, previousGamepad2);
        }
    }
}
