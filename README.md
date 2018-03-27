# ReflectUtils
利用Java反射技术实现的一些工具类，使用场景虽然有限，但还是有需求的，也可以作为学习反射的参考

## AttributeCopyer
可以把父类转成子类对象，使用方法：
```java
//把父类F的所有属性复制给子类C
static void copy(F f, C c);

//把父类F克隆成子类C
static C clone(F father, Class<C> clazz);
```
Java可以把一个子类转换成它的父类，但是不能把父类转成子类，
