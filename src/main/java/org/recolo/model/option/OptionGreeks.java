package org.recolo.model.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionGreeks
{
    public static Logger logger = LoggerFactory.getLogger(OptionGreeks.class);

    private double rho;
    private double vega;
    private double theta;
    private double delta;
    private double gamma;
    private double iv; //
    private boolean currentValue;

    // Getters & Setters
    public double getRho()
    {
        return rho;
    }

    public void setRho(double rho)
    {
        this.rho = rho;
    }

    public double getVega()
    {
        return vega;
    }

    public void setVega(double vega)
    {
        this.vega = vega;
    }

    public double getTheta()
    {
        return theta;
    }

    public void setTheta(double theta)
    {
        this.theta = theta;
    }

    public double getDelta()
    {
        return delta;
    }

    public void setDelta(double delta)
    {
        this.delta = delta;
    }

    public double getGamma()
    {
        return gamma;
    }

    public void setGamma(double gamma)
    {
        this.gamma = gamma;
    }

    public double getIv()
    {
        return iv;
    }

    public void setIv(double iv)
    {
        this.iv = iv;
    }

    public boolean isCurrentValue()
    {
        return currentValue;
    }

    public void setCurrentValue(boolean currentValue)
    {
        this.currentValue = currentValue;
    }

    @Override
    public String toString()
    {
        return String.format("Greeks{Δ:%.3f Γ:%.4f Θ:%.3f V:%.3f IV:%.2f%%}", delta, gamma, theta, vega, iv);
    }
}
