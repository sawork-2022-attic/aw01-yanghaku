import asciiPanel.AsciiPanel;
import config.AsciiPanelConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 根据java类配置文件进行装载注入
        ApplicationContext context = new AnnotationConfigApplicationContext(AsciiPanelConfig.class);

        // 获取装载的asciiPanel实例
        AsciiPanel asciiPanel = context.getBean(AsciiPanel.class);

        System.out.println("now the font name = " + asciiPanel.getAsciiFont().getFontFilename());
    }
}
