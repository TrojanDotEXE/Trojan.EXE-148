package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeClaw {
    private Servo claw1, claw2;
    public static double OPEND = .12, CLOSED = 0;
    public static double OPENS = .45, CLOSES = .66;

    public void init(HardwareMap hardwareMap){
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");
        claw1.setDirection(Servo.Direction.FORWARD);
        claw2.setDirection(Servo.Direction.FORWARD);
        claw1.setPosition(CLOSED);
        claw2.setPosition(CLOSES);
    }

    public void keyBind(Gamepad gamepad){
        if(gamepad.left_bumper){
            claw1.setPosition(OPEND);
            claw2.setPosition(OPENS);
        }
        else{
            claw1.setPosition(CLOSED);
            claw2.setPosition(CLOSES);
        }
    }
}
