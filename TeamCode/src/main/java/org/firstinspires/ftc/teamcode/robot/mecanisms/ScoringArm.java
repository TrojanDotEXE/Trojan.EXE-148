package org.firstinspires.ftc.teamcode.robot.mecanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Config
public class ScoringArm {
    private CRServo arm;
    public static double power = 1;
    public static ElapsedTime timer;

    public void init(@NonNull HardwareMap hardwareMap){
        arm = hardwareMap.get(CRServo.class, "scoringArm");
        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        arm.setPower(0);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad gamepadcopy){
        if(gamepad.a && !gamepadcopy.a){
            timer.reset();
            while ((int)timer.time(TimeUnit.SECONDS) < 4) arm.setPower(power);
            arm.setPower(0);
        }
        if(gamepad.b && !gamepadcopy.b){
            timer.reset();
            while ((int)timer.time(TimeUnit.SECONDS) < 4) arm.setPower(-power);
            arm.setPower(0);
        }
    }

}
