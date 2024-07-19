package com.example.demo.customAnnotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Random;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
public @interface RandomField {

    public int min =  0; // Minimum value for randomization
    public int max = 1000000; // Maximum value for randomization

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
}
