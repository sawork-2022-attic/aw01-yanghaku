# work-01

请参考课件内给的示例（[sa-spring/cashregister](https://github.com/sa-spring/cashregister) ），用Spring container的三种configuration中的任意一种，将[AsciiPanel](https://github.com/trystan/AsciiPanel)改造为一个构件系统，要求可以创建`AsciiPanel`和不同的`AsciiFont`构件，并将其进行组装并运行。

例如，可将`CP437_9x16`的`AsciiFont`组装进`AsciiPanel`，

![](https://www.plantuml.com/plantuml/png/SoWkIImgAStDuOfsB4xEp0n8p4lDYLNGrRLJW0YuvUULw3e7c1YRnrjM69h5SZcavgK0rGC0)

或将`CP437_8x8`的`AsciiFont`组装进`AsciiPanel`。

![](https://www.plantuml.com/plantuml/png/SoWkIImgAStDuOfsB4xEp0n8p4lDYLNGrRLJW0YuvUULw3e7c1YRnrjKMCHoEQJcfG2L0m00)

要求Maven工程项目代码，参考示例（[sa-spring/cashregister](https://github.com/sa-spring/cashregister) ），实现至少两个不同的构件系统configration，且包含可直接运行的main函数。



### xml-config

You can modify the ```config.xml```, choose the font, then run ```mvn test``` to run ```Main.java```

```xml
<!-- 前面是所有的种类的font实例, 后面可以任意注入到 asciiPanelTest 实例 -->

<bean id="asciiPanelTest" class="asciiPanel.AsciiPanel">
    <property name="asciiFont" ref="fontCP437_12x12"/>
    <!--  <property name="asciiFont" ref="fontCP437_16x16"/>  -->
    <!--  <property name="asciiFont" ref="fontCP437_8x8"/>    -->
    <!-- ......... -->
</bean>

```



### annotation-config

You can modify the ```ascii-panel-values.properties```, edit the font construct paraments,  then  run ```mvn test``` to run ```Main.java```

```
// file: ascii-panel-values.properties

fontFilename=cp437_9x16.png
fontWidth=9
fontHeight=16
```



### java-config



You can modify ```java/config/AsciiPanelConfig.java```, edit the ```asciiFont``` to choose font. Then run ```mvn test``` to run ```Main.java```

```java
/**
 * Configuration 相当于一个config.xml
 */
@Configuration
public class AsciiPanelConfig {
    @Bean
    public AsciiPanel asciiPanel() {
        return new AsciiPanel();
    }

    @Bean
    public AsciiFont asciiFont() {
        return AsciiFont.CP437_9x16;  // edit here
    }
}
```





### test result

```shell
(.....)aw01-yanghaku/AsciiPanel-java-config> mvn test

......
......

[INFO] --- exec-maven-plugin:3.0.0:java (default) @ AsciiPanel-java-config ---
now the font name = cp437_9x16.png
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

......
......

```



