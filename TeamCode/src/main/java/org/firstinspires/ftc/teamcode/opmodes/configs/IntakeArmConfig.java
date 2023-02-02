package org.firstinspires.ftc.teamcode.opmodes.configs;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeArm;

//@Disabled
@TeleOp(group = "Configs", name = "Intake Arm Config")
public class IntakeArmConfig extends LinearOpMode {
    IntakeArm intakeArm = new IntakeArm();

    @Override
    public void runOpMode() throws InterruptedException {
        intakeArm.init(hardwareMap);
        Gamepad currentGamepad2 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        waitForStart();

        while (opModeIsActive() && !isStopRequested()){
            previousGamepad2.copy(currentGamepad2);
            currentGamepad2.copy(gamepad2);

            intakeArm.keyBind(currentGamepad2, previousGamepad2);
        }
    }
}
