package com.example.spring_practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (bean.getClass().isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if (beanClass != null) {
            //Создает новый объект из нового класса, который сгенерит он же на лету.
            //логика, которая будет в каждом методе сгенеренном на лету через прокси
            return Proxy.newProxyInstance(beanClass.getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                if (controller.isEnabled()) {
                    System.out.println("Profiling started...");
                    long before = System.nanoTime();
                    Object returnValue = method.invoke(bean, args);
                    long after = System.nanoTime();
                    double seconds = (after - before) / 1_000_000_000.0;  // конвертация в секунды
                    System.out.printf("Profiling finished. Time: %.6f seconds%n", seconds);
                    return returnValue;
                } else {
                    return method.invoke(bean, args);
                }
            });
        }
        return bean;
    }
}
