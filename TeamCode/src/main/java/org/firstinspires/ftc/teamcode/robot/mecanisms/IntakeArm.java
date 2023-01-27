package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
public class IntakeArm {
    private Servo arm1, arm2;
    private double DOWN_POS = 0.9, UP_POS = 0.7;

    public void init(HardwareMap hardwareMap){
        arm1 = hardwareMap.get(Servo.class, "arm1");
        arm2 = hardwareMap.get(Servo.class, "arm2");
        arm1.setPosition(UP_POS);
        arm2.setPosition(UP_POS);
    }

    public void keyBind(Gamepad gamepad){
        if(gamepad.a){
            arm1.setPosition(DOWN_POS);
            arm2.setPosition(DOWN_POS);
        }
        else{
            arm1.setPosition(UP_POS);
            arm2.setPosition(UP_POS);
        }
    }
}
