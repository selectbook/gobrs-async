package com.jd.gobrs.gobrs.async.example.service;

import com.jd.gobrs.async.task.AsyncTask;
import com.jd.gobrs.async.task.TaskResult;
import com.jd.gobrs.async.wrapper.TaskWrapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: gobrs-async-example
 * @ClassName AService
 * @description:
 * @author: sizegang
 * @create: 2022-01-29 21:01
 * @Version 1.0
 **/
@Service
public class AService implements AsyncTask<String, Map> {

    @Override
    public Map doTask(String s, Map<String, TaskWrapper> map) {
        System.out.println("开始执行A");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("result", "I am is AService");
        return objectObjectHashMap;
    }

    @Override
    public boolean nessary(String s) {
        return true;
    }

    @Override
    public void result(boolean b, String s, TaskResult<Map> taskResult) {
        if (b) {
            System.out.println("AService success");
        } else {
            System.out.println("AService fail");
        }
    }
}
