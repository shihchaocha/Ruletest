package org.example;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.DefaultRulesEngine;

public class Main {
    public static void main(String[] args) {
        // 創建 Facts 對象
        Facts facts = new Facts();
        facts.put("rain", true);

        // 創建 MVEL 規則
        MVELRule weatherRule = new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when("rain == true")
                .then("System.out.println(\"It rains, take an umbrella!\");");

        // 創建 Rules 引擎
        Rules rules = new Rules();
        rules.register(weatherRule);

        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}