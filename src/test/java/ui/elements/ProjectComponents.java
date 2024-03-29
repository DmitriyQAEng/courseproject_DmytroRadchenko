package ui.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class ProjectComponents {
    public static SelenideElement newProjectField(){
        return $(By.xpath("//body/section[1]/section[1]/div[1]/ul[1]/li[1]/a[1]"));
    }
    public static SelenideElement formNameProjectField(){
        return $("#form-name");
    }
    public static SelenideElement identifierProjectField(){
        return $(By.xpath("//input[@id='form-identifier']"));
    }
    public static SelenideElement columnTaskProjectField(){
        return $("div:nth-child(2) section:nth-child(1) form:nth-child(2) label:nth-child(9) > input:nth-child(1)");
    }
    public static SelenideElement formTaskLimitField(){
        return $("#form-task_limit");
    }
    public static SelenideElement saveField(){
        return $(By.xpath("//button[contains(text(),'Save')]"));
    }
    public static SelenideElement dropdownProjectField(){
        return $(By.xpath("//body/section[1]/section[1]/div[1]/div[1]/div[1]/a[1]/i[2]"));
    }
    public static SelenideElement myProjects(){
        return $(By.xpath("//a[contains(text(),'TestProjectDmitro')]"));
    }
    public static SelenideElement myProjects(String text){
        return $(By.xpath("//a[contains(text(),'"+text+"')]"));
    }
    public static SelenideElement configureProject(){
        return $(By.xpath("//body/div[@id='dropdown']/ul[1]/li[10]/a[1]"));
    }
    public static SelenideElement removeProjectField(){
        return $(By.xpath("//a[contains(text(),'Remove')]"));
    }
}