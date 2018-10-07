package sample;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

public class Method implements SeachTime{
    CountDownLatch latch;
    String function;
    BigDecimal x0;
    BigDecimal x1;
    BigDecimal tol;
    BigDecimal functionx0;
    BigDecimal functionx1;
    String perem;
    int cond = 0;
    long iter = 0;
    int iteration;
    int itermax;
    long timeMax;
    long startTime;
    long timeLimit;
    long resultTime;
    long pauseTimeStart;

    @Override
    public void StartPause() {
        pauseTimeStart = System.currentTimeMillis();
    }

    @Override
    public void StopPause() {
        startTime = startTime + (System.currentTimeMillis() - pauseTimeStart);
    }
    public void SearchMin(){
        if(functionx0.compareTo(functionx1)<=0){
            x1=x0;
            functionx1=functionx0;
        }
        else {
            x0=x1;
            functionx0=functionx1;
            x1 = x0.add(tol);
            functionx1=new Expression(function).with(perem,x1).eval();
        }
    }
    public void SearchMax(){
        if(functionx0.compareTo(functionx1)>=0){
            x1=x0;
            functionx1=functionx0;
        }
        else {
            x0=x1;
            functionx0=functionx1;
            x1 = x0.add(tol);
            functionx1=new Expression(function).with(perem,x1).eval();
        }
    }
}
