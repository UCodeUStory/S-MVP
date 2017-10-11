package com.example;

import com.example.processor.InstanceProcessor;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;

/**
 * Created by qiyue on 2017/10/11.
 */

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)//java版本支持
public class AnnotationProcessor extends AbstractProcessor {
    public Filer mFiler; //文件相关的辅助类
    public Elements mElements; //元素相关的辅助类
    public Messager mMessager; //日志相关的辅助类

    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> annotations = new HashSet<>();
        annotations.add(Test.class.getCanonicalName());
        annotations.add(InstanceFactory.class.getCanonicalName());
//        return Collections.singleton(Test.class.getCanonicalName());
        return annotations;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        mFiler = processingEnv.getFiler();
        mElements = processingEnv.getElementUtils();
        mMessager = processingEnv.getMessager();
//        try {
////            notice 为什么会调用三次
//
//            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(Test.class);
//
//            for (Element element : elements) {
//                System.err.println("********开始解析注解*******"+elements.size());
//                createPersonClass();
//            }
//            System.err.println("********开始解析注解*******");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
            System.err.println("********开始解析注解*******");
            //notice 通过对象调用就可以
            new InstanceProcessor().process(roundEnvironment, this);


        return false;
    }


    private void createPersonClass() throws IOException {
        FieldSpec age = FieldSpec.builder(int.class, "age")
                .addModifiers(Modifier.PRIVATE)
                .build();
        FieldSpec name = FieldSpec.builder(String.class, "name")
                .addModifiers(Modifier.PRIVATE)
                .initializer("$S", "qiyue")
                .build();
        MethodSpec constructorMethod = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(String.class, "name")
                .addStatement("this.$N = $N", "name", "name")
                .build();
        MethodSpec getAgeMethod = MethodSpec.methodBuilder("getAge")
                .addModifiers(Modifier.PUBLIC)
                .returns(int.class)
                .addStatement("return age")
                .build();
        MethodSpec getNameMethod = MethodSpec.methodBuilder("getName")
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addStatement("return name")
                .build();

        TypeSpec typeSpec = TypeSpec.classBuilder("Person")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(getNameMethod)
                .addMethod(getAgeMethod)
                .addMethod(constructorMethod)
                .addField(age)
                .addField(name)
                .build();
        JavaFile javaFile = JavaFile.builder("com.example.person", typeSpec).build();

        javaFile.writeTo(processingEnv.getFiler());
    }
}
