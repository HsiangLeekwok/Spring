# Spring 学习

### 2019/03/30

#### 告诉Spring这是一个配置类

1、@Configuration
```JAVA
class Test{}
```
2、与beans.xml的联系

#### @ComponentScan扫描规则

1、指定扫描规则

    1、扫描范围
    
#### @Scope扫描规则

1、单实例bean

2、多实例bean

    IOC容器：
        多实例：仅当 bean 被使用的时候才创建
        单实例：创建 IOC 容器的时候创建

3、request和session

#### @Lazy懒加载

1、什么是懒加载

    IOC容器在加载的时候不创建相应的bean，只有在使用到的时候才会创建这个bean并加入到容器里，且这个bean为单实例

2、懒加载如何获取容器中的bean

#### Bean的生命周期

    Bean的生命周期指Bean创建 -> 初始化 -> 销毁的过程
    可以自定义Bean的初始化和销毁方法，用 @Bean(initMethod, destroyMethod)
    容器在 bean 进行到当前生命周期的时候，来调用自定义的初始化和销毁方法
    
声明周期 - 初始化与销毁1

1、指定初始化init-method方法
2、指定销毁destroy-method方法

    注：
        对于单实例的bean，可以正常调用初始化和销毁方法
        对于多实例的bean，容器只负责初始化，但不会管理bean，容器关闭是不会调用destroy方法

生命周期 - 初始化与销毁2

1、实现initializingBean接口的afterPropertiesSet()方法，当beanFactory创建好对象，且把bean所有属性设置好之后，会调用这个方法，相当于初始化方法

2、实现DisposableBean的destroy()方法，当bean销毁时，会把单实例bean销毁

声明周期 - 初始化与销毁3

可以使用JSR250规则定义的(java规范)两个注解来实现

    @PostConstructor：在bean创建完成，且属于赋值完成后进行初始化，属于JDK规范的注解
    @PreDestory：在bean将被移除之前进行通知，在容器销毁之前进行清理工作
    
    PS：JSR是由JDK提供的一组规范
    
生命周期 - BeanPostProcessors

bean的后置处理器，在bean初始化之前调用进行拦截，在bean初始化前后进行一些处理工作

    使用BeanPostProcessors如何控制Bean的生命周期：
    实现BeanPostProcessors的两个接口即可
    1、postProcessBeforeInitializtion()
    2、postProcessAfterInitialization()
    
容器启动加载配置类 -> refresh() -> finishBeanFactoryInitialization() -> getBean() -> doCreateBean() -> beanWrapper(对象的创建) -> populated(属性赋值) -> initializate() -> processors

IOC bean初始化放到容器(Map)

@Autowired @Qualifier @Primary自动装配

什么是自动装配？
    
    spring利用依赖注入（DI）完成对IOC容器中的各个组件的依赖关系赋值
    
思考与操作：

    1、bean组件加载优先级？
    2、如果容器中存在两个id相同的bean，会加载哪个bean呢？
    3、如何制定装配组建ID进行加载？@Qualifier
    4、容器加载不存在的bean会出现什么问题？
    5、@Primary注解bean首选如何使用？
    6、@Autowired @Resource @Inject区别？
    
IOC+
AOP: 通过Java特殊的bean，实现实例的增强