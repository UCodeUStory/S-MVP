### S-MVP
MVP 继续解耦

1.通过模块化减少了类的创建

  **之前**：接口一个类，实现一个类，这样的MVP中就会出现6个类
  
  **修改之后**：Contract类管理接口,这样的MVP中只会出现4个类
  
  **优点**：管理和维护方便
2.通过注解，隐藏Presenter创建，减少代码
  **之前**：需要在每个Activity中创建一个Presenter
  **修改之后**：在父类里拿到子类的名字进行创建，创建过程通过在要创建的Presenter添加上注解标识，在编译器动态生成代码

****
### **框架待优化**

1.查找资源可以使用ButterKnife，可以集成DataBind

2.Aspectj引入，添加动态缓存，日志

3.gradle插件开发


4.Gradle, Transfrom, Task, Plugin 区别

5.使用Javassist注入字节码
    
    Javassist是一个开源的分析、编辑和创建Java字节码的类库。是由东京工业大学的数学和计算机科学系的 Shigeru Chiba （千叶
    滋）所创建的。它已加入了开放源代码JBoss 应用服务器项目,通过使用Javassist对字节码操作为JBoss实现动态AOP框架。


 1.在build 过程我们可以通过apt 生成java文件,再通过Aspectj解析，编织成class,最后我们还可以通过Javassist修改class和jar文件，最终打包成dex 到 apk
 
 ![image](https://github.com/UCodeUStory/S-MVP/blob/master/pic.png)
 
 - Thanks
 - [Bai xiaokang](https://github.com/north2016)