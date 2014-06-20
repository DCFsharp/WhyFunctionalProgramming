package com.company;

import java.lang.Integer;
import java.util.HashSet;
import java.util.Set;
import static java.lang.Math.sqrt;

// Internal State, common in OOP because utilize encapsulation
// composed
// testable

public class ImperativeNumberClassifier {
    private Set<Integer> _factors;
    private int _number;
    private int _sum;

    public ImperativeNumberClassifier(int targetNumber) {
        _number = targetNumber;
       _factors = new HashSet<Integer>();
        _factors.add(1);
        _factors.add(_number);
        _sum = 0;
    }

    public boolean isFactor(int factor) {
        return _number % factor == 0;
    }

    private void calculateFactors(){
        for(int i = 0; i <= sqrt(_number) + 1; i++) {
            if(isFactor(i))
                addFactor(i);
        }
    }

    private void addFactor(int factor){
        _factors.add(factor);
        _factors.add(_number / factor);
    }

    private void sumFactor(){
        calculateFactors();
        for(int i : _factors){
            _sum += i;
        }
    }

    private int getSum(){
        if(_sum == 0)
            sumFactor();
        return _sum;
    }

    public boolean isPerfect() {
        return getSum() - _number == _number;
    }

    public boolean isAbundant(){
        return getSum() - _number > _number;
    }

    public boolean isDeficient() {
        return getSum() - _number < _number;
    }
}