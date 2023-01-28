package org.firstinspires.ftc.teamcode.robot.mecanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class IntakeArm {
    private DcMotorEx arm;
    private static int DOWN_POS = 1, UP_POS = 0;

    public void init(@NonNull HardwareMap hardwareMap){
        arm = hardwareMap.get(DcMotorEx.class, "arm");
        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setPower(0);

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(UP_POS);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (arm.isBusy()) arm.setPower(.3);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad gamepadcopy){
        if(gamepad.a && !gamepadcopy.a){
            arm.setTargetPosition(UP_POS);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            while (arm.isBusy()) arm.setPower(.3);
        }
        if(gamepad.b && !gamepadcopy.b){
            arm.setTargetPosition(DOWN_POS);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            while (arm.isBusy()) arm.setPower(.3);
        }
    }

    public double getPosition(){
        return (double) arm.getCurrentPosition();
    }
}
