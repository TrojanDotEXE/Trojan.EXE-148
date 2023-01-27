package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSlider {
    private Servo slider1, slider2;
    private double MAX_POS = 0.9, MIN_POS = 0.7;

    public void init(HardwareMap hardwareMap){
        slider1 = hardwareMap.get(Servo.class, "intake1");
        slider2 = hardwareMap.get(Servo.class, "intake2");
        slider1.setPosition(MIN_POS);
        slider2.setPosition(MIN_POS);
    }

    public void keyBind(Gamepad gamepad){
        if(gamepad.a){
            slider1.setPosition(MAX_POS);
            slider2.setPosition(MAX_POS);
        }
        if(gamepad.b){
            slider1.setPosition(MIN_POS);
            slider2.setPosition(MIN_POS);
        }
    }
}
