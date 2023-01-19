package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class DiagonalaAlbastraClasic {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(717);
        int x = 1;

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setDimensions(17.008, 17.765)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 16.27)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(36, -63.117, Math.toRadians(90)))
                                .strafeLeft(36)
                                .forward(20.8)
                                .waitSeconds(3)
                                .forward(7.5)
                                .strafeRight(12*x)
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
