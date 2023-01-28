package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeSlider {
    private Servo slider1, slider2;
    private static double EXTENDED = 0.9, RETRACTED = 0.7;

    public void init(HardwareMap hardwareMap){
        slider1 = hardwareMap.get(Servo.class, "intake1");
        slider2 = hardwareMap.get(Servo.class, "intake2");
        slider1.setPosition(RETRACTED);
        slider2.setPosition(RETRACTED);
    }

    public void keyBind(Gamepad gamepad){
        if(gamepad.a){
            slider1.setPosition(EXTENDED);
            slider2.setPosition(EXTENDED);
        }
        if(gamepad.b){
            slider1.setPosition(RETRACTED);
            slider2.setPosition(RETRACTED);
        }
    }
}
