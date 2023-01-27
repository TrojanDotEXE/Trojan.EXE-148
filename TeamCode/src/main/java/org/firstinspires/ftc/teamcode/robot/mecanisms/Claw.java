package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
public class Claw {
    private Servo claw1, claw2;
    private double OPEN = 0.9, CLOSE = 0.7;

    public void init(HardwareMap hardwareMap){
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");
        claw1.setPosition(CLOSE);
        claw2.setPosition(CLOSE);
    }

    public void keyBind(Gamepad gamepad){
        if(gamepad.left_bumper){
            claw1.setPosition(OPEN);
            claw2.setPosition(OPEN);
        }
        else{
            claw1.setPosition(CLOSE);
            claw2.setPosition(CLOSE);
        }
    }

}
