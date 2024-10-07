package org.firstinspires.ftc.teamcode.intothedeep;

public class Megalodog extends MegalodogChassis {
    public int ArmGround;
    public int SampleLow;
    public int SampleHigh;

    public int LinearSlideFar;
    public int LinearSlideHome;

    public int SpecimenHigh;
    public int SpecimenLow;

    public int SpecimenGripperClosed;
    public int SpecimenGripperOpen;
//------------------------------------------------------------------------
    public void MoveSlideAndScoop (int distanceMM,int wait){};

    public void RaiseLift (int hightMM, int wait){};

    public void EmptyLift (int wait){};

    public void LetGoOfSpecimen(int wait){};

    public void CheckSampleColor (){};
}
