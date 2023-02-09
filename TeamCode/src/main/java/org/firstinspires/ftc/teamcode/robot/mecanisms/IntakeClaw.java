package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeClaw {
    private Servo rightClaw, leftClaw;
    public static double OPEN_D = .12, CLOSE_D = 0;
    public static double OPEN_S = .45, CLOSE_S = .66;
    private boolean clawToggle = false;

    public void init(HardwareMap hardwareMap){
        rightClaw = hardwareMap.get(Servo.class, "clawR");
        leftClaw = hardwareMap.get(Servo.class, "clawL");
        rightClaw.setDirection(Servo.Direction.FORWARD);
        leftClaw.setDirection(Servo.Direction.FORWARD);
        rightClaw.setPosition(CLOSE_D);
        leftClaw.setPosition(CLOSE_S);
    }

    public void keyBind(Gamepad gamepad, Gamepad prevGamepad){
        if(gamepad.left_bumper && !prevGamepad.left_bumper) clawToggle = !clawToggle;

        if(clawToggle){
            rightClaw.setPosition(OPEN_D);
            leftClaw.setPosition(OPEN_S);
        }
        else{
            rightClaw.setPosition(CLOSE_D);
            leftClaw.setPosition(CLOSE_S);
        }
    }
}
