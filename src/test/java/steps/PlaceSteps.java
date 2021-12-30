package steps;

import api.ApiHeaders;
import api.ApiRequest;
import api.ApiUtils;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import user.UserLombok;
import utils.JsonUtils;
import utils.PropertiesUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceSteps extends ApiRequest {
    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    UserLombok user;

    @Dado("que passou placeHolder token valido")
    public void que_passou_place_holder_token_valido() {
        System.out.println("API Não requer token");

    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() {
        super.uri = prop.getProp("uri_place");
        super.headers = apiHeaders.placeHeaders(token);
        user = UserLombok.builder()
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .body("primeiro commit")
                .build();

        super.body = new JSONObject(new Gson().toJson(user));
        super.POST();

    }

    //corrigir essa validação
    @Entao("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() {

    }

    @Entao("o status code do request deve ser {int}")
    public void o_status_code_do_request_deve_ser(Integer statusCode) {


    }
    @Dado("possua um usuario Cadastrado no api")
    public void possua_um_usuario_cadastrado_no_api() {
        envio_um_request_de_cadastro_de_usuario_com_dados_validos();
    }

    @Dado("buscar esse usuário")
    public void buscar_esse_usuário() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id");
        super.headers = apiHeaders.placeHeaders(token);
        super.body = new JSONObject();
        super.GET();

    }
    @Quando("os dados dos usuario serem retornados")
    public void os_dados_dos_usuario_serem_retornados() {

    }
    @Dado("altere os desse usuário")
    public void altere_os_desse_usuário() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id");
        super.headers = apiHeaders.placeHeaders(token);
        user.setName("Paola");
        super.body = new JSONObject(new Gson().toJson(user));
        super.PUT();

    }
    @Quando("os dados serem alterados com sucesso")
    public void os_dados_serem_alterados_com_sucesso() {

    }
    @Dado("delete esse usuário")
    public void delete_esse_usuário() {
        super.uri = prop.getProp("uri_gorest") + "/" + response.jsonPath().getJsonObject("id");
        super.headers = apiHeaders.placeHeaders(token);
        super.body = new JSONObject();
        super.DELETE();

    }
    @Quando("o usuario é deletado com sucesso")
    public void o_usuario_é_deletado_com_sucesso() {

    }





}
