import asciiPanel.AsciiPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 读取xml文件进行装载注入
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        // 获取装载的asciiPanel实例
        AsciiPanel asciiPanel = context.getBean(AsciiPanel.class);

        System.out.println("now the font name = " + asciiPanel.getAsciiFont().getFontFilename());
    }
}
