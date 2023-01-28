package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeArm {
    private Servo arm1, arm2;
    private static double DOWN_POS = 1, UP_POS = 0;

    public void init(HardwareMap hardwareMap){
        arm1 = hardwareMap.get(Servo.class, "arm1");
        arm2 = hardwareMap.get(Servo.class, "arm2");
        arm2.setDirection(Servo.Direction.REVERSE);
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

    public double getPosition(){
        return (double) arm1.getPosition();
    }

    public IntakeArm(){}
}
