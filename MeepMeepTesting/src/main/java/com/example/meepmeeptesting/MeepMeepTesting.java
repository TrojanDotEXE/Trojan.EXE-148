package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(717);
        int x = 5;

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setDimensions(17.008, 17.765)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 16.27)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(36, -63.117, Math.toRadians(90)))
                                .forward(51)
                                .turn(Math.toRadians(90))
                                .back(16)
                                .waitSeconds(2)
                                .splineToSplineHeading(new Pose2d(31.5,-12, Math.toRadians(120)), Math.toRadians(80))
                                .waitSeconds(2)
                                .turn(Math.toRadians(60))
                                .back(25.3)
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}