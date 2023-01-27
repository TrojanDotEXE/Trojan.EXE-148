package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/*
TODO: Instaleaza Papier ca sa notezi valorile
*/

@Config
@TeleOp(group = "Config", name = "Servo Config")
public class ServoConfig extends LinearOpMode {
    public Servo servo;
    public static double MAX_POS = .9, MIN_POS = 0.7;
    public static double curPos;

    @Override
    public void runOpMode() throws InterruptedException {
        boolean servoToggle = false;
        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        servo = hardwareMap.get(Servo.class, "servo");
        servo.setPosition(MIN_POS);

        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addLine("Ready!");
        telemetry.update();
        telemetry.clearAll();

        waitForStart();
        while (opModeIsActive()){
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);

            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);

            if (currentGamepad2.a && !previousGamepad2.a && servo.getPosition() < MAX_POS) {
                servo.setPosition(servo.getPosition() + 0.1);
            }

            if (currentGamepad2.b && !previousGamepad2.b && servo.getPosition() > MIN_POS) {
                servo.setPosition(servo.getPosition() - 0.1);
            }

            if (currentGamepad2.x && !previousGamepad2.x) {
                servo.setPosition(curPos);
            }

            if (currentGamepad2.y && !previousGamepad2.y) {
                curPos = servo.getPosition();
            }

//            if (currentGamepad1.a && !previousGamepad1.a) {
//                servoToggle = !servoToggle;
//            }
//            if (servoToggle) {
//                servo.setPosition(MAX_POS);
//            }
//            else {
//                servo.setPosition(MIN_POS);
//            }
            telemetry.addData("Servo Pos ", "cur / new  %.2f / %.2f", servo.getPosition(), curPos);
            telemetry.update();
        }
    }
}
