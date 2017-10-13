### S-MVP
MVP 继续解耦

1.通过模块化减少了类的创建

  **之前**：接口一个类，实现一个类，这样的MVP中就会出现6个类
  
  **修改之后**：Contract类管理接口,这样的MVP中只会出现4个类
  
  **优点**：管理和维护方便
2.通过注解，隐藏Presenter创建，减少代码
  **之前**：需要在每个Activity中创建一个Presenter
  **修改之后**：在父类里拿到子类的名字进行创建，创建过程通过在要创建的Presenter添加上注解标识，在编译器动态生成代码


3.添加Gradle插件使用Aspectj编译器

4.通过Aspectj 实现TimeLog耗时打印，自定义Buidlconfig实现开关

5.添加Lru缓存切片通过使用@MemoryCache注解

6.添加登陆缓存切片用来检测是否登陆

7.添加异常捕获，打印，保证程序不崩溃

8.自定义BindView框架，通过@$(R.id.abc)作用在public类型的变量即可




****
### **框架待优化**


1.查找资源可以使用ButterKnife，可以集成DataBind可以考虑

2.EventBus,otto都可以考虑使用

4.Gradle, Transfrom, Task, Plugin 区别

5.使用Javassist注入字节码,这是一个很好的字节码编辑工具，提供在JVM运行期前修改的api
    
    Javassist是一个开源的分析、编辑和创建Java字节码的类库。是由东京工业大学的数学和计算机科学系的 Shigeru Chiba （千叶
    滋）所创建的。它已加入了开放源代码JBoss 应用服务器项目,通过使用Javassist对字节码操作为JBoss实现动态AOP框架。
    
7.路由实现简单的跳转，路由器也是用来解耦的，增加后台可配置性

  

AOP技术常用在以下方面：

1、日志记录：业务埋点

2、持久化

3、性能监控：性能日志

4、数据校验：方法的参数校验

5、缓存：内存缓存和持久缓存

6、权限检查：业务权限（如登陆，或用户等级）、系统权限（如拍照定位）

7、异常处理


 1.在build 过程我们可以通过apt 生成java文件,再通过Aspectj解析，编织成class,最后我们还可以通过Javassist修改class和jar文件，最终打包成dex 到 apk
 
 ![image](https://github.com/UCodeUStory/S-MVP/blob/master/pic.png)
 
 - Thanks
 - [Bai xiaokang](http://note.youdao.com/)