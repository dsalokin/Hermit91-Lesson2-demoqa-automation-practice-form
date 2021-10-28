package gmail.salokin1991;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
//        Configuration.browserSize = "1920x1080";

    }

    @Test
    void firstTest() {

        String uFN = "V V";               //first name
        String uLN = "P";               //last name
        String uE = "Some@a.com";       //email
        String mN = "1234567890";       //mobile number
//        String bD1 = "27";                //birth day
        String bD2 = "7";                //birth day error
        String bM = "10";               //birth month
        String bY = "1952";             //birth year
        String iSubj1 = "History";       //subject
        String iSubj2 = "Sports";       //subject
        String cA = "Covid bunker";     //current address

        String cState = "NCR";          //state
        String cCity = "Delhi";         //city

        String meme = "src/test/pictures/meme.jpg";
                                        //picture link

        open("https://demoqa.com/automation-practice-form");

        $("#close-fixedban").click();           //close ad

        $("#firstName").setValue(uFN);          //input first name
        $("#lastName").setValue(uLN);           //input lastname
        $("#userEmail").setValue(uE);           //input email
        $("#userNumber").setValue(mN);          //input mobile number
        $("#currentAddress").setValue(cA);      //input address

        $("#dateOfBirthInput").click();         //input birth date
        $(".react-datepicker__month-select").selectOptionByValue(bM);
        $(".react-datepicker__year-select").selectOptionByValue(bY);
//        $$(".react-datepicker__day").find(text(bD1)).click();
        $$(".react-datepicker__day").find(text(bD2)).click();


        $(byText("Other")).click();            //sex input

        $("#subjectsInput").click();            //input subject
        $("#subjectsInput").setValue(iSubj1).pressEnter();
        $(byText(iSubj2)).click();

        $("#submit").scrollIntoView(true);      //view submit button

        $("#state").click();                    //input state and city
        $(byText(cState)).click();
        $("#city").click();
        $(byText(cCity)).click();


        File image = new File(meme);                     //upload image
        $("#uploadPicture").uploadFile(image);

        $("#submit").click();

//

    }
}