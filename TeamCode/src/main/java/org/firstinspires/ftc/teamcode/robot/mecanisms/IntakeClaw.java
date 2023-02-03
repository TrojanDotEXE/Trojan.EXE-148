package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeClaw {
    private Servo rightClaw, leftClaw;
    public static double OPEND = .12, CLOSED = 0;
    public static double OPENS = .45, CLOSES = .66;
    private boolean toggle = false;

    public void init(HardwareMap hardwareMap){
        rightClaw = hardwareMap.get(Servo.class, "clawR");
        leftClaw = hardwareMap.get(Servo.class, "clawL");
        rightClaw.setDirection(Servo.Direction.FORWARD);
        leftClaw.setDirection(Servo.Direction.FORWARD);
        rightClaw.setPosition(CLOSED);
        leftClaw.setPosition(CLOSES);
    }

    public void keyBind(Gamepad gamepad, Gamepad prevGamepad){
        if(gamepad.left_bumper && !prevGamepad.left_bumper) toggle = !toggle;
        if(toggle){
            rightClaw.setPosition(OPEND);
            leftClaw.setPosition(OPENS);
        }
        else{
            rightClaw.setPosition(CLOSED);
            leftClaw.setPosition(CLOSES);
        }
    }
}
