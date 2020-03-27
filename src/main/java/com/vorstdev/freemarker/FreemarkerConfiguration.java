package com.vorstdev.freemarker;

import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.IOException;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreemarkerConfiguration {

    @Bean
    public freemarker.template.Configuration configuration() {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(new Version(2, 3, 30));
        cfg.setClassForTemplateLoading(FreemarkerConfiguration.class, "/templates");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.UK);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }


    @Bean
    public Template template(freemarker.template.Configuration configuration) throws IOException {
        return configuration.getTemplate("voice-otp.ftl");
    }
}
