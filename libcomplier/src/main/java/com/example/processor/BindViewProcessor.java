package com.example.processor;

import com.example.AnnotationProcessor;
import com.example.IProcessor;
import com.example.bindview.$;
import com.example.bindview.ViewBinder;
import com.example.util.FieldBinding;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import static com.squareup.javapoet.MethodSpec.methodBuilder;

/**
 * Created by qiyue on 2017/10/13.
 */

public class BindViewProcessor implements IProcessor {


    private Elements elementUtils;

    private Filer filer;

    private Messager messager;

    @Override
    public void process(RoundEnvironment env, AnnotationProcessor mAbstractProcessor) {

        elementUtils = mAbstractProcessor.mElements;
        filer = mAbstractProcessor.mFiler;
        messager = mAbstractProcessor.mMessager;
        print("process:");
//        print("env"+env.getRootElements());

        /**
         * 将activity完整路径名作为key,其他被注解修饰的数据定义一个List存放,
         * 这样一个map值对应一个activity和他的数据
         */
        Map<TypeElement, List<FieldBinding>> map = new HashMap<>();

        /**
         *
         * Element也是APT的重点之一，所有通过注解取得元素都将以Element类型等待处理，也可以理解为Element的子类类型与自定义注解时用到的@Target是有对应关系的。
         *
         * TypeElement 是Element子类，表示一个类或接口程序元素。提供对有关类型极其成员的信息访问 对应@Target(ElementType.TYPE)
         *
         * getElementsAnnotatedWith返回所有被使用的@$注解元素
         */

        for (Element element : env.getElementsAnnotatedWith($.class)) {
            /**
             * 类型转换不可以强转，要同时调用getEnclosingElement方法
             *
             * TypeElement可以获取 表示一个类或接口程序元素。提供对有关类型极其成员的信息访问。
             *
             * TypeParameterElement 表示一般类、接口、方法或构造方法元素的类型参数
             *
             * ExecutableElement 表示某个类或接口的方法、构造方法或初始化程序（静态或实例），包括注释类型元素。
             *
             * PackageElement 表示一个包程序元素。提供对有关包极其成员的信息访问。
             */
            TypeElement activityElement = (TypeElement) element.getEnclosingElement();

            print(" activityElement:"+ activityElement.toString());

            /**
             * 判断当前activity是否在map中存在，如果存在，说明是相同activity的数据，直接放进去，否则新建list，放入map
             */
            List<FieldBinding> list = map.get(activityElement);

            if (list == null) {
                list = new ArrayList<>();
                map.put(activityElement, list);
            }
            /**
             * 获取注解中的参数值
             */
            int id = element.getAnnotation($.class).value();
            /**
             * 获取注解所在的 变量的名字
             */
            String fieldName = element.getSimpleName().toString();

            print(" fieldName:"+ fieldName);
            /**
             * 获取注解所在的 变量类型
             */
            TypeMirror typeMirror = element.asType();

            print("fieldtype:"+ typeMirror);
            /**
             * 自己创建的对象用来保存变量名字，类型，id
             */
            FieldBinding fieldBinding = new FieldBinding(fieldName, typeMirror, id);

            list.add(fieldBinding);
        }

        /**
         * 遍历map为每个activity生成ViewBind类，ViewBind类去实现id绑定
         */
        for (Map.Entry<TypeElement, List<FieldBinding>> item :
                map.entrySet()) {
            /**
             * 获取activity完整路径名
             */
            TypeElement activityElement = item.getKey();

            /**
             * 获取activity包名
             */
            String packageName = elementUtils.getPackageOf(activityElement).getQualifiedName().toString();
            print("packageName="+packageName);//com.wangpos.s_mvp.ui.login
            /**
             * 获取activity名字
             */
            String activityName = activityElement.getSimpleName().toString();

            //transfrom type Activity with system can discern
            print("simpleActivityName = "+activityName);//MainActivity
            ClassName activityClassName = ClassName.bestGuess(activityName);
            print("activityClassName = "+activityClassName);//MainActivity

            ClassName viewBuild = ClassName.get(ViewBinder.class.getPackage().getName(), ViewBinder.class.getSimpleName());    //
            print("viewBuild = "+viewBuild);//com.wenld.ViewBinder
            /**
             * JavaPoet登场，开始生成类
             */
            TypeSpec.Builder result = TypeSpec.classBuilder(activityClassName + "$$ViewBinder")
                    .addModifiers(Modifier.PUBLIC)
                    .addTypeVariable(TypeVariableName.get("T", activityClassName))
                    .addSuperinterface(ParameterizedTypeName.get(viewBuild,activityClassName));

            MethodSpec.Builder method = methodBuilder("bind")      //methodName
                    .addModifiers(Modifier.PUBLIC)                          // modifier
                    .returns(TypeName.VOID)
                    .addAnnotation(Override.class)
                    .addParameter(activityClassName, "target", Modifier.FINAL);
//
            List<FieldBinding> list = item.getValue();

            for (FieldBinding fieldBinding : list) {
                //
                String pacageName = fieldBinding.getType().toString();

                ClassName viewClass = ClassName.bestGuess(pacageName);

                method.addStatement("target.$L=($T)target.findViewById($L)", fieldBinding.getName(), viewClass, fieldBinding.getResId());

            }
//
            result.addMethod(method.build());

            try {
                JavaFile.builder(packageName, result.build()).build().writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /**
         *  返回值 表示这组 annotations 是否被这个 Processor 接受，如果接受（true）后续子的 pocessor 不会再对这个 Annotations 进行处理
         */

    }

    /**
     * 打印Log，在build窗口可以看到
     * Diagnostic.Kind.ERROR
     Diagnostic.Kind.WARNING
     Diagnostic.Kind.MANDATORY_WARNING
     Diagnostic.Kind.NOTE
     Diagnostic.Kind.OTHER
     * @param message
     */
    private void print(String message) {
        messager.printMessage(Diagnostic.Kind.NOTE, message);
    }
}
