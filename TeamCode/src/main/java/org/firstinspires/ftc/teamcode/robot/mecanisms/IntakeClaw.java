package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeClaw {
    private Servo claw1, claw2;
    public static double OPEN = .5, CLOSE = 0;

    public void init(HardwareMap hardwareMap){
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");
        claw1.setDirection(Servo.Direction.FORWARD);
        claw2.setDirection(Servo.Direction.REVERSE);
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
