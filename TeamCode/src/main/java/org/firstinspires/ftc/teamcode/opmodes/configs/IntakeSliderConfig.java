package org.firstinspires.ftc.teamcode.opmodes.configs;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
//@Disabled
@TeleOp(group = "Configs", name = "Intake Slider Config")
public class IntakeSliderConfig extends LinearOpMode {
//    IntakeSlider intakeSlider = new IntakeSlider();
    private Servo slider1, slider2;
    public static double EXTENDED_S = .42, RETRACTED_S = .11;
    public static double EXTENDED_D = .83, RETRACTED_D = .55;
    @Override
    public void runOpMode() throws InterruptedException {
//        intakeSlider.init(hardwareMap);
        slider1 = hardwareMap.get(Servo.class, "intakeS");
        slider2 = hardwareMap.get(Servo.class, "intakeD");
        slider1.setDirection(Servo.Direction.REVERSE);
        slider2.setDirection(Servo.Direction.FORWARD);
        slider1.setPosition(RETRACTED_S);
        slider2.setPosition(RETRACTED_D);

        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addLine("Ready!");
        telemetry.update();
        telemetry.clearAll();
        waitForStart();
        while (opModeIsActive()){
//            intakeSlider.keyBind(gamepad2);
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);

            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);

            if (currentGamepad2.a && !previousGamepad2.a && slider1.getPosition() < EXTENDED_S) {
                slider1.setPosition(slider1.getPosition() + 0.01);
            }

            if (currentGamepad2.b && !previousGamepad2.b && slider1.getPosition() > RETRACTED_S) {
                slider1.setPosition(slider1.getPosition() - 0.01);
            }

            if (currentGamepad2.x && !previousGamepad2.x && slider2.getPosition() < EXTENDED_D) {
                slider2.setPosition(slider2.getPosition() + 0.01);
            }

            if (currentGamepad2.y && !previousGamepad2.y && slider2.getPosition() > RETRACTED_D) {
                slider2.setPosition(slider2.getPosition() - 0.01);
            }

            telemetry.addData("Servo Pos S", "cur / new  %.2f / %.2f", slider1.getPosition(), EXTENDED_S);
            telemetry.addData("Servo Pos D", "cur / new  %.2f / %.2f", slider2.getPosition(), EXTENDED_D);
            telemetry.update();
        }
    }
}
