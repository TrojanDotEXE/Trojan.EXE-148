package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
@TeleOp(group = "Configs", name = "MaPiscaOchii")
public class IntakeSlider {
    private Servo slider1, slider2;
    public static double EXTENDED_S = .42, RETRACTED_S = .11;
    public static double EXTENDED_D = .83, RETRACTED_D = .55;
    private boolean sliderToggle = false;

    public void init(HardwareMap hardwareMap){
        slider1 = hardwareMap.get(Servo.class, "intakeS");
        slider2 = hardwareMap.get(Servo.class, "intakeD");
        slider1.setDirection(Servo.Direction.REVERSE);
        slider2.setDirection(Servo.Direction.FORWARD);
        slider1.setPosition(RETRACTED_S);
        slider2.setPosition(RETRACTED_D);
    }
    public void keyBind(Gamepad gamepad, Gamepad prevGamepad){
        if(gamepad.left_bumper && !prevGamepad.left_bumper) sliderToggle = !sliderToggle;
        if(sliderToggle){
            slider1.setPosition(EXTENDED_S);
            slider2.setPosition(EXTENDED_D);
        }
        else {
            slider1.setPosition(RETRACTED_S);
            slider2.setPosition(RETRACTED_D);
        }
    }
}
