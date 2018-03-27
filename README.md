# ReflectUtils
利用Java反射技术实现的一些工具类，目前提供有两个工具类：<br/>

| 名称 | 描述 |
|------|---------|
| [AttributeCopyer](#attributecopyer) | 把父类转成子类对象 |
| [ResponseUtil](#responseutil)    | 对象转成json时只转指定的字段|


## AttributeCopyer
可以把父类转成子类对象，使用方法：
```java
//把父类F的所有属性复制给子类C
static void copy(F f, C c);

//把父类F克隆成子类C
static C clone(F father, Class<C> clazz);
```
Java可以把一个子类转换成它的父类，但是不能把父类转成子类，此工具类正弥补了这一不足。
 
## ResponseUtil
移除对象的部分属性，有时我们把对象转成json数据时，想让一部分属性不参与转换，通过此工具类可以只转换制定字段：
```java
//输出对象T的制定字段fileds
static Map<String, Object> getResultMap(T t, String[] fileds);

//
static List<Map<String, Object>> getResultMap(List<T> ts, String[] fileds)
```
使用示例：
```java
//输出User部分属性
User user = new User("1", "张三", 21, "男");
String[] fileds = new String[]{"name","age"};
String json = JSON.toJSONString(ResponseUtil.getResultMap(user,fileds));

//输出结果
{"name": "张三", "age": 21}
```
