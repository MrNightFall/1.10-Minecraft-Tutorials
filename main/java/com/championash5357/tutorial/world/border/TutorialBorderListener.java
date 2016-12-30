package com.championash5357.tutorial.world.border;

public interface TutorialBorderListener
{
    void onSizeChanged(TutorialWorldBorder border, double newSize);

    void onTransitionStarted(TutorialWorldBorder border, double oldSize, double newSize, long time);

    void onCenterChanged(TutorialWorldBorder border, double x, double z);

    void onWarningTimeChanged(TutorialWorldBorder border, int newTime);

    void onWarningDistanceChanged(TutorialWorldBorder border, int newDistance);

    void onDamageAmountChanged(TutorialWorldBorder border, double newAmount);

    void onDamageBufferChanged(TutorialWorldBorder border, double newSize);
}