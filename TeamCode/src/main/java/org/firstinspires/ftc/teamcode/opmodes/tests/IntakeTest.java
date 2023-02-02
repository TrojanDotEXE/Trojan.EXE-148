package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Intake;

@TeleOp(group = "Tests", name = "Test Intake[extend]")
public class IntakeTest extends LinearOpMode {
    Intake intake = new Intake(this);

    @Override
    public void runOpMode() throws InterruptedException {
        intake.init();

        telemetry.addData("Status ", "Gata");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
//            intake.keyBind(gamepad2);
        }

        telemetry.addData("Intake1 ", "pozitia bratului %.2f", intake.arm.getPosition());
        }

    }

