package co.com.t_evolvers.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class GetText{

    public GetText() {
    }

    public static String getText(Actor actor, Target objeto){
       return Text.of(objeto).answeredBy(actor);
   }

    public static String getTextPrice(Actor actor, Target objeto){
        return Text.of(objeto).answeredBy(actor).split(" \\*includes tax")[0].substring(1);
    }
}
