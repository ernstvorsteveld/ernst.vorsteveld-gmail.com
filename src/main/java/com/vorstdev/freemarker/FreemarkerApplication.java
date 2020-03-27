package com.vorstdev.freemarker;

import freemarker.template.Template;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreemarkerApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(FreemarkerApplication.class);

    public static void main(String[] args) {
        logger.info("Starting.....");
        SpringApplication.run(FreemarkerApplication.class, args);
        logger.info("Done!");
    }

    @Autowired
    private Template template;

//    @Autowired
//    private Configuration configuration;

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("title", "Freemarker Example");

        User user = new User("Victor", "", "Boer");
        input.put("user", user);
        input.put("otp", "12345");

        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);
    }
}
