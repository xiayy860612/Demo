# Bean的生命周期

- 了解Bean的

## Bean Definition

### 配置

### 解析

### 

## Bean

基于BeanDefinition进行生成

Autowiring的三中方式, 详见AutowireCapableBeanFactory

- 实例化
  + InstantiationAwareBeanPostProcessor, 可以在实例化前后挂钩子
  + InstantiationStrategy，针对默认无参构造器进行bean创建
    - SimpleInstantiationStrategy, Java反射创建
    - CglibSubclassingInstantiationStrategy
  + ConstructorResolver.autowireConstructor，针对有参构造器，
    参数的注入会通过类型方式进行查找相关的bean，而不是名字(变量名)，然后注入
      + AutowireCapableBeanFactory.resolveDependency
- 属性填充
- 初始化

- AbstractAutowireCapableBeanFactory.doCreateBean，创建Bean完整流程
  + AbstractAutowireCapableBeanFactory.createBeanInstance，实例化
    - AbstractAutowireCapableBeanFactory.instantiateBean
  + AbstractAutowireCapableBeanFactory.populateBean，属性填充
  + 

创建Bean的方式:
- 通过提供Supplier给BeanDefinition来创建
- 通过提供

```plantuml
participant AC as "ApplicationContext"
participant BF as "AbstractAutowireCapableBeanFactory"
participant IBPP as "InstantiationAwareBeanPostProcessor"
participant IS as "InstantiationStrategy"
participant CR as ConstructorResolver

AC --> BF: getBean
activate BF
BF --> BF: createBean
BF --> IBPP: postProcessBeforeInstantiation
alt not null
BF --> AC: return proxy or instance
end

BF --> BF: doCreateBean
activate BF

BF --> BF: createBeanInstance
activate BF

alt default constructor
BF --> IS: instantiate
else constructor with params
BF --> CR: autowireConstructor
end
deactivate BF

BF --> BF: populateBean

```

## Reference

- [小马哥讲Spring核心编程思想 --- Spring Bean生命周期](https://time.geekbang.org/course/detail/100042601-209708)
