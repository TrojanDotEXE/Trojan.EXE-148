package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class IntakeSlider {
    private Servo slider1, slider2;
    public static double EXTENDED_S = .35, SCORING_S = .12, RETRACTED_S = .02;
    public static double EXTENDED_D = .72, SCORING_D = .5, RETRACTED_D = .39;
    private boolean sliderToggle = false;
    private ElapsedTime wait = new ElapsedTime();

    public void init(HardwareMap hardwareMap){
        slider1 = hardwareMap.get(Servo.class, "intakeS");
        slider2 = hardwareMap.get(Servo.class, "intakeD");
        slider1.setDirection(Servo.Direction.REVERSE);
        slider2.setDirection(Servo.Direction.FORWARD);
        slider1.setPosition(RETRACTED_S);
        slider2.setPosition(RETRACTED_D);
    }
    public void keyBind(Gamepad gamepad, Gamepad prevGamepad, boolean clawO, boolean clawC){
        if(gamepad.left_bumper && !prevGamepad.left_bumper) sliderToggle = !sliderToggle;
        if(sliderToggle){
            slider1.setPosition(EXTENDED_S);
            slider2.setPosition(EXTENDED_D);
        }
        else {
            slider1.setPosition(SCORING_S);
            slider2.setPosition(SCORING_D);
        }
        if (gamepad.dpad_right && !prevGamepad.dpad_right) {
            slider1.setPosition(slider1.getPosition() + 0.01);
            slider2.setPosition(slider2.getPosition() + 0.01);
        }
        if (gamepad.dpad_left && !prevGamepad.dpad_left) {
            slider1.setPosition(slider1.getPosition() - 0.01);
            slider2.setPosition(slider2.getPosition() - 0.01);
        }
    }
}
