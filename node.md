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
    
IOC：得到一些特殊的bean
AOP: 通过Java特殊的bean，实现实例的增强

JDK：invocationHander，Proxy，反射....// 要实现接口才能代理
CGLIB：继承要被动态代理的类// 继承

AnnotationAwareAspectJAutoProxyCreator.class 贯穿了整个IOC

AOP 事务

    类如：
    @Transactional
    private void invoke(){
    }
    
    原理：
    transactionManager.beginTransaction();
    try{
        invoke method()
    }
    except{
        rollback
    }finally{
        if no error then commit
    }
    
BeanFactoryPostProcessor -> 

    执行时机比较早，在这里面加载了所有预先定义的 Bean，包括所有的 Processor 和自定义的 Bean，但此时还未实例化 

BeanDefinitionRegistryPostProcessor -> bean

## IOC 源码分析 

refresh() 方法流程[创建、刷新]

1、synchronized 关键字锁定当前容器（避免多线程共享问题）

2、prepareRefresh(): 刷新前的预处理
    
    1、initPropertySources();初始化一些属性设置，子类自定义个性化的属性设置方法
    2、getEnvironment().validateRequiredProperties();检验属性的合法性
    3、this.earlyApplicationEvents 保存容器中的一些早期事件
    
3、obtainFreshBeanFactory()获取或创建beanFactory

    1、refreshBeanFactory()刷新或创建beanFactory
    2、getBeanFactory()将刚生成的beanFactory返回
    
4、prepareBeanFactory(beanFactory); beanFactory的准备工作（前面创建的beanFactory只有一些默认值）

    1、setBeanClassLoader(getClassLoader());设置beanFactory的类加载器
       setBeanExpressionResolver加入表达式解析器
       ignoreDependencyInterface设置忽略的自动装配接口（EnvironmentAware、ApplicationContextAware等）
       registerResolvableDependency(BeanFactory.class, beanFactory); 注册可以解析的自动装配：能直接在任何组件中自动注入，如BeanFactory、ResourceLoader等
       addBeanPostProcessor(new ApplicationListenerDetector(this));添加监听检测的处理器
       加入环境变量
    1、添加ApplicationContextAwareProcessor处理器



## MySQL 索引

Explain查看

索引的key_len计算方式

    1、UTF-8 3个字节
    2、varchar 需要加 2 个字节保存长度
    3、null +1 长度
    
    全职匹配我最爱，最左前缀要遵守；
    带头大哥不能死，中间兄弟不能断；
    索引列上少计算，范围之后全失效
    LIKE百分写最右，覆盖索引不写星；
    不等空值还有or，索引失效要少于；
    VAR引号不可丢，SQL高级也不
    
    - 范围查询的索引要放到符合索引的最后
    
    最佳左前缀原则：
    带头大哥不能死，中间兄弟不能断
    
    策略：
    1、尽量全值匹配
    2、最佳左前缀法则
    3、不再索引列上做任何操作
    4、范围条件放最后
    5、覆盖索引尽量用
    6、不等于要慎用
    7、null/Not 有影响
    8、like查询要当心
    9、字符类型加引号
    10、or 改 union 效率高