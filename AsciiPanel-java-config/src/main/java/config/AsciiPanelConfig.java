package config;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return AsciiFont.CP437_9x16;
    }
}
