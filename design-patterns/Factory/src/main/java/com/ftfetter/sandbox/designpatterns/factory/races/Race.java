package com.ftfetter.sandbox.designpatterns.factory.races;

import com.ftfetter.sandbox.designpatterns.factory.classes.Class;

public interface Race {

    Class getClass(String className);
}
