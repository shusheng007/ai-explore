package top.ss007.openaiexplore.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import top.ss007.openaiexplore.domain.GovReport;
import top.ss007.openaiexplore.domain.Student;

@AiService
public interface AugurAiService {

    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);

    @UserMessage("Does {{input}} has a positive sentiment?")
    boolean isPositive(@V("input") String text);


    @UserMessage("Extract information about a student from {{it}}")
    Student extractStudentFrom(String text);


    @UserMessage("总结一下这个网页{{it}}的重要信息")
    String summaryPageContent(String url);


    @UserMessage("中国2024年政府工作报告要点都有什么?")
    GovReport summaryReport();
}
