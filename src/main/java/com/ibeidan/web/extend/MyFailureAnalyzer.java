package com.ibeidan.web.extend;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @author lee
 * @DATE 2020/4/23 18:59
 */
public class MyFailureAnalyzer extends AbstractFailureAnalyzer {



    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, Throwable cause) {
        System.out.println("自定义 MyFailureAnalyzer ----");
        return null;
    }
}
