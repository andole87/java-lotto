package lotto;

import com.google.gson.Gson;
import lotto.domain.UserLottoSeed;
import lotto.domain.UserLottos;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebUILottoApplication {
    public static void main(String[] args) {
        externalStaticFileLocation("templates");
        staticFiles.location("templates");
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        get("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "buy.html");
        });

        post("/lotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("money", req.queryParams("money"));
            model.put("manual", req.queryParams("manual"));
            return render(model, "lotto.html");
        });

        get("/lotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "lotto.html");
        });

        Gson gson = new Gson();

        post("/userLotto", (req, res) -> {
            int manualCount;
            try {
                manualCount = Integer.parseInt(req.queryParams("manualCount"));
            } catch (NumberFormatException e) {
                manualCount = 0;
            }

            UserLottoSeed seed = new UserLottoSeed(req.queryParams("lottoMoney"), manualCount, Arrays.asList(req.queryParamsValues("manualLottos")));
            UserLottos userLottos = seed.create();
            return userLottos.tickets().stream().map(ticket -> ticket.ticketNumbers().toString()).collect(Collectors.toList());
        }, gson::toJson);

        get("/test", (req, res) -> req.queryParams(), gson::toJson);
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
