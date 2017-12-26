package com.example.processor;

import com.example.AnnotationProcessor;
import com.example.IProcessor;
import com.example.bindview.$;
import com.example.bindview.OnResume;
import com.example.util.FieldBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Created by qiyue on 2017/11/6.
 *
 * 通过自定义注解 @OnResume 标识一个方法执行的生命周期
 *
 *
 *
 * 注解解析器获取这些注解,在自己的类的父亲类的onResume中插入这个方法调用，在Activity的 父亲类中插入代码调用
 */

public class LifeProcessor implements IProcessor {

    @Override
    public void process(RoundEnvironment env, AnnotationProcessor mAbstractProcessor) {
//        Map<TypeElement, List<MethodBinding>> map = new HashMap<>();

//        for (Element element : env.getElementsAnnotatedWith(OnResume.class)) {
//            /**
//             * 类型转换不可以强转，要同时调用getEnclosingElement方法
//             *
//             * TypeElement可以获取 表示一个类或接口程序元素。提供对有关类型极其成员的信息访问。
//             *
//             * TypeParameterElement 表示一般类、接口、方法或构造方法元素的类型参数
//             *
//             * ExecutableElement 表示某个类或接口的方法、构造方法或初始化程序（静态或实例），包括注释类型元素。
//             *
//             * PackageElement 表示一个包程序元素。提供对有关包极其成员的信息访问。
//             */
//            TypeElement activityElement = (TypeElement) element.getEnclosingElement();
//
//            print(" activityElement:"+ activityElement.toString());
//
////            /**
////             * 判断当前activity是否在map中存在，如果存在，说明是相同activity的数据，直接放进去，否则新建list，放入map
////             */
////            List<FieldBinding> list = map.get(activityElement);
////
////            if (list == null) {
////                list = new ArrayList<>();
////                map.put(activityElement, list);
////            }
//            /**
//             * 获取注解中的参数值
//             */
////            int id = element.getAnnotation($.class).value();
//
//        }
    }
}
