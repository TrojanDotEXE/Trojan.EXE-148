package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeSlider {
    private Servo slider1, slider2;
    public static double EXTENDED_S = 1, RETRACTED_S = 0;
    public static double EXTENDED_D = 1, RETRACTED_D = 0;

    public void init(HardwareMap hardwareMap){
        slider1 = hardwareMap.get(Servo.class, "intakeS");
        slider2 = hardwareMap.get(Servo.class, "intakeD");
        slider1.setDirection(Servo.Direction.REVERSE);
        slider2.setDirection(Servo.Direction.FORWARD);
        slider1.setPosition(RETRACTED_S);
        slider2.setPosition(RETRACTED_D);
    }

    public void keyBind(Gamepad gamepad){
        if(gamepad.a){
            slider1.setPosition(EXTENDED_S);
            slider2.setPosition(EXTENDED_D);
        }
        if(gamepad.b){
            slider1.setPosition(RETRACTED_S);
            slider2.setPosition(RETRACTED_D);
        }
    }
}
