package com.example.demo.customAnnotation;

import java.lang.reflect.Field;
import java.util.Random;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RandomDigits {
	@AfterReturning("@annotaion(randomDigits")
	public void random(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
		Field[] fields = objClass.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(RandomField.class)) {
            	RandomField annotation = field.getAnnotation(RandomField.class);
                field.setAccessible(true);
                int min = annotation.min;
                int max = annotation.max;
                int randomizedValue = new Random().nextInt(min, max);
                field.set(obj, randomizedValue);
            }
        }
	}
}
