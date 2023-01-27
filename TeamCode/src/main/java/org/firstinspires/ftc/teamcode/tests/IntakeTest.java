package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.R;

@Config
@TeleOp(group = "Tests", name = "Test Intake[extend]")
public class IntakeTest extends LinearOpMode {
    Servo intake1, intake2;
    static double MIN_POS = 0, MAX_POS = 1, pos1, pos2;

    @Override
    public void runOpMode() throws InterruptedException {
//        intake1 = hardwareMap.get(Servo.class, "intake1");
//        intake2 = hardwareMap.get(Servo.class, "intake2");
//
//        pos1 = .5;
//        pos2 = .5;
//
//        telemetry.addData("Status ", "Gata");
//        telemetry.update();
//
//        waitForStart();
//
//        while (opModeIsActive()){
//            telemetry.addData("Status", " Ruleaza");
//
//            if(gamepad2.a && pos1 > MIN_POS && pos2 > MIN_POS) {
//                pos1 -= 0.1;
//                pos2 -= 0.1;
//            }
//            if(gamepad2.b && pos1 < MAX_POS && pos2 < MAX_POS) {
//                pos1 += 0.1;
//                pos2 += 0.1;
//            }
//
//            if(gamepad2.a && pos1 > MIN_POS && pos2 > MIN_POS) {
//                pos1 -= 0.1;
//                pos2 -= 0.1;
//            }
//            if(gamepad2.b && pos1 < MAX_POS && pos2 < MAX_POS) {
//                pos1 += 0.1;
//                pos2 += 0.1;
//            }
//
//            intake1.setPosition(Range.clip(pos1, MIN_POS, MAX_POS));
//            intake2.setPosition(Range.clip(pos2, MIN_POS, MAX_POS));
//
//            telemetry.addData("Intake1 ", "pozitia data = %.2f pozitia actuala = %.2f", pos1,  intake1.getPosition());
//            telemetry.addData("Intake2 ", "pozitia data = %.2f pozitia actuala = %.2f", pos2,  intake2.getPosition());
//
//            telemetry.update();
//            idle();
        }

    }

