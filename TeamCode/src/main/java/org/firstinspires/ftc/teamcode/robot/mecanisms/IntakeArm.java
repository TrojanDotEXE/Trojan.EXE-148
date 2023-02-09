package org.firstinspires.ftc.teamcode.robot.mecanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Config
public class IntakeArm {
    private DcMotorEx intakeArm;
    public static int DOWN_POS = 50, UP_POS = 0;
    public static double power = 0.3;
    public ElapsedTime timer = new ElapsedTime();
    private boolean armToggle = false;

    public void init(@NonNull HardwareMap hardwareMap){
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        intakeArm.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeArm.setPower(0);
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad prevGamepad){
//        if(gamepad.a && !prevGamepad.a) armToggle = !armToggle;
        if(gamepad.a && !prevGamepad.a){
            timer.reset();
            while ((int)timer.seconds() > 1)
                intakeArm.setPower(power);
//            intakeArm.setTargetPosition(UP_POS);
//            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            while (intakeArm.isBusy()) intakeArm.setPower(power);
        }
        else if(gamepad.b && !prevGamepad.b){
            timer.reset();
            while ((int)timer.seconds() > 1)
                intakeArm.setPower(power);
//            intakeArm.setTargetPosition(DOWN_POS);
//            intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            while (intakeArm.isBusy()) intakeArm.setPower(power);
        }
    }

    public double getPosition(){
        return (double) intakeArm.getCurrentPosition();
    }
}
