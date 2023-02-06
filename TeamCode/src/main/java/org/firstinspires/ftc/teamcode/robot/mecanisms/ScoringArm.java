package org.firstinspires.ftc.teamcode.robot.mecanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Config
public class ScoringArm {
    private Servo arm;
    public static double MAX_POS = .6, MIN_POS = 0;
    public boolean armToggle = true;

    public void init(@NonNull HardwareMap hardwareMap){
        arm = hardwareMap.get(Servo.class, "scoringArm");
        arm.setDirection(Servo.Direction.FORWARD);
        arm.setPosition(0);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad gamepadcopy){
        if(gamepad.a && !gamepadcopy.a) armToggle = !armToggle;
        if(armToggle){
            arm.setPosition(MIN_POS);
        }
        else{
            arm.setPosition(MAX_POS);
        }
    }

}
