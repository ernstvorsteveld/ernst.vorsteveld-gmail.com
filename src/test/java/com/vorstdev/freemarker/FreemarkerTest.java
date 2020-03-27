package com.vorstdev.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FreemarkerTest {

    @Test
    public void should_add_spaces() throws IOException, TemplateException {
        Configuration cfg = new Configuration(new Version(2, 3, 30));

        cfg.setClassForTemplateLoading(FreemarkerTest.class, "/templates");

        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.UK);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("title", "Freemarker Example");

        User user = expectUser();
        input.put("user", user);
        input.put("otp", "12345");

        Template template = cfg.getTemplate("voice-otp.ftl");

        // 2.3. Generate the output

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);
    }

    private User expectUser() {
        return new User("first", "middle", "last");
    }
}
