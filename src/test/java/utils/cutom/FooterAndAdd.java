package utils.cutom;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FooterAndAdd {
    public void deleteFooterAndAdd(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#app footer').remove()");
    }
}
