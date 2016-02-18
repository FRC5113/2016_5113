package drive;

public class PID
{
	
	double PIDSpeed;
	double PIDTime;
	double PIDError;
    double PIDI;
    double PIDintegral;
    double PIDKi;
    double PIDKd;
    double PIDKp;
    double PIDErrorPrev;
    
    double Scurr;
    double Tcurr;
    double Ecurr;

    double dt;
    double output;
    double PIDCurrent;
    double Derivative;
    double SpeedCurrent;

    
    public void init()
    {
		PIDTime = System.currentTimeMillis ()/1000 - 1;
		PIDError = 0;
		PIDKi = 0;
		dt = 0;
	    output = 0;
	    PIDCurrent = 0;
	    Derivative = 0;
	    SpeedCurrent = 0;
	    Scurr = 0;
	    Ecurr = 0;
	    Tcurr = 0;
	    PIDKd = 0;
	    PIDKp = 1;
	    PIDErrorPrev = 0;
	    PIDI = 0;
	    PIDintegral = 0;
	    PIDSpeed = 0;
    }
    
	public double UsePID(SensorManager sensors, double desiredSpeed)
	{
		Scurr = sensors.getEncoderRate();
		System.out.println("encoder rate: " + Scurr);
		Tcurr= System.currentTimeMillis()/1000;
		
		//if (Tcurr - PIDTime > .05)
		//{
					
		Ecurr = desiredSpeed - PIDSpeed;
		dt = Tcurr - PIDTime;
		//PIDintegral = PIDintegral + (Ecurr * (dt));
		//Derivative = ((Ecurr- PIDError) / dt);
		output = (PIDKp * Ecurr) + (PIDKi * PIDintegral) + (PIDKd * Derivative);
		System.out.println("output: " + output);
		System.out.println("dt" + dt);
		
		PIDError = Ecurr;
		PIDTime = Tcurr;
		PIDSpeed = Scurr;
			
		if (output > 0.01)
			output = 0.01;
		if (output < -0.01)
			output = -0.01;
		
		System.out.println("ayy lmao");
		System.out.println("");
		
		
		PIDI = PIDI + output;
		
		if(PIDI > .99)
			PIDI = .99;
		
		//}
		
		return PIDI;
	}
}
